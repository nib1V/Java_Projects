package Shapes;

public class Sphere extends SolidShape{
    //Sphere's private data members
    private double radius;

    //Constructor of Sphere
    Sphere(double x, double y, double z, double radius){
        super(x, y, z);
        this.radius = radius;
    }

    Sphere(double radius){
        this(0.0,0.0,0.0, radius);
    }

    //Sphere's Encapsulation Setters and Getters
    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    public int getNumberOfFaces() {return 1;}
    public double getVolume() {return ((double)4/3) * Math.PI * Math.pow(radius, 3);}

    public String toString(){
        return "Sphere " + super.toString() +
                "radius: " + getRadius() + "\n";
    }
}
