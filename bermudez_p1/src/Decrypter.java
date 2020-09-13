public class Decrypter {
    int [] digits = new int[4];

    public Decrypter() {
        //Empty Constructor
    }

    public String decrypt(String input){
        /*
        1. Swaps the first digit with the third, and swaps the second digit with the fourth. (Swapping a 2nd time is the same as undoing a swap)
        2. Add 10, subtract 7, then mod 10 to reverse the add 7 mod 10 process (Same as just adding 3 then mod10)
        3. Return the decrypted integer as a String
         */
        ConvertToIntThenPassToIntArray(input);
        SwapDigits();
        Add3ToEachDigit();
        Mod10();
        String answer = ReturnAsString();
        return answer;
    }

    public void ConvertToIntThenPassToIntArray(String input){
        for(int i = 0; i<input.length(); i++){
            digits[i]=Integer.parseInt(input.substring(i,i+1));
        }
    }

    public void Add3ToEachDigit(){
        for (int i = 0 ; i<digits.length ; i++) {
            digits[i] = digits[i]+3;
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
        return output;
    }
}