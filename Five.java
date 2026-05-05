import java.util.*;
public class Five {
    public static void main(String args[]) {
        Scanner sdg = new Scanner(System.in);
        int a[][]=new int[3][2];
        int b[][]=new int[2][3];

        for (int i = 0; i < 3; i++)
        {
            System.out.println("enter elements of row" + (i+1));
            for (int k = 0; k < 2; k++) 
            {
                a[i][k]=sdg.nextInt();
            }
        }
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 2; k++) 
            {
                b[k][i]=a[i][k];
            }
        }
        System.out.println("The array elements of b are");
        for (int i = 0; i < 2; i++)
        {
            for (int k = 0; k < 3; k++) 
            {
                System.out.print(b[i][k]+ " ");
            }
            System.out.println();
        }        
    }
}