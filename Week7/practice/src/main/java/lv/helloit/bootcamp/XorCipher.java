package lv.helloit.bootcamp;

public class XorCipher {

    String encrypt(String raw, String key) {
        int keyLen = key.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            byte rawNum = (byte) raw.charAt(i);
            int j = i % keyLen;
            byte keyNum = (byte) key.charAt(j);

            char c = (char) (rawNum ^ keyNum);
            result.append(c);
        }

        return result.toString();
    }

//    String encrypt(String raw, int key) {
//        int rawLen = raw.length();
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < raw.length(); i++) {
//            byte rawNum = (byte) raw.charAt(i);
//            int j = i % rawLen;
//            byte keyNum = (byte) key.charAt(j);
//
//            char c = (char) (rawNum ^ keyNum);
//            result.append(c);
//        }
//
//        return result.toString();
//    }
}
