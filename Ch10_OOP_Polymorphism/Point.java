package Ch10_OOP_Polymorphism;

public class Point {
    int x, y;
    
    public Point() { x = y = 0; }
    public Point(int x, int y) { this.x = x; this.y = y; }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}