package lv.helloit.bootcamp;

public class Cipher {
//    private int shifter = 3;

    String encrypt(String raw, int key) {
//        raw = raw.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            char symbol = raw.charAt(i);
            // A - 65
            // Z - 90
//            char encrypted = ( (symbol + this.shifter) > 90) ? ((char)(symbol + this.shifter - 26)): ((char)(symbol + this.shifter));
            char encrypted = (char) (symbol + key);
            result.append(encrypted);
        }

        return result.toString();
    }

    String decrypt(String encrypted, int key) {
        return encrypt(encrypted, -key);
    }

    String encryptVigenere(String raw, String key) {
        StringBuilder result = new StringBuilder();
        int length = key.length();
        for (int i = 0; i < raw.length(); i++) {
            char symbol = raw.charAt(i);
            int j = i % length;
            char keyNumber = key.charAt(j);
            char encrypted = (char) (symbol + keyNumber);
            result.append(encrypted);
        }
        return result.toString();
    }

    String decryptVigenere(String encrypted, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            char symbol = encrypted.charAt(i);
            int j = i % key.length();
            char keyNumber = key.charAt(j);
            char decrypted = (char) (symbol - keyNumber);
            result.append(decrypted);
        }
        return result.toString();
    }
}
