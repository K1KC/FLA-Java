package adapters;

public class DigitalWalletPaymentAdapter implements PaymentAdapter{

	@Override
	public double getPriceinPayment(double price) {
		// TODO Auto-generated method stub
		return price * 0.9;
	}

}
