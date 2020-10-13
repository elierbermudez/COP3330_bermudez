public class Cube extends Shape3D{
    public Cube(double sidelength){
        super.area = sidelength*sidelength*6;
        super.name = "cube";
        super.volume = sidelength*sidelength*sidelength;
    }

    //The requirements state that Shape3D.getVolume must be an abstract method so I defined it in here for each shape
    public Double getVolume(){
        double volume = super.volume;
        return volume;
    }
}