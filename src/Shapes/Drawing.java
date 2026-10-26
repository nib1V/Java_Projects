package Shapes;

public class Drawing {
    private SolidShape[] shapes = new SolidShape[1000];
    private int activeCapacity = 0;

    public void add(SolidShape s){
        if (activeCapacity != 1000){
            shapes[activeCapacity] = s;
            activeCapacity++;
        }
    }

    public String toString() {
        String res = "Number of Shapes: " + activeCapacity + "\n";
        int faces = 0, vertices = 0, edges = 0;
        double volume = 0.0;
        for (int i = 0; i < activeCapacity; i++){
            faces += shapes[i].getNumberOfFaces();
            vertices += shapes[i].getNumberOfVertices();
            edges += shapes[i].getNumberOfEdges();
            volume += shapes[i].getVolume();
        }
        return res + "Total faces: " + faces + "\n" +
                     "Total vertices: " + vertices + "\n" +
                     "Total edges: " + edges + "\n" +
                     "Total volume: " + volume + "\n";
    }

    public String toJSON() {
        String JSON = "{\n" +
                      " \"drawing\": [\n";
        for (int i = 0; i < activeCapacity; i++){
            JSON += " {\n" +
                    "  \"x\":" + shapes[i].getX() + ",\n" +
                    "  \"y\":" + shapes[i].getY() + ",\n";
            if (shapes[i] instanceof Sphere){
                JSON += "  \"type\": \"sphere\",\n" +
                        "  \"radius\":" + ((Sphere)shapes[i]).getRadius() + "\n";
            }
            else if(shapes[i] instanceof Cube){
                JSON += "  \"type\": \"cube\",\n" +
                        "  \"side\":" + ((Cube)shapes[i]).getSide() + "\n";
            }
            if (i+1 < activeCapacity)
                JSON += " },\n";
            else
                JSON += " }\n";
        }
        return JSON + "]\n}";
    }
}
