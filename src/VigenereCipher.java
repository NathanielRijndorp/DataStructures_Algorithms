public class VignereCipher {
    public class VigenereCipher {
        private String plaintext, ciphertext, decrypted, keyword;
        private char letter = '\0';

        public VigenereCipher() {

        }
        public VigenereCipher(String plaintext) {
            setPlaintext(plaintext);
        }
        public VigenereCipher(String plaintext, String keyword) {
            setPlaintextAndKeyword(plaintext, keyword);
        }
        public void setPlaintext(String plaintext) {
            this.plaintext = plaintext;
        }
        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
        public void setPlaintextAndKeyword(String plaintext, String keyword) {
            setPlaintext(plaintext);
            setKeyword(keyword);
        }

        public String getCiphertext() {
            return ciphertext;
        }
        public String getPlaintext() {
            return plaintext;
        }
        public String getKeyword() {
            return keyword;
        }
        public String getDecrypted() {
            return decrypted;
        }

        public void encrypt() {
            ciphertext = "";
            plaintext = plaintext.toUpperCase();
            keyword = keyword.toUpperCase();
            for (int a = 0, b = 0; a < plaintext.length(); a++) {
                letter = plaintext.charAt(a);
                if (letter < 'A' || letter > 'Z') {
                    ciphertext += letter;
                } else {
                    letter = (char)((letter + keyword.charAt(b) - 2 * 'A') % 26 + 'A');
                    ciphertext += letter;
                    b = ++b % keyword.length();
                }
            }
        }
        public String encrypt(String plaintext, String key) {
            setPlaintextAndKeyword(plaintext, key);
            encrypt();
            return getCiphertext();
        }

        public void decrypt() {
            decrypted = "";
            ciphertext = ciphertext.toUpperCase();
            keyword = keyword.toUpperCase();
            for (int a = 0, b = 0; a < plaintext.length(); a++) {
                letter = ciphertext.charAt(a);
                if (letter < 'A' || letter > 'Z') {
                    decrypted += letter;
                } else {
                    letter = (char)((letter - keyword.charAt(b) + 26 ) % 26 + 'A');
                    decrypted += letter;
                    b = ++b % keyword.length();
                }
            }
        }
        public String decrypt(String ciphertext, String key) {
            decrypt();
            return decrypted;
        }
    }
}
