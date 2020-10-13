public class Square extends Shape2D{
    public Square(double sidelength){
        super.area = sidelength*sidelength;
        super.name = "square";
    }
}