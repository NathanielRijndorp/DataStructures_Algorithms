import javax.swing.*;

public class Cipher {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Put input");
        int shift = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog(null, "Put shift")));
        String encryptCipher = caesarCipher(input,shift);
        String decryptCipher = caesarDecrypt(encryptCipher,shift);
    }
    public static String caesarCipher (String input, int shift) {
        int num = input.length();
        char[] c = new char[num];
        char[] shifted = new char[num];
        String hold = "";
        for (int i = 0 ; i < num; i++) {
            c[i] = input.charAt(i);
            if ( (int) (c[i] + shift) > 122) {
                shifted[i] = (char) (c[i] + shift - 26);
            } else if ((Character.isWhitespace(c[i]))) {
                shifted[i] = ' ';
            } else {
                shifted[i] = (char) (c[i] + shift);
            }
            hold+= String.valueOf(shifted[i]);
        }
        System.out.println(hold);
        return hold;
    }
    public static String caesarDecrypt (String encryptCipher, int shift) {
        String hold = "";
        int num = encryptCipher.length();
        char[] c = new char[num];
        char[] shifted = new char[num];

        for (int i = 0 ; i < num; i++) {
            c[i] = encryptCipher.charAt(i);
            if (Character.isDigit(c[i] - shift)) {
                shifted[i] = ' ';
            } else if ((Character.isWhitespace(c[i]))) {
                shifted[i] = ' ';
            }  else if (!Character.isLetter(c[i] - shift)) {
                shifted[i] = (char) (c[i] - shift + 26);
            } else {
                shifted[i] = (char) (c[i] - shift);
            }
            hold+=shifted[i];
        }
        System.out.println(hold);
        return hold;
    }
}
