package bankclasses;

public class WithdrawRunnable implements Runnable {

	private Account a;
	private double amount;
	private int DELAY  = 1;
	
	public WithdrawRunnable(Account a, double amount){
		
		this.a = a;
		this.amount = amount;

	}
	
	@Override
	public void run() {
		try{
			Thread.sleep(DELAY);
			a.withdraw(amount);
			
		}catch(InterruptedException e){
			System.out.println("Thread with ID " + Thread.currentThread().getId() + " Can't wait anymore! Withdraw aborted.");
		};		
	}

}
