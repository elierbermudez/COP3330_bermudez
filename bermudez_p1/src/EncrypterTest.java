import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest {
    @Test
    void testDefaultConstructor(){
        Encrypter e = new Encrypter();
    }

    @Test
    void testConvertToIntThenPassToIntArray(){
        Encrypter e = new Encrypter();
        e.encrypt("0579");
        assertArrayEquals(new int[] {0, 5, 7, 9}, e.digits);
    }

    @Test
    void testPrintArray(){
        Encrypter e = new Encrypter();
        e.encrypt("0579");
        e.PrintArray(e.digits);
    }

    @Test
    void testEncrypt1234to0189() {
        Encrypter e = new Encrypter();
        assertEquals("0189", e.encrypt("1234"));
    }
}