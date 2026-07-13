package OCP;

public class DiscountCalculator {
//    public double CustomerDiscount(String customer, double amount) {
//        if (customer.equals("regular")) return amount * .05;
//        else if (customer.equals("premium")) {
//            return amount * .10;
//        }else return 0;
//}
    public double CustomerDiscount(CustomerDiscount customer, double amount){
        return customer.calculateDiscount(amount);
    }

}

//If a new Customer type "VIP" added, class needed to be modified.
//But according to OCP code need to be open for extension but closes for modification
//Applying OCP by adding an Interface
