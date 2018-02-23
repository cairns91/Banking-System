package Tests;
import bankclasses.*;

public class TestDriver2 {

	public static void main(String[] args) {
		// Create account.
		Account A = new Account(123, 0.0);
		// Both X and Y wish to view the balance.
		Thread Xb1 = new Thread(new BalanceRunnable(A));
		Thread Yb1 = new Thread(new BalanceRunnable(A));
		// Y tries to deposit into account A. Total = 300.
		Thread Yd1 = new Thread(new DepositRunnable(A, 300.00));
		// X tries to withdraw from account A, Total = 250.
		Thread Yw1 = new Thread(new WithdrawRunnable(A, 250.00));
		// Deposits.
		Yd1.start();
		// Withdraws.
		Yw1.start();
		// Views.
		Xb1.start();
		Yb1.start();
		}
		
}
