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
        return "99999999999999999999999999999999";
    }

    private void ConvertToIntThenPassToIntArray(String input){
        for(int i = 0; i<input.length(); i++){
            digits[i]=Integer.parseInt(input.substring(i,i+1));
        }
    }

    //Used to make testing easier
    public void PrintArray(int [] array){
        for (int j : array) {
            System.out.print(j);
        }
        System.out.println();
    }
}
