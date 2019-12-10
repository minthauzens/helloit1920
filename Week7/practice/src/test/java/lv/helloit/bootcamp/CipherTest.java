package lv.helloit.bootcamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CipherTest {
    @Test
    void shouldEncrypt() {
        Cipher cipher = new Cipher();
        String encrypted = cipher.encrypt("CAT", 3);
        assertEquals("FDW", encrypted);
    }

    @Test
    void shouldDoBoth() {
        Cipher cipher = new Cipher();
        int key = 1;
        String original = "Some text asasdjajsdnlkjasnd";
        String encrypted = cipher.encrypt(original, key);
        String decrypted = cipher.decrypt(encrypted, key);
        assertEquals(original, decrypted);
    }

    @Test
    void shouldEncryptVigenere() {
        Cipher cipher = new Cipher();
        String message = "BROWN CAT";
        String key = "QYB";
        String encrypted = cipher.encryptVigenere(message, key);
        String decrypted = cipher.decryptVigenere(encrypted, key);
        System.out.println(message);
        System.out.println(encrypted);
        System.out.println(decrypted);
        assertEquals(message,decrypted);
    }
}
