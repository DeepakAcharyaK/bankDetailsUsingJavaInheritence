class Account{
	protected double balance;

	public Account(double initialBalance){
		this.balance=initialBalance;
	}

	public void deposit(double amount){
		balance=balance+amount;
		System.out.println("Deposited:"+amount);
	}
	public void withdraw(double amount){
		balance=balance-amount;
		System.out.println("Withdraw:"+amount);
	}
	public void displayBalance(){
		System.out.println("Current Balance:"+balance);
	}
}

//saving
class SavingAccount extends Account{
	private double interestRate=0.05;

	public SavingAccount(double initialBalance){
		super(initialBalance);
	}

	public void withdraw(double amount){
		if(balance>=0){
			super.withdraw(amount);
		}else{
			System.out.println("Insufficent balance in the saving account");
		}
	}
	public void addInterest(){
		double interest=balance * interestRate;
		deposit(interest);
		System.out.println("Interest added:"+interest);
	}
}
//checking 
class CheckingAccount extends Account{
	private double overDraftLimit=100.0;

	public CheckingAccount(double initalBalance){
		super(initalBalance);
	}
	public void withdraw(double amount){
		if(balance>=overDraftLimit){
			super.withdraw(amount);
		}else{
			System.out.println("Overdraft limit reached in checking amount");
		}
	}
	public void writecheck(double amount){
		withdraw(amount);
		System.out.println("Checkin written for :"+amount);
	}
}
//main 
public class bank{
	public static void main(String args[]){
		SavingAccount s=new SavingAccount(500);
		CheckingAccount c=new CheckingAccount(500);

		s.deposit(100);
		s.withdraw(50);
		s.addInterest();
		s.displayBalance();

		c.deposit(100);
		c.withdraw(50);
		c.writecheck(50);
		c.displayBalance();
	
	}
}
