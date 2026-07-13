package OCP;

public class VIPCustomer implements CustomerDiscount{

    @Override
    public double calculateDiscount(double amount) {
        return amount*0.20;
    }
}
