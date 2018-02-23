package bankclasses;
import java.util.concurrent.TimeUnit;

public class PremiumAccount extends Account {

	public double overdraft;
	public double fee;

	public PremiumAccount(double overdraft, double fee, int acc, double bal) {
		super(acc, bal);
		this.overdraft = 500;
		this.fee = fee;

	}

	@SuppressWarnings("static-access")
	public void fee(double fee) throws InterruptedException {

		double newBalance;

		boolean stillWaiting = true;
		balanceLock.lock();

		try {
			while (super.balance >= fee) {
				if (!stillWaiting)
					Thread.currentThread().interrupt();
				stillWaiting = enoughFundsCondition.await(10, TimeUnit.SECONDS);
			}
			System.out.println("Fee Amount £" + fee);

			newBalance = super.balance - fee;
			super.balance = newBalance;

			System.out.println("New balance £" + super.balance);
		} finally

		{
			balanceLock.unlock();
		}
	}
}
