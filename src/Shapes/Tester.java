package Shapes;

import java.util.Random;

public class Tester {
    public static void main(String[] args){
        //(c-i):
        Drawing d1 = new Drawing();
        for (int i = 1; i <= 50; i++){
            Random ran = new Random();
            double x = ran.nextDouble() * 100;
            double y = ran.nextDouble() * 100;
            double z = ran.nextDouble() * 100;
            d1.add(new Sphere(x, y, z, (double)i/10));
        }
        System.out.println("(c-i):");
        System.out.println(d1);

        //(c-ii):
        Drawing d2 = new Drawing();
        for (int i = 1; i <= 50; i++){
            if (i%2 == 0){
                d2.add(new Cube(i));
            }
            else {
                d2.add(new Sphere(i));
            }
        }
        System.out.println("(c-ii):");
        System.out.print(d2);

        System.out.println(d1.toJSON());
    }
}
