package Shapes;

public class Cube extends SolidShape{
    //Cube's private data members
    private double side;

    //Constructor of Cube
    Cube(double x, double y, double z, double side){
        super(x, y, z);
        this.side = side;
    }

    //Cube's Encapsulation Setters and Getters
    public double getSide() {return side;}
    public void setSide(int side) {this.side = side;}

    public int getNumberOfFaces() {return 6;}
    public int getNumberOfVertices() {return 8;}
    public int getNumberOfEdges() {return 12;}
    public double getVolume() {return Math.pow(side, 3);}

    public String toString(){
        return "Cube " + super.toString() +
                "side: " + getSide() + "\n";
    }
}
