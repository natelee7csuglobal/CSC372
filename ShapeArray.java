package module4;

public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[3];

        shapeArray[0] = new Sphere(5.0);
        shapeArray[1] = new Cylinder(3.0, 7.0);
        shapeArray[2] = new Cone(4.0, 6.0);

        for (Shape shape : shapeArray) {
            System.out.println(shape);
        }
    }
}