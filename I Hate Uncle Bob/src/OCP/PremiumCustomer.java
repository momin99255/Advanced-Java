package OCP;

public class PremiumCustomer implements CustomerDiscount{
    @Override
    public double calculateDiscount(double amount) {
        return amount*0.10;
    }
}
