package lv.helloit.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XorCipherTest {

    @Test
    void encrypt() {
        XorCipher cipher = new XorCipher();
        String message = "CAT";

        String encrypted = cipher.encrypt("GeeksforGeeks", "P");
        String decrypted = cipher.encrypt(encrypted, "P");

        assertEquals("GeeksforGeeks", decrypted);



    }
}