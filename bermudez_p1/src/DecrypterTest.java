import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecrypterTest {

    @Test
    void testDecrypt0189to1234() {
        Decrypter d = new Decrypter();
        assertEquals("1234", d.decrypt("0189"));
    }
    @Test
    void testDecrypt7777to0000() {
        Decrypter d = new Decrypter();
        assertEquals("0000", d.decrypt("7777"));
    }

    @Test
    void testDecrypt4523to5678() {
        Decrypter d = new Decrypter();
        assertEquals("5678", d.decrypt("4523"));
    }

    @Test
    void testDecrypt2014to4753() {
        Decrypter d = new Decrypter();
        assertEquals("4753", d.decrypt("2014"));
    }

    @Test
    void testDecrypt0773to0630() {
        Decrypter d = new Decrypter();
        assertEquals("0630", d.decrypt("0773"));
    }

    @Test
    void testDecrypt2001to3453() {
        Decrypter d = new Decrypter();
        assertEquals("3453", d.decrypt("2001"));
    }
}