package threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountWithLiveLock {
	
	private double balance; 
	private int id; 
	final Lock lock = new ReentrantLock(); 
	
	public BankAccountWithLiveLock(int id, double balance) {
		this.id=id; 
		this.balance=balance; 
	}
	
	public boolean withdraw(double amount) throws InterruptedException {
		if (this.lock.tryLock()) {
			Thread.sleep(1000);
			balance = balance - amount;
			return true;
		}
		return false; 
	}
	
	public boolean deposit(double amount) throws InterruptedException {
		if (this.lock.tryLock()) {
			Thread.sleep(1000);
			balance = balance + amount; 
			return true; 
		}
		return false; 
	}
	
	
	public boolean transfer(BankAccountWithLiveLock from, BankAccountWithLiveLock to, double amount) throws InterruptedException {
		if (from.withdraw(amount)) {
			System.out.println("Withdrawing " + amount + " from " + id);
			if (to.deposit(amount)) {
				System.out.println("Depositing " + amount + " to " + id); 
				return true;
			}else {
				to.deposit(amount); 
			}
		}
		return false; 
	}

	public static void main(String[] args) {
		BankAccountWithLiveLock studentBankAccount = new BankAccountWithLiveLock(1, 50000); 
		BankAccountWithLiveLock universityBankAccount = new BankAccountWithLiveLock(2, 100000); 
		
		new Thread(() ->  {
			try {
				while (!studentBankAccount.transfer(studentBankAccount, universityBankAccount, 3000))
					continue;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}).start();
		
		new Thread(() -> {
			try {
				while (!universityBankAccount.transfer(universityBankAccount, studentBankAccount, 1000))
					continue;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}).start();
		
	}

}

















