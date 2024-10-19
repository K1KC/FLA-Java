package adapters;

public class CardPaymentAdapter implements PaymentAdapter{

	@Override
	public double getPriceinPayment(double price) {
		// TODO Auto-generated method stub
		return price * 1.1;
	}

}
