package Tests;
import bankclasses.*;

public class TestDriver1 {

	public static void main(String[] args) throws InterruptedException{
		Account a = new Account(123,50);
		Account b = new Account(124,0.0);
		Account c = new Account(125,0.0);
		
		//Account A transfers £50 to Account B
		WithdrawRunnable a_W_FIFTY = new WithdrawRunnable(a,50.0);
		DepositRunnable b_D_FIFTY = new DepositRunnable(b,50.0);
		//Account b transfers £40 to Account c
		WithdrawRunnable b_W_FIFTY = new WithdrawRunnable(b,40.0);
		DepositRunnable c_D_FIFTY = new DepositRunnable(c,40.0);
		//Get balance of Account A, B and C
		BalanceRunnable a_Balance = new BalanceRunnable(a);
		BalanceRunnable b_Balance = new BalanceRunnable(b);
		BalanceRunnable c_Balance = new BalanceRunnable(c);
		
		
		Thread c1 = new Thread(a_W_FIFTY);
		Thread c2 = new Thread(b_D_FIFTY);
		Thread c3 = new Thread(b_W_FIFTY);
		Thread c4 = new Thread(c_D_FIFTY);
		Thread c5 = new Thread(a_Balance);
		Thread c6 = new Thread(b_Balance);
		Thread c7 = new Thread(c_Balance);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();

	}
}
