public class BodyMassIndex {
    double height;
    double weight;
    double BMI_Score;
    String BMI_Category;

    public BodyMassIndex(double input_height, double input_weight) {
        height=input_height;
        weight=input_weight;
        //Calling this method solves for both BMI_Score and BMI_Category
        getBmiCategory();
    }

    //This method must be public based on rubric specifications and therefore must be tested
    public double getBmiScore(){
        BMI_Score = (703*weight)/(height*height);
        return BMI_Score;
    }

    //This method must be public based on rubric specifications and therefore must be tested
    public String getBmiCategory(){
        //BMI_Score is calculated twice in case the getBmiScore function had not been called yet
        getBmiScore();
        /*
        BMI categories:
        Underweight < 18.5
        Normal weight = 18.5–24.9
        Overweight = 25–29.9
        Obesity >= 30
        Code optimized based on population statistics by checking for obesity first
        */
        if(BMI_Score>=30){
            BMI_Category = "Obese";
            return BMI_Category;
        }
        else if(BMI_Score>=25){
            BMI_Category = "Overweight";
            return BMI_Category;
        }
        else if(BMI_Score>=18.5){
            BMI_Category = "Normal weight";
            return BMI_Category;
        }
        else{
            BMI_Category = "Underweight";
            return BMI_Category;
        }
    }

    //This toString prints out both the BMI_Score and BMI_Category. It is a public method so it must be tested.
    public String toString(){
        String outputSentence=("Your BMI Score is "+BMI_Score+" and your BMI Category is "+BMI_Category+".");
        return outputSentence;
    }
}
