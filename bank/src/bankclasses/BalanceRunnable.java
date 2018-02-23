package bankclasses;

public class BalanceRunnable implements Runnable {

	private Account a;
	private double amount;
	private int DELAY = 1;
	
	public BalanceRunnable(Account a){
		this.a = a;

	}

	@Override
	public void run() {
		try{
			synchronized(a){
			Thread.sleep(DELAY);
			a.getBalance();
			}
		}catch(InterruptedException e){};		
	}
	

}
