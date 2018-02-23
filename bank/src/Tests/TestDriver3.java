package Tests;
import bankclasses.*;

public class TestDriver3 {

	public static void main(String[] args){
		// Create account.
		Account A = new Account(123, 0.0);
		// X tries to deposit into account A. Total = 500.
		Thread Xd1 = new Thread(new DepositRunnable(A, 500.00));
		// Y tries to withdraw from account A, Total = 400.
		Thread Yw1 = new Thread(new WithdrawRunnable(A, 400.00));
		// Both X and Y wish to view the balance.
		Thread Xb1 = new Thread(new BalanceRunnable(A));
		Thread Yb1 = new Thread(new BalanceRunnable(A));
		// Account holder X transfers money from account A to Account B.
		Thread Tsi = new Thread(new DepositRunnable(A, 50.00));
		// Deposits.
		Xd1.start();
		// Withdraws.
		Yw1.start();
		// Views.
		Xb1.start();
		Yb1.start();
		// Standing orders.
		Tsi.start();
		}
				
	}

