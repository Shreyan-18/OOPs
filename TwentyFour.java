interface Fruit 
{
    boolean hasAPeel();
}

interface Vegetable 
{
    boolean hasARoot();
}

class Tomato implements Fruit, Vegetable 
{
    private String name;
    private String color;

    public Tomato(String name, String color) 
    {
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean hasAPeel() 
    {
        return true;
    }

    @Override
    public boolean hasARoot() 
    {
        return false;
    }

    public void printDetails() 
    {
        System.out.println("Object: " + name);
        System.out.println("Color: " + color);
        System.out.println("Is it a Fruit (has a peel)? " + hasAPeel());
        System.out.println("Is it a Vegetable (has a root)? " + hasARoot());
    }
}

public class TwentyFour 
{
    public static void main(String[] args) 
    {
        Tomato tomato = new Tomato("Roma Tomato", "Red");
        tomato.printDetails();
    }
}