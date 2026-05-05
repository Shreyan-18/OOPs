import java.util.*;
public class Six {
    public static void main(String args[]) {
        Scanner sdg = new Scanner(System.in);
        int a[] = new int[100];
        System.out.println("Enter Array elements");
        for (int i = 0; i < 100; i++)
                a[i]=sdg.nextInt();
        System.out.println("Enter Search element");
        int k = sdg.nextInt();
        for (int i = 0; i < 100; i++)
        {
            if(k==a[i])        System.out.println("Search successful at index"+i);
            System.exit(0);
        }
        System.out.println("Search Unsuccessful");


    }
}