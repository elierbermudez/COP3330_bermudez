public class Decrypter {
    int [] digits = new int[4];

    public Decrypter() {
        //Empty Constructor
    }

    public String decrypt(String input){
        /*
        1. Replaces each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10.
        2. Swaps the first digit with the third, and swaps the second digit with the fourth.
        3. Returns the encrypted integer as a String.
        ConvertToIntThenPassToIntArray(input);
        Add7ToEachDigit();
        Mod10();
        SwapDigits();
        String answer = ReturnAsString();
        return answer;
        All of this code was for the original encrypt class not the decrypt class
        */
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
        //Swaps the third digit with the first.
        int tempthirddigit = digits[2];
        digits[2]=digits[0];
        digits[0]=tempthirddigit;

        //Swaps the second digit with the fourth.
        int tempfourthdigit = digits[3];
        digits[3]=digits[1];
        digits[1]=tempfourthdigit;
    }

    public String ReturnAsString(){
        String output = "";
        for (int j : digits){
            output+=j;
        }
        return output;
    }
}