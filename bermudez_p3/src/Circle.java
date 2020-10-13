public class Circle extends Shape2D{
    public Circle(double radius){
        super.area = Math.PI*radius*radius;
        super.name = "circle";
    }
}