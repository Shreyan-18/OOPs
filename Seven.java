
public class Seven {
    public static void main(String args[]) {
        int a[][]=new int[3][2];
        int b[][]=new int[3][2];
        int c[][]=new int[3][2];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                a[i][j]=i+j;
                b[i][j]=i*j;
            } 
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 2; j++) 
            {
                c[i][j]= a[i][j]+b[i][j];
            }
        }
        System.out.println("The array elements of c are");
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 2; k++) 
            {
                System.out.print(c[i][k]+ " ");
            }
            System.out.println();
        }        
    }
}