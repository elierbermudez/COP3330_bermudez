public abstract class Shape {
    public String name;
    public double area;

    //Abstract methods may not have a body
    //Required method
    public abstract String getName();

    //Required method
    public abstract Double getArea();

    //Not sure why but to make getVolume work for 3D shapes I had to create it over here
    public abstract Double getVolume();
}
