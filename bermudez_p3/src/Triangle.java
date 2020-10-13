public class Triangle extends Shape2D{
    public Triangle(double base, double height){
        super.area = base*height*0.5;
        super.name = "triangle";
    }
}