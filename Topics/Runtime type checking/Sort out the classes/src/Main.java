import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        // write your code here
        for (int i = 0; i < array.length; i++) {
            if (array[i].getClass() == Shape.class) {
                shapes.add(array[i]);
            } else if (array[i].getClass() == Polygon.class) {
                polygons.add((Polygon) array[i]);
            } else if (array[i].getClass() == Square.class) {
                squares.add((Square) array[i]);
            } else if (array[i].getClass() == Circle.class) {
                circles.add((Circle) array[i]);
            }
        }
    }
}

//Don't change classes below
class Shape {
}

class Polygon extends Shape {
}

class Square extends Polygon {
}

class Circle extends Shape {
}