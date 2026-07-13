package SRP;

public class Employee {
    private String name;
    private int empId;
    private double baseSalary;

    //constructor for adding employees
    public Employee(String name, int empId, double baseSalary){
        this.name=name;
        this.empId=empId;
        this.baseSalary=baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmpId() {
        return empId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void printDetails(){
        IO.println("Name: "+ name + "Id: "+empId +"base salary: " + baseSalary);
    }

//    private double calculateSalary(double baseSalary){
//        return baseSalary*1.10;
//    }

//    private void generateReport(){
//        IO.println("SRP.Employee Report Generated");
//    }
}

//This approach does not follow srp as if, salary logic is changed, whole class will be needed to be changed
//SRP - A class should have 1 reason to change
//That's why some methods are commented out and refactored by separating classes with different works
