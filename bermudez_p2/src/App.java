import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static boolean moreInput(){
        //The method `moreInput` prompts the user to enter "Y" or "N" and
        // returns an appropriate boolean value based on their input.
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to enter more input? Type Y for yes or N for no.");
        String letter = scan.nextLine();

        //This loop repeats until the user inputs Y or N.
        while(letter.equals("Y") == letter.equals("N")){
                System.out.println("I didn't quite catch that. Please type Y for yes or N for no.");
                letter = scan.nextLine();
        }
        return letter.equals("Y");
    }

    public static double getUserHeight(){
        //The method `getUserHeight` prompts the user to enter their height in inches and only accepts positive values.
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your height in inches.");
        double height = scan.nextDouble();
        while(height<=0){
            System.out.println("Please enter a positive value for your height.");
            height=scan.nextDouble();
        }
        //Clearing input buffer
        scan.nextLine();
        return height;
    }

    public static Double getUserWeight(){
        //The method `getUserWeight` prompts the user to enter their weight in pounds and only accepts positive values.
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your weight in pounds.");
        double weight = scan.nextDouble();
        while(weight<=0){
            System.out.println("Please enter a positive value for your weight.");
            weight=scan.nextDouble();
        }
        //Clearing input buffer
        scan.nextLine();
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        //The method `displayBmiInfo` prints out a user's BMi score and category using the data contained in a BodyMassIndex object.
        System.out.println(bmi);
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        //The method `displayBmiStatistics` prints out the average BMI score of the data.
        /*
        This method finds the size of the given arraylist then uses a loop to add up the BMI_Score
        of all elements in that arraylist. It then prints that average BMI. There is an if else statement
        to avoid dividing by 0 when taking the average.
         */
        int bmiDataSize=bmiData.size();
        double averageBMI=0;
        for(int i=0; i<bmiDataSize; i++) {
            averageBMI += bmiData.get(i).BMI_Score;
        }
        if(averageBMI==0){
            System.out.println("The average BMI of the data is 0");
        }
        else{
            averageBMI/=bmiDataSize;
            System.out.println("The average BMI of the data is "+averageBMI);
        }

    }

    //DO NOT MODIFY UNDER THIS COMMENT
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    //OR ABOVE THIS COMMENT
}
