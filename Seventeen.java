class Employee
{
    String name;
    final int id;
    String address;
    int salary;
    
    Employee(String a, String b , int c, int d)
    {
        name = a;
        address = b;
        id = c;
        salary = d;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setName(String Name)
    {
        this.name = Name;
    }
    
    public void setSalary(int a)
    {
        salary = a;
    }
    
    public void setAddress(String a)
    {
        address = a;
    }
    
    public void printDetails()
    {
        System.out.println("Name = "+name+"\nID = "+id+"\nAddress = "+address+"\nSalary = "+salary);
    }
}

class Dept {
    String name, location;
    int year;
    int count;
    Employee[] employees; 
    final int MAX = 20;
    Dept(String name, String loc, int year) {
        this.name = name;
        this.location = loc;
        this.year = year;
        count = 0;
        employees = new Employee[MAX]; 
    }
    
    public void addEmployee(Employee newEmp) {
        if (count < MAX) {
            employees[count] = newEmp;
            count++;
            System.out.println("Employee added: " + newEmp.getName());
        } 
        else 
        {
            System.out.println("Department is full! Cannot add more employees.");
        }
    }
    
    public void removeEmployee(int id) 
    {
        int index = -1;
        for (int i = 0; i < count; i++) 
        {
            if (employees[i].getId() == id) 
            {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) 
            {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null; // Clean up the reference
            count--;
            System.out.println("Employee with ID " + id + " removed.");
        } 
        else 
        {
            System.out.println("Employee ID " + id + " not found.");
        }
    }

    public void printAllEmployees() 
    {
        System.out.println("--- Department: " + name + " ---");
        for (int i = 0; i < count; i++) {
            employees[i].printDetails();
            System.out.println("--------------------");
        }
    }
    
    public void printAnnSalary()
    {
        System.out.println("\n--- Employee Annual Salary Reports ---");
        for (int i = 0; i < count; i++) 
        {
            Employee current = employees[i];
            int annualSalary = current.salary * 12; 
            System.out.println("ID: " + current.getId() + 
                               " | Name: " + current.getName() + 
                               " | Annual Salary: " + annualSalary);
        }
    }
}

class Seventeen {
    public static void main(String args[]) {
        Dept itDept = new Dept("Information Technology","Salt Lake",2000);
        Employee e1 = new Employee("Amit", "Kolkata", 101, 5000);
        Employee e2 = new Employee("Sumit", "Delhi", 102, 6500);
        Employee e3 = new Employee("Ravi", "Mumbai", 103, 4800);
        Employee e4 = new Employee("Sneha", "Bangalore", 104, 7200);
        Employee e5 = new Employee("Pooja", "Chennai", 105, 5500);
        
        itDept.addEmployee(e1);
        itDept.addEmployee(e2);
        itDept.addEmployee(e3);
        itDept.addEmployee(e4);
        itDept.addEmployee(e5);
        
        itDept.printAnnSalary();
    }
}