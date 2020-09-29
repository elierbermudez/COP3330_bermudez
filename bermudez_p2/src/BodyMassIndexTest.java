import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    //Imported some tests from previous homework to make sure the syntax is correct when creating new tests myself
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
    void testEncrypt1234to0189() {
        Encrypter e = new Encrypter();
        assertEquals("0189", e.encrypt("1234"));
    }
}