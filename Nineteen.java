import java.util.ArrayList;
import java.util.List;
abstract class Publication 
{
    protected int noOfPages;
    protected double price;
    protected String publisherName;
    Publication(int noOfPages, double price, String publisherName) 
    {
        this.noOfPages = noOfPages;
        this.price = price;
        this.publisherName = publisherName;
    }
    public int getNoOfPages() 
    {
        return noOfPages;
    }
    public void setNoOfPages(int noOfPages) 
    {
        this.noOfPages = noOfPages;
    }
    public double getPrice() 
    {
        return price;
    }
    public void setPrice(double price) 
    {
        this.price = price;
    }
    public String getPublisherName() 
    {
        return publisherName;
    }
    public void setPublisherName(String publisherName) 
    {
        this.publisherName = publisherName;
    }
    public abstract void printDetails();
}

class Book extends Publication 
{
    private String author;
    private String title;
    public Book(int noOfPages, double price, String publisherName, String author, String title) 
    {
        super(noOfPages, price, publisherName);
        this.author = author;
        this.title = title;
    }

    @Override
    public void printDetails() 
    {
        System.out.println("[BOOK] Title: " + title 
            + " | Author: " + author 
            + " | Publisher: " + publisherName 
            + " | Pages: " + noOfPages 
            + " | Price: $" + price);
    }
}

class Journal extends Publication {
    private String volume;
    private String fieldOfStudy;

    public Journal(int noOfPages, double price, String publisherName, String volume, String fieldOfStudy) {
        super(noOfPages, price, publisherName);
        this.volume = volume;
        this.fieldOfStudy = fieldOfStudy;
    }

    @Override
    public void printDetails() {
        System.out.println("[JOURNAL] Field: " + fieldOfStudy 
            + " | Volume: " + volume 
            + " | Publisher: " + publisherName 
            + " | Pages: " + noOfPages 
            + " | Price: $" + price);
    }
}

class Library 
{
    private List<Publication> catalog;
    public Library() 
    {
        catalog = new ArrayList<>();
    }
    public void addPublication(Publication pub)
    {
        catalog.add(pub);
    }
    public void printLibrary() 
    {
        System.out.println("--- Library Catalog ---");
        for (Publication pub : catalog) 
            pub.printDetails();
    }
}

class Nineteen {
    public static void main(String[] anonymity) {
        Library myLibrary = new Library();
        //Books
        myLibrary.addPublication(new Book(320, 14.99, "Future", "J.K Rowling", "Harry Potter & the Half Blood Prince"));
        myLibrary.addPublication(new Book(400, 29.99, "Tata McGrewl", "Rohini Basak", "The C++ Programming Language"));
        myLibrary.addPublication(new Book(350, 34.99, "Watson Publication", "Sir Arthur Conan Doyle", "Sherlock Holmes"));
        //Journals
        myLibrary.addPublication(new Journal(45, 4.50, "IEEE", "Vol. 28 No. 4", "Computer Vision"));
        myLibrary.addPublication(new Journal(60, 5.00, "Springer", "Vol. 12", "Quantum Computing"));

        myLibrary.printLibrary();
    }
}