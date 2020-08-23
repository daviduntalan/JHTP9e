package student_assignments;

abstract class MyShape {
    abstract void draw();
}

class MyLine extends MyShape {
    @Override
    void draw() {
        System.out.println("drawing a line...");
    }
}

class MyOval extends MyShape {
    @Override
    void draw() {
        System.out.println("drawing an oval...");
    }
}

class MyRectangle extends MyShape {
    @Override
    void draw() {
        System.out.println("drawing a rectangle...");
    }
}

public class PolymorphismDemo {

    public static void main(String[] args) {

        MyShape[] shapes = {
                new MyLine(),
                new MyOval(),
                new MyRectangle()
        };

        for (MyShape shape : shapes) {
            shape.draw();
        }
    }
}
