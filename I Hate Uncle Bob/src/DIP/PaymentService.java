package DIP;

public class PaymentService {
    PaypalPayment payment = new PaypalPayment();
    public void processPyament(){
        payment.pay();
    }
}
