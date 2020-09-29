import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    //Imported some tests from previous homework to make sure the syntax is correct when creating new tests myself
    //`BodyMassIndexTest` contains at least one test for each of the possible BMI categories

    @Test
    void testEmptyConstructor(){
        BodyMassIndex e = new BodyMassIndex();
    }

    @Test
    void testDefaultConstructor(){
        BodyMassIndex e = new BodyMassIndex(5, 7);
    }

    @Test
    void testgetBmiScore(){
        BodyMassIndex e = new BodyMassIndex(70, 100);
        assertEquals(14.346938775510203, e.getBmiScore());
    }

    @Test
    void testgetBmiCategory(){
        //This is the same test as testUnderweight
        BodyMassIndex e = new BodyMassIndex(70, 100);
        assertEquals("Underweight", e.getBmiCategory());
    }

    @Test
    void testtoString(){
        //This is the same test as testUnderweight
        BodyMassIndex e = new BodyMassIndex(70, 100);
        assertEquals("Your BMI Score is 14.346938775510203 and your BMI Category is Underweight.", e+"");
    }

    @Test
    void testUnderweight(){
        BodyMassIndex e = new BodyMassIndex(70, 100);
        assertEquals("Underweight", e.getBmiCategory());
    }

    @Test
    void testNormalweight(){
        BodyMassIndex e = new BodyMassIndex(70, 160);
        assertEquals("Normal weight", e.getBmiCategory());
    }

    @Test
    void testOverweight(){
        BodyMassIndex e = new BodyMassIndex(70, 190);
        assertEquals("Overweight", e.getBmiCategory());
    }

    @Test
    void testObese(){
        BodyMassIndex e = new BodyMassIndex(70, 300);
        assertEquals("Obese", e.getBmiCategory());
    }
}