public abstract class Shape2D extends Shape{
    public String getName(){
        String name = super.name;
        return name;
    }

    public Double getArea(){
        double area = super.area;
        return area;
    }

    public Double getVolume(){
        //2D shapes do technically have a volume of 0
        return 0.0;
    }
}
