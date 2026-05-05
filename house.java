class Room
{
    int w,b;
    public int floorArea()
    {        
       //Scanner sdg = new Scanner(System.in);
     // System.out.println("Enter width and breadth");        
     // int w = sdg.nextInt();
      //int b = sdg.nextInt();
        w = 3;
        b=2;
        return w*b;
    }
}
class house
{
    public static void main(String args[])
    {
        int k,sum=0;
        String[] a = {"bedroom 1","bedroom2","kitchen","drawing room"};
        Room b = new Room();
        for(int i = 0; i<a.length; i++)
        {
            System.out.println(a[i]);
            k = b.floorArea();
            System.out.println("Area ="+k);
            sum+=k;
        }
        System.out.println("Floorarea of house ="+sum);
    }
}