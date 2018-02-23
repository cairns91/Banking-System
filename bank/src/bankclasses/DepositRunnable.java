package bankclasses;

public class DepositRunnable implements Runnable {

	private Account a;
	private double amount;
	private int DELAY = 1;
	
	
	public DepositRunnable(Account a, double amount){
		
		this.a = a;
		this.amount = amount;
		
	}


	@Override
	public void run() {
		try{
			synchronized(a){
			Thread.sleep(DELAY);
			a.deposit(amount);
			}
		}catch(InterruptedException e){
		};		
	}
	

}
