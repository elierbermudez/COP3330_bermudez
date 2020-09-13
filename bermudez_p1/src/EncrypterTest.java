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
}