import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.ZoneId;

class Person 
{
    private int age;
    private double weight;
    private double height;
    private Date dateOfBirth;
    private String address;

    public Person(int age, double weight, double height, Date dateOfBirth, String address) 
    {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

class Employee extends Person 
{
    private double salary;
    private Date dateOfJoining;
    private int experience;

    public Employee(int age, double weight, double height, Date dateOfBirth, String address, 
                    double salary, Date dateOfJoining, int experience) 
    {
        super(age, weight, height, dateOfBirth, address);
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Date getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(Date dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
}

class Student extends Person 
{
    private int roll;
    private HashMap<String, Double> subjectMarks;

    public Student(int age, double weight, double height, Date dateOfBirth, String address, int roll) 
    {
        super(age, weight, height, dateOfBirth, address);
        this.roll = roll;
        this.subjectMarks = new HashMap<>();
    }

    public int getRoll() { return roll; }
    public void setRoll(int roll) { this.roll = roll; }

    public HashMap<String, Double> getSubjectMarks() { return subjectMarks; }
    public void addSubjectMark(String subject, double mark) 
    {
        this.subjectMarks.put(subject, mark);
    }

    public String calculateGrade() 
    {
        if (subjectMarks.isEmpty()) return "No Marks Available";
        double total = 0;
        for (double mark : subjectMarks.values()) 
            total += mark;
        double average = total / subjectMarks.size();
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}

class Technician extends Employee 
{
    public Technician(int age, double weight, double height, Date dateOfBirth, String address, 
                      double salary, Date dateOfJoining, int experience) 
    {
        super(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);
    }
}

class Professor extends Employee 
{
    private ArrayList<String> courses;
    private ArrayList<Student> listOfAdvisee;

    public Professor(int age, double weight, double height, Date dateOfBirth, String address, 
                     double salary, Date dateOfJoining, int experience) 
    {
        super(age, weight, height, dateOfBirth, address, salary, dateOfJoining, experience);
        this.courses = new ArrayList<>();
        this.listOfAdvisee = new ArrayList<>();
    }

    public ArrayList<String> getCourses() { return courses; }
    public void addCourse(String course) { this.courses.add(course); }
    public void removeCourse(String course) { this.courses.remove(course); }

    public ArrayList<Student> getListOfAdvisee() { return listOfAdvisee; }
    public void addAdvisee(Student student) { this.listOfAdvisee.add(student); }
    public void removeAdvisee(Student student) { this.listOfAdvisee.remove(student); }
}

public class TwentyOne 
{
    public static void main(String[] args) {
        Date dob = Date.from(LocalDate.of(2005, 5, 15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date doj = Date.from(LocalDate.of(2023, 8, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        Student student = new Student(21, 65.5, 175.0, dob, "123 Campus Lane", 101);
        student.addSubjectMark("Mathematics", 92.5);
        student.addSubjectMark("Physics", 88.0);
        System.out.println("Student Roll: " + student.getRoll());
        System.out.println("Student Grade: " + student.calculateGrade());

        System.out.println("---");

        Technician tech = new Technician(30, 75.0, 180.0, dob, "456 Workshop Rd", 50000, doj, 5);
        System.out.println("Technician Experience: " + tech.getExperience() + " years");
        System.out.println("Technician Salary: $" + tech.getSalary());

        System.out.println("---");

        Professor prof = new Professor(45, 80.0, 170.0, dob, "789 Academy Blvd", 95000, doj, 15);
        prof.addCourse("Advanced Quantum Mechanics");
        prof.addCourse("Linear Algebra");
        prof.addAdvisee(student);

        System.out.println("Professor Salary: $" + prof.getSalary());
        System.out.println("Professor Courses: " + prof.getCourses());
        System.out.println("Professor Advisee Count: " + prof.getListOfAdvisee().size());

        prof.removeCourse("Linear Algebra");
        System.out.println("Updated Professor Courses: " + prof.getCourses());
    }
}