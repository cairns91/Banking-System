package bankclasses;
import java.util.concurrent.TimeUnit;


public class SavingsAccount extends Account {

	

	private double interest;
	private double rate;
	private double threshold;

	public SavingsAccount(int acc, double bal, double interest, double rate, double threshold) {

		super(acc,bal);
		this.rate = 2;
		this.interest = (super.balance * (rate)) / 100;
		this.threshold = 100;
	}

	public void addInterest() throws InterruptedException {

		double newBalance;
		boolean stillWaiting = true;
		balanceLock.lock();

		try {
			while (super.balance >= threshold) {
				if (!stillWaiting)
					Thread.currentThread().interrupt();
				stillWaiting = enoughFundsCondition.await(10, TimeUnit.SECONDS);
			}
			System.out.println("Interest amount £" + interest);
			newBalance = super.balance + interest;
			super.balance = newBalance;
			System.out.println("New balance £" + super.balance);
		} finally
		{
			balanceLock.unlock();
		}
	}
}

		
