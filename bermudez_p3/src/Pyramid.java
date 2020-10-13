public class Pyramid extends Shape3D{
    public Pyramid(double length, double width, double height){
        //Formula for pyramid surface area found on google
        super.area = length*width + length*Math.sqrt(height*height + width*width/4) + width*Math.sqrt(height*height + length*length/4);
        super.name = "pyramid";
        super.volume = length*width*height/3.0;
    }

    //The requirements state that Shape3D.getVolume must be an abstract method so I defined it in here for each shape
    public Double getVolume(){
        double volume = super.volume;
        return volume;
    }
}