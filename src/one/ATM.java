package one;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private double balance;
    private String user;

    public ATM(int initialBalance) {
        this.balance = (double) initialBalance;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Not a valid amount!");
            return;
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
    	if (amount <= 0) {
    		 System.out.println("Not a valid amount!");
             return;
        }
        if (amount > balance) {
            System.out.println("Error: Not enough balance!");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public void printBalance() {
        System.out.println(user + "'s balance: $" + balance);
    }
    
    public static void main(String[] args) {
    	// try with resource
        try (Scanner scanner = new Scanner(System.in);
        	Scanner scan = new Scanner(System.in)){
	        ATM myATM = new ATM(500);
	
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        if(name.isBlank()) {
	        	name = "default name";
	        }
	        myATM.setUser(name);
	        
	        // email: diddiw@cceec.fefe
	        
	        /// username : at least 6 characters
	        boolean running = true;
	        while (running) {
	            System.out.println("\n1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Show Balance");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice;
	            
            	choice = (int) receiveDouble(scanner);
	            
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter deposit amount: ");
	                    double depositAmount = receiveDouble(scanner);
	                    myATM.deposit((int)depositAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter withdrawal amount: ");
	                    double withdrawAmount = receiveDouble(scanner);
	                    myATM.withdraw(withdrawAmount);
	                    break;
	                case 3:
	                    myATM.printBalance();
	                    break;
	                case 4:
	                    System.out.println("Thank you! Goodbye.");
	                    System.exit(0);
	                    break;
//	                case 0:
//	                	running = false;
//	                	continue;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	            
	        }
	        // after while loop still in try block
        } // end of try block
        // using catch on the outside try block
        // scanner is closed
        System.out.println("After scanner closed");
    }

    // using a private method
	private static double receiveDouble(Scanner scanner) {
		double num = 0;
		try{
			num = scanner.nextDouble();
			return num;
		} catch (InputMismatchException e) {
			scanner.nextLine();
        	System.err.println("Not a valid number!");
        	return receiveDouble(scanner);
        }
	}
}
