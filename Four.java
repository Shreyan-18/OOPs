public class Four {
    public static void main(String args[]) {
        int j;
        for (int i = 0; i < 8; i++) {
            j = 1; // The first number in every row is always 1
            for (int k = 0; k <= i; k++) {
                System.out.print(j + " ");
                
                // FIXED: Multiply first, then divide
                // Formula: C(n, k+1) = C(n, k) * (n - k) / (k + 1)
                j = j * (i - k) / (k + 1);
            }
            System.out.println();
        }
    }
}