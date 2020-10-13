public abstract class Shape3D extends Shape{
    public double volume;

    public String getName(){
        String name = super.name;
        return name;
    }

    public Double getArea(){
        double area = super.area;
        return area;
    }
    //Required method
    @Override
    public abstract Double getVolume();
}
