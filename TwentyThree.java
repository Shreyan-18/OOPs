interface Shape 
{
    double area();
    void draw();
    void rotate(double angle);
    void move(double dx, double dy);
    void printDetails();
}

class Circle implements Shape 
{
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) 
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double area() 
    {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() 
    {
        System.out.println("Drawing a Circle at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public void rotate(double angle) 
    {
        System.out.println("Rotating Circle by " + angle + " degrees around its center");
    }

    @Override
    public void move(double dx, double dy) 
    {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void printDetails() 
    {
        System.out.println("Circle -> Position: (" + x + ", " + y + ") | Radius: " + radius + " | Area: " + String.format("%.2f", area()));
    }
}

class Rectangle implements Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() 
    {
        return width * height;
    }

    @Override
    public void draw() 
    {
        System.out.println("Drawing a Rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }

    @Override
    public void rotate(double angle) 
    {
        System.out.println("Rotating Rectangle by " + angle + " degrees");
    }

    @Override
    public void move(double dx, double dy) 
    {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void printDetails() {
        System.out.println("Rectangle -> Position: (" + x + ", " + y + ") | Dimensions: " + width + "x" + height + " | Area: " + String.format("%.2f", area()));
    }
}

public class TwentyThree 
{
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(0, 0, 5);
        shapes[1] = new Circle(2, 3, 10);
        shapes[2] = new Rectangle(1, 1, 4, 5);
        shapes[3] = new Rectangle(-2, -2, 3, 6);
        shapes[4] = new Rectangle(5, 0, 2, 8);

        System.out.println("--- Details Before Moving ---");
        for (Shape shape : shapes) 
        {
            shape.printDetails();
        }

        for (Shape shape : shapes) 
        {
            shape.move(5.0, -2.0);
        }

        System.out.println("\n--- Details After Moving (dx = 5, dy = -2) ---");
        for (Shape shape : shapes) 
        {
            shape.printDetails();
        }
    }
}