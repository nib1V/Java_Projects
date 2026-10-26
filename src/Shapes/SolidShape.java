package Shapes;

public class SolidShape {
    //Private class members
    private double x, y, z;

    //Constructor of SolidShape
    SolidShape(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Encapsulation Getters and Setters
    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setZ(double z) {this.z = z;}

    public int getNumberOfFaces() {return 0;}
    public int getNumberOfVertices() {return 0;}
    public int getNumberOfEdges() {return 0;}
    public double getVolume() {return 0.0;}

    public String toString(){
        return "Solid shape centered at (" + x + ", " + y + ", " + z + ") with\n" +
                "faces: " + getNumberOfFaces() + "\n" +
                "vertices: " + getNumberOfVertices() + "\n" +
                "edges: " + getNumberOfEdges() + "\n" +
                "volume: " + getVolume() + "\n";
    }
}
