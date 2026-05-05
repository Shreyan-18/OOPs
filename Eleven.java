import java.util.*;
class Student
{
    String name;
    int roll,m1,m2,m3;
    Student(String name,int roll)
    {
        this.name = name;
        this.roll = roll;
    }
    public int total()
    {
        return m1+m2+m3;
    }
    public double average()
    {
        return (m1+m2+m3)/3.0;
    } 
}
class Eleven
{
    public static void main(String args[])
    {
        Scanner sdg = new Scanner(System.in);
        String n[] = {"A","B","c","D"};
        int roll[]  = {1,2,3,4};
        Student[] students = new Student[4];
        for(int i = 0; i<4; i++)
        {
            students[i] = new Student(n[i],roll[i]);
        }
        for(int i = 0; i<4; i++)
        {
            System.out.println(students[i].name);
            System.out.println("Enter marks of 3 subjects");
            students[i].m1 = sdg.nextInt();
            students[i].m2 = sdg.nextInt();
            students[i].m3 = sdg.nextInt();
        }
        for(int i = 0; i<4; i++)
        {
            System.out.println("Name ="+students[i].name);
            System.out.println("Roll ="+students[i].roll);
            System.out.println("Marks ="+students[i].m1+","+students[i].m2+","+students[i].m3);          
            System.out.println("Total ="+students[i].total());
            System.out.println("Average ="+students[i].average());
             
        }

    }
}