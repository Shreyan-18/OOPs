class Book 
{
    private String name;
    String[] authors; 
    int pages;
    float price;      
    private String publisher;
    final String ISBN;
    int quantity; // no of copies

    Book(String name, String[] a, int pages, float price, String publisher, String ISBN) {
        this.name = name;
        this.pages = pages;
        this.price = price;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.quantity = 1; // Default to 1 
        this.authors = new String[a.length];
        for (int i = 0; i < a.length; i++) 
            this.authors[i] = a[i];
    }

    public String getName() 
    {
        return name;
    }

    public String getISBN() {
        return this.ISBN;
    }
    public String getPublisher()
    {
        return this.publisher;
    }
}

class Library 
{
    Book[] books;
    final int max = 100;
    int count; //  unique titles in the library
    
    Library() 
    {
        books = new Book[max];
        count = 0;
    }
    public void add(Book b) 
    {
        // If book present
        for (int i = 0; i < count; i++) {
            if (books[i].getISBN().equals(b.getISBN())) 
            {
                books[i].quantity++;
                System.out.println("Added another copy of: " + b.getName());
                return;
            }
        }
        if (count < max) 
        {
            books[count++] = b;
            System.out.println("Added new book title: " + b.getName());
        } 
        else 
            System.out.println("No more space for new titles in library");
    }
    public void remove(String ISBN) 
    {
        int indexFound = -1;
        for (int i = 0; i < count; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                indexFound = i;
                break;
            }
        }
        
        if (indexFound != -1) 
        {
            books[indexFound].quantity--;
            
            // If no copies are left
            if (books[indexFound].quantity == 0) {
                for (int i = indexFound; i < count - 1; i++) {
                    books[i] = books[i + 1];
                }
                books[count - 1] = null; 
                count--;
                System.out.println("All copies removed. Title deleted from catalog.");
            } 
            else 
                System.out.println("One copy removed. Remaining copies: " + books[indexFound].quantity);
            
            } 
        else System.out.println("Book Not found");
    }

    // UPDATED: Prints the copies
    public void printBooks() 
    {
        if (count == 0) 
        {
            System.out.println("Library is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Book: " + books[i].getName() + 
                               " [ISBN: " + books[i].getISBN() + "] -> Copies: " + books[i].quantity);
        }
    }
}

class Sixteen 
{
    public static void main(String args[]) 
    {
        Library l = new Library();
        
        String[] authors1 = {"HC Verma"};
        Book b1 = new Book("Concepts of Physics", authors1, 400, 550.0f, "Bharti Bhawan", "1234567890");      
        String[] authors2 = {"J.K. Rowling"};
        String authors3[]={"Conan Doyle"};
        Book b2 = new Book("Harry Potter", authors2, 350, 499.5f, "Bloomsbury", "6789012345");
        Book b3 = new Book("Sherlock Holmes",authors3,600,999.5f,"Sharvan","1357924680");
        l.add(b1);
        l.add(b2);       
        l.add(b1);
        l.add(b2);
        l.add(b2);
        l.add(b3);
        System.out.println("\n--- CURRENT LIBRARY ---");
        l.printBooks();
         System.out.println("\n--- Removing one copy of Harry Potter ---");
        l.remove("6789012345");
         System.out.println("\n--- UPDATED LIBRARY ---");
        l.printBooks();
    }
}