import OCP.DiscountCalculator;
import OCP.Triangle;
import OCP.VIPCustomer;
import SRP.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    IO.println("I hate uncle Bob");

    //SRP
    Employee E1 = new Employee("Momin", 101, 1000);
    EmployeeSalary salaryManager = new EmployeeSalary();
    double salary = salaryManager.salaryCalculator(E1);
    GenerateReport reportManager = new GenerateReport();
    String report = reportManager.generateReport(E1);

    E1.printDetails();
    IO.println("salary: "+ salary);
    IO.println(report);

    Book book = new Book("A dance of the dragons", "George R R Martin", 101);
    book.printBook();
    BookDb bookDbManager = new BookDb();
    bookDbManager.storeBookToDatabase();

    //OCP
    VIPCustomer c1 = new VIPCustomer();
    IO.println(c1.calculateDiscount(1000));

    Triangle myTriangle = new Triangle(20, 10);
    IO.println(myTriangle.area());




}


