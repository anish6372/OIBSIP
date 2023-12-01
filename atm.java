import java.util.*; 

class demoatm 
{ 
	String name; 
	String userName; 
	String password; 
	String accountNo;
	int prevTransaction;
	int balance = 15000; 
	int transactions = 0; 
	int flag = 0;
	String transactionHistory = "";
	
	public void register() 
	{ 
		Scanner get = new Scanner(System.in); 
		System.out.print("Enter Name: "); 
		this.name = get.nextLine(); 
		System.out.print("Enter Username: "); 
		this.userName = get.nextLine(); 
		System.out.print("Enter Password: ");
		this.password = get.nextLine(); 
		System.out.print("Enter Account Number: "); 
		this.accountNo = get.nextLine(); 
		System.out.println("Registration Completed you can Login To Proceed"); 
	}
	
	public void checkBalance() 
	{
		System.out.println("Rs. " + balance); 
	} 
	
	public void deposit() 
	{ 
		System.out.print("Enter amount to deposit: "); 
		Scanner get = new Scanner(System.in); 
		int amount = get.nextInt(); 
		try 
		{ 
			if (amount <= 100000) 
			{ 
				transactions++;
				balance += amount; 
	            prevTransaction = amount;
				System.out.println("your money has been Successfully Deposited!!"); 
				String str = "Rs." + amount + " deposited\n"; 
				transactionHistory = transactionHistory.concat(str); 
			} 
			else 
			{
				System.out.println("Sorry you are exceeding your limit the limit is 10000"); 
			} 
		} 
		catch (Exception e) 
		{
		} 
	}
	
	public void withdraw() 
	{
		System.out.print("Enter amount to withdraw: "); 
		Scanner get = new Scanner(System.in); 
		int amount = get.nextInt(); 
		try 
		{ 
			if (balance >= amount) 
			{ 
				transactions++; 
				balance -= amount;
	            prevTransaction -= amount;
				System.out.println(" Successful! Withdrwal"); 
				String amn = "Rs." + amount + " withdrew\n"; 
				transactionHistory = transactionHistory.concat(amn); 
			} 
			else 
			{ 
				System.out.println("Insufficient Balance.!"); 
			} 
		}
		catch (Exception e)
		{ 
		} 
	} 
	
	public void transfer() 
	{
		Scanner get = new Scanner(System.in); 
		System.out.print("Enter Receiver's Name: "); 
		String receiver = get.nextLine(); 
		System.out.print("Enter amount to transfer: "); 
		int amount = get.nextInt(); 
		try 
		{ 
			if (balance >= amount) 
			{ 
				if (amount <= 100000) 
				{ 
					transactions++; 
					balance -= amount; 
					System.out.println(amount + " Successfully Transferred to " + receiver); 
					String str = amount + " Rs. transferred to " + receiver + "\n"; 
					transactionHistory = transactionHistory.concat(str); 
				} 
				else 
				{ 
					System.out.println("Sorry!! Limit is Rs.100000."); 
				} 
			} 
			else 
			{ 
				System.out.println("Transfer failed due to insufficient balance!"); 
			} 
		} 
		catch (Exception e) 
		{ 
		} 
	}
	
	
	public void transHistory() 
	{ 
		if (transactions == 0)
		{ 
			System.out.println("Empty!!"); 
		} 
		else 
		{ 
			System.out.println("\n" + transactionHistory);
		} 
	}
	
	public boolean login() 
	{ 
		boolean isLogin = false; 
		Scanner get = new Scanner(System.in); 
		while (!isLogin)
		{
			System.out.print("Enter Username: "); 
			String Username = get.nextLine(); 
			if ( Username.equals(userName) )
			{
				while (!isLogin) 
				{ 
					System.out.print("Enter Password: "); 
					String Password = get.nextLine();
					if ( Password.equals(password) )
					{ 
						System.out.print("Login Success!!"); 
						isLogin = true;
					} 
					else 
					{ 
						System.out.println("Incorrect Password..."); 
					} 
				} 
			} 
			else 
			{ 
				System.out.println("Username not found."); 
			} 
		} 
		return isLogin; 
	} 
} 

public class atm 
{ 
	public static int takeingIntegerInput(int limit) 
	{ 
		int input = 0;
		boolean flag = false;
		while (!flag) 
		{ 
			try 
			{ 
				Scanner n = new Scanner(System.in); 
				input = n.nextInt(); 
				flag = true; 
				if (flag && input > limit || input < 1)
				{ 
					System.out.println("Choose the number between 1 to " + limit + "."); 
					flag = false; 
				} 
			} 
			catch (Exception e) 
			{ 
				System.out.println("Enter only integer value."); 
				flag = false;
			} 
		};
		return input; 
	} 
	
	public static void main(String[] args) 
	{
		System.out.println("- WELCOME TO my ATM INTERFACE --\n"); 
		System.out.println("1.Register\n2.Exit"); 
		System.out.print("Enter your Choice: "); 
		int choice = takeingIntegerInput(2); 
		if (choice == 1) 
		{
			demoatm y = new demoatm(); 
			y.register(); 
			while(true) 
			{ 
				System.out.println("\n1.Login\n2.Exit"); 
				System.out.print("Enter Your Choice: "); 
				int ch = takeingIntegerInput(2);
				if (ch == 1) 
				{
					if (y.login()) 
					{ 
						System.out.println("\n\n-- WELCOME " + y.name + " --\n"); 
						boolean isdone = false; 
						while (!isdone) 
						{ 
							System.out.println("\n1.Check the Balance\n2.Transaction History\n3.Withdraw\n4.Deposit\n6.Transfer\n7.Quit"); 
							System.out.print("\nEnter Your Choice: "); 
							int c = takeingIntegerInput(7); 
							switch(c) 
							{ 
							case 1: y.checkBalance (); 
							break; 
							case 2: y.transHistory(); 
							break; 
							case 3: y.withdraw(); 
							break; 								
							case 4: y.deposit(); 
							break; 
							case 6:y.transfer();
							break;
							case 7: isdone = true; 
							break; 
							}
						} 
					} 
				}
				else 
				{ 
					System.exit(0); 
				}
			} 
		} 
		else 
		{ 
			System.exit(0); 
		} 
	}
}
