class  Box
{
   int h,b,w;
   //static int v = 0;
   Box(int h, int b, int w)
   {
      this.h = h;
      this.w = w;
      this.b = b;
   }
   Box(int a)
   {
      this.h = a;
      this.w = a;
      this.b = a;
   }
   public int getVolume()
   {
      return h*b*w;
   }
   public int getArea()
   {
      return 2*(b*h + h*w + w*b);
   }
}
class Nine
{
   public static void main(String args[])
   {
      Box box1 = new Box(2,3,4);
      Box box2 = new Box(5);
      int vol1 = box1.getVolume();
      int sa1 = box1.getArea();
      System.out.println("Volume of first box ="+vol1);
      System.out.println("Surface Area of first box ="+sa1);
      int vol2 = box2.getVolume();
      int sa2 = box2.getArea();
      System.out.println("Volume of second box ="+vol2);
      System.out.println("Surface Area of second box ="+sa2);
     /*LAST PART LEFT
      Box room = new Box(10);
      int vol = room.getVolume();
      int box3 = new
      int no = n/max;  //No of rooms
      if (max*no!=n) no = no +1;
      System.out.println("No. of rooms required ="+no);*/
    }
}

      
     