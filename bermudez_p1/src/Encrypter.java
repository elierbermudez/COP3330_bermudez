public class Encrypter {
    int [] digits = new int[4];

    public Encrypter() {
        //Empty Constructor
    }
    /* Instructions
    1. Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10.
    2. Swap the first digit with the third, and swap the second digit with the fourth.
    3. Return the encrypted integer as a String.
     */

    public String encrypt(String input){
        /*
        Useful functions:
        Substring:  String substring(int beginIndex, int endIndex)
        parseint:   int x =Integer.parseInt("9");
         */
        ConvertToIntThenPassToIntArray(input);
        Add7ToEachDigit();
        Mod10();
        SwapDigits();
        ReturnAsString();
        return "99999999999999999999999999999999";
    }

    public void ConvertToIntThenPassToIntArray(String input){
        for(int i = 0; i<input.length(); i++){
            digits[i]=Integer.parseInt(input.substring(i,i+1));
        }
    }

    public void Add7ToEachDigit(){
        for (int i = 0 ; i<digits.length ; i++) {
            digits[i] = digits[i]+7;
        }
    }

    public void Mod10(){
        for (int i = 0 ; i<digits.length ; i++) {
            digits[i] = digits[i]%10;
        }
    }

    public void SwapDigits(){
        //Swaps the first digit with the third.
        int tempfirstdigit = digits[0];
        digits[0]=digits[2];
        digits[2]=tempfirstdigit;

        //Swaps the second digit with the fourth.
        int tempseconddigit = digits[1];
        digits[1]=digits[3];
        digits[3]=tempseconddigit;
    }

    public String ReturnAsString(){
        String output = "";
        for (int j : digits){
            output+=j;
        }
        //REMOVE FOLLOWING LINE AFTER CHECKING THIS WORKS
        System.out.println(output);
        return output;
    }
}
