package Shapes;

public class Cylinder extends SolidShape{
    //Cylinder's private data members
    private double radius, height;

    //Constructor of Cylinder
    Cylinder(double x, double y, double z, double radius, double height){
        super(x, y, z);
        this.radius = radius;
        this.height = height;
    }

    //Cylinder's Encapsulation Setters and Getters
    public double getRadius() {return radius;}
    public double getHeight() {return height;}
    public void setRadius(double radius) {this.radius = radius;}
    public void setHeight(double height) {this.height = height;}

    public int getNumberOfFaces() {return 3;}
    public int getNumberOfEdges() {return 2;}
    public double getVolume() {return Math.PI * Math.pow(radius, 2) * height;}


    public String toString(){
        return "Cylinder " + super.toString() +
                "radius: " + getRadius() + "\n" +
                "height:" + getHeight() + "\n";
    }
}
