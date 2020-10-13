public class Sphere extends Shape3D{
    public Sphere(double radius){
        super.area = 4*Math.PI*radius*radius;
        super.name = "sphere";
        //The formulas for area and volume of a sphere are similar so I am curious if this saves any processing time
        super.volume = this.getArea()*radius/3.0;
    }

    //The requirements state that Shape3D.getVolume must be an abstract method so I defined it in here for each shape
    public Double getVolume(){
        double volume = super.volume;
        return volume;
    }
}