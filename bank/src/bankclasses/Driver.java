package bankclasses;


public class Driver {
	
	public static void main (String[] args){
		Account a = new Account(123,0.0);
		
		DepositRunnable tr = new DepositRunnable(a,5.0);
		WithdrawRunnable wr = new WithdrawRunnable(a,15.0);
		
	
		Thread d1 = new Thread(tr);
		Thread w1 = new Thread(wr);
		Thread d2 = new Thread(tr);
		Thread d3 = new Thread(tr);
		
		Thread b1 = new Thread(new BalanceRunnable(a));
		Thread b2 = new Thread(new BalanceRunnable(a));

		/****INSUFFICIENT FUNDS TO WITHDRAW*****
		d1.start();
		w1.start();
		d2.start();
		d3.start();
		**********/
		
		
		/******TWO CHECK BALANCE******
		b1.start();
		b2.start();
		********/
		
	/***
		b1.start();
		d1.start();
		d2.start();
		d3.start();
		b2.start();
		*/
		
		
		b1.start();
		d1.start();
		d2.start();
		d3.start();
		b2.start();
		
	}

}
