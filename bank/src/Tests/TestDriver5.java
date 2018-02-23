package Tests;
import bankclasses.*;

public class TestDriver5 {

	public static void main(String[] args){
		
	Account a = new Account(123,0.0);
		
		DepositRunnable tr = new DepositRunnable(a,5.0);
		WithdrawRunnable wr = new WithdrawRunnable(a,15.0);
		
		
		Thread d1 = new Thread(tr);
		Thread w1 = new Thread(wr);
		Thread d2 = new Thread(tr);
		Thread d3 = new Thread(tr);
		
		Thread b1 = new Thread(new BalanceRunnable(a));
		Thread b2 = new Thread(new BalanceRunnable(a));
		//check balance
		b1.start();
		//deposit £5
		d1.start();
		//deposit £5
		d2.start();
		//withdraw £15
		w1.start();
		//check balance
		b2.start();
	
	}

}