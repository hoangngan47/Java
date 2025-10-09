abstract class Employee{
    protected String name;
    protected int age;
    protected double salary;

    public Employee (String name,int age){
        this.name = name;
        this.age = age;
    }

    public abstract void mathSalary();

    public void hienThiThongTin(){
        System.out.println("Ten:" + name);
        System.out.println("Tuoi:" + age);
        System.out.println("Luong:" + salary + " USD");
    }
}

class OfficeEmployee extends Employee {
    private int workingDays;
    private double daySalary = 100;

    public OfficeEmployee (String name, int age, int workingDays){
        super(name,age);
        this.workingDays = workingDays;
    }
    
    @Override
    public void mathSalary(){
        salary = daySalary * workingDays;
    }
}

class TechnicalEmployee extends Employee{
    private int workingHours;
    private double hourSalary;

    public TechnicalEmployee(String name, int age, int workingHours, double hourSalary){
        super(name,age);
        this.workingHours = workingHours;
        this.hourSalary = hourSalary;
    }
    
    @Override
    public void mathSalary(){
        salary = workingHours * hourSalary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee oe1 = new OfficeEmployee( "Kim Ji Won", 32, 30);
        oe1.mathSalary();
        oe1.hienThiThongTin();
        Employee te1 = new TechnicalEmployee("Pham Hoang Ngan", 19, 240, 100);
        te1.mathSalary();
        te1.hienThiThongTin();
    }
}
