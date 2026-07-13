package OCP;

public class regularCustomer implements CustomerDiscount{
    @Override
    public double calculateDiscount(double amount) {
        return amount*0.5;
    }
}
