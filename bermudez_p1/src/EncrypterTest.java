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
        e.ConvertToIntThenPassToIntArray("0579");
        assertArrayEquals(new int[] {0, 5, 7, 9}, e.digits);
    }

    @Test
    void testAdd7ToEachDigit(){
        Encrypter e = new Encrypter();
        e.ConvertToIntThenPassToIntArray("0579");
        e.Add7ToEachDigit();
        assertArrayEquals(new int[] {7, 12, 14, 16}, e.digits);
    }

    @Test
    void testMod10(){
        Encrypter e = new Encrypter();
        e.ConvertToIntThenPassToIntArray("0579");
        e.Add7ToEachDigit();
        e.Mod10();
        assertArrayEquals(new int[] {7, 2, 4, 6}, e.digits);
    }

    @Test
    void testSwapDigits(){
        Encrypter e = new Encrypter();
        e.ConvertToIntThenPassToIntArray("0579");
        e.Add7ToEachDigit();
        e.Mod10();
        e.SwapDigits();
        assertArrayEquals(new int[] {4, 6, 7, 2}, e.digits);
    }

    @Test
    void testReturnAsString(){
        Encrypter e = new Encrypter();
        e.ConvertToIntThenPassToIntArray("0579");
        e.Add7ToEachDigit();
        e.Mod10();
        e.SwapDigits();
        assertArrayEquals(new int[] {4, 6, 7, 2}, e.digits);
        assertEquals("4672", e.ReturnAsString());
    }

    @Test
    void testEncrypt1234to0189() {
        Encrypter e = new Encrypter();
        assertEquals("0189", e.encrypt("1234"));
    }

    @Test
    void testEncrypt0000to7777() {
        Encrypter e = new Encrypter();
        assertEquals("7777", e.encrypt("0000"));
    }

    @Test
    void testEncrypt5678to4523() {
        Encrypter e = new Encrypter();
        assertEquals("4523", e.encrypt("5678"));
    }

    @Test
    void testEncrypt4753to2014() {
        Encrypter e = new Encrypter();
        assertEquals("2014", e.encrypt("4753"));
    }

    @Test
    void testEncrypt0630to0773() {
        Encrypter e = new Encrypter();
        assertEquals("0773", e.encrypt("0630"));
    }

    @Test
    void testEncrypt3453to2001() {
        Encrypter e = new Encrypter();
        assertEquals("2001", e.encrypt("3453"));
    }
}