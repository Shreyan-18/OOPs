public class Three
{
public static void main(String args[])
{
int a[]= new int[50];
int b=0,c;
for(int n = 2;n<100;n++)
{
c = 0;
for(int j = 2;j<=(int)Math.sqrt(n)+1;j++)
{
if (n%j == 0) {c++; break;}
}
if (c==0)   a[b++]=n;
}
for(int i = 0;i<b;i++)
System.out.println(a[i]);
}//main
}//class


