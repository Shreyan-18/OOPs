import java.util.*;
class Stack
{
    private int arr[];
    private int ms;
    private int top;
    Stack(int size)
    {
        arr = new int[size];
        ms = size;
        top = -1;
    }
    public void push(int n)
    {
        if (top==ms-1)
        {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        arr[top]=n;
    }
    public int pop()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        System.out.println("Popped element =" + arr[top]);
        return arr[top--];
    }
    public void print()
    {
        for(int j = top;j>=0;j--)
        System.out.print(arr[j]+" ");
        System.out.println();
    }
}
class Ten
{
    public static void main(String args[])
    {
        Scanner sdg = new Scanner(System.in);
        System.out.println("Enter stack length");
        int x= sdg.nextInt();
        Stack a = new Stack(x);
        a.push(10);
        a.push(20);
        a.push(30);
        a.push(15);
        a.push(9);
        a.print();
        x=a.pop();
        x=a.pop();
        x=a.pop();
        a.print();
    }
}