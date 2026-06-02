class Student 
{
    private String name;
    private int roll;
    private String[] subjects;

    Student(String name, int roll, String[] subjects) 
    {
        this.name = name;
        this.roll = roll;
        if (subjects != null && subjects.length == 5) 
            this.subjects = subjects;
        
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNo() { return roll; }
    public void setRollNo(int rollNo) { this.roll = rollNo; }

    public String[] getSubjects() { return subjects; }
    public void setSubjects(String[] subjects) { this.subjects = subjects; }
}

class TabulationSheet
{
    private String subject;
    private int[] rollNumbers;
    private double[] marks;
    private int recordCount;

    TabulationSheet(String subjectName) 
    {
        this.subject = subjectName;
        this.rollNumbers = new int[10];
        this.marks = new double[10];
        this.recordCount = 0;
    }

    public void addMarks(int rollNo, double studentMark) 
    {
        if (recordCount < rollNumbers.length) 
        {
            rollNumbers[recordCount] = rollNo;
            marks[recordCount] = studentMark;
            recordCount++;
        } 
        else System.out.println("Tabulation Sheet capacity full!");
    }

    public double getMarksForRoll(int rollNo) {
        for (int i = 0; i < recordCount; i++) {
            if (rollNumbers[i] == rollNo) {
                return marks[i];
            }
        }
        return -1;
    }

    public String getSubject() { return subject; }
}

class MarkSheet {
    private String name;
    private int roll;
    private String[] subjectNames;
    private double[] subjectMarks;
    private int subjectCount;

    MarkSheet(int rollNo, String name) 
    {
        this.name = name;
        this.roll = rollNo;
        this.subjectNames = new String[5];
        this.subjectMarks = new double[5];
        this.subjectCount = 0;
    }

    public void addDetails(String subject, double marks) 
    { 
        if (subjectCount < 5) {
            this.subjectNames[subjectCount] = subject;
            this.subjectMarks[subjectCount] = marks;
            subjectCount++;
        }
    }

    public void printMarkSheet() {
        System.out.println("========================================");
        System.out.println("               MARK SHEET               ");
        System.out.println("========================================");
        System.out.println("Student Name : " + name);
        System.out.println("Roll No      : " + roll);
        System.out.println("----------------------------------------");
        System.out.printf("%-25s %-15s\n", "Subject", "Marks Obtained");
        System.out.println("----------------------------------------");
        
        double total = 0;
        for (int i = 0; i < subjectCount; i++) 
        {
            System.out.printf("%-25s %-15.2f\n", subjectNames[i], subjectMarks[i]);
            total += subjectMarks[i];
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("%-25s %-15.2f\n", "Total Marks:", total);
        System.out.printf("%-25s %-15.2f%%\n", "Percentage:", (total / (subjectCount * 100)) * 100);
        System.out.println("========================================\n");
    }
}

public class Eighteen 
{
     public static void main(String[] args) {
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "English", "Computer Science"};

        Student[] students = new Student[3];
        students[0] = new Student("Shreyan  Dasgupta", 101, subjects);
        students[1] = new Student("Ankit Chakraborty", 102, subjects);
        students[2] = new Student("Debadrita Mondal", 103, subjects);

        TabulationSheet[] tabSheets = new TabulationSheet[5];
        for (int i = 0; i < 5; i++) 
        {
            tabSheets[i] = new TabulationSheet(subjects[i]);
        }
        //subject 1
        tabSheets[0].addMarks(101, 88.0);
        tabSheets[0].addMarks(102, 75.5);
        tabSheets[0].addMarks(103, 99.0);
        //subject 2
        tabSheets[1].addMarks(101, 82.0);
        tabSheets[1].addMarks(102, 68.5);
        tabSheets[1].addMarks(103, 85.0);
        //subject 3
        tabSheets[2].addMarks(101, 100.0);
        tabSheets[2].addMarks(102, 71.0);
        tabSheets[2].addMarks(103, 99.5);
        //subject 4
        tabSheets[3].addMarks(101, 95.0);
        tabSheets[3].addMarks(102, 90.0);
        tabSheets[3].addMarks(103, 88.0);
        //subject 5
        tabSheets[4].addMarks(101, 99.0);
        tabSheets[4].addMarks(102, 98.0);
        tabSheets[4].addMarks(103, 84.0);

        MarkSheet[] markSheets = new MarkSheet[3];
        for (int i = 0; i < students.length; i++) 
        {
            Student currentStudent = students[i];
            int roll = currentStudent.getRollNo();
            String name = currentStudent.getName();
            
            markSheets[i] = new MarkSheet(roll,name);

            for (int j = 0; j < tabSheets.length; j++) {
                String subName = tabSheets[j].getSubject();
                double marksObtained = tabSheets[j].getMarksForRoll(roll);
                
                if (marksObtained != -1) {
                    markSheets[i].addDetails(subName, marksObtained);
                }
            }
        }

        for (int i = 0; i < markSheets.length; i++) {
            markSheets[i].printMarkSheet();
        }
    }
}