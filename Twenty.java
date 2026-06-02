import java.util.ArrayList;
import java.util.List;

class Account 
{
    private String accountNumber;
    private String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) 
    {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() 
    {
        return accountNumber;
    }
    public String getHolderName() 
    {
        return holderName;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void setHolderName(String holderName) 
    {
        this.holderName = holderName;
    }
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.printf("Account No: %s | Holder: %s | Balance: $%.2f", 
                accountNumber, holderName, balance);
    }
}

class SavingsAccount extends Account 
{
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) 
    {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    public double getInterestRate() 
    {
        return interestRate;
    }
    public void setInterestRate(double interestRate) 
    {
        this.interestRate = interestRate;
    }
    public double calculateYearlyInterest() 
    {
        double interest = getBalance() * interestRate;
        System.out.printf("Yearly Interest for Account %s is: $%.2f%n", getAccountNumber(), interest);
        return interest;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf(" | Type: Savings | Interest Rate: %.1f%%%n", (interestRate * 100));
    }
}

class CurrentAccount extends Account {
    
    CurrentAccount(String accountNumber, String holderName, double balance) 
    {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(" | Type: Current");
    }
}

class Manager {
    private List<Account> accountList;
    private String managerName;
    public Manager(String name) 
    {
        this.accountList = new ArrayList<>();
        this.managerName = name;
        System.out.printf("Hello my name is %s%n",managerName);
    }
    public void addAccount(Account acc) 
    {
        accountList.add(acc);
    }

    public void calculateSavingsInterest() 
    {
        double d;
        System.out.println("\n--- Calculating Yearly Interest for Savings Accounts ---");
        for (Account acc : accountList) 
        {
            if (acc instanceof SavingsAccount) 
            {
                SavingsAccount savingsAcc = (SavingsAccount) acc;
                d = savingsAcc.calculateYearlyInterest();
            }
        }
    }

    public void printAllAccounts() {
        System.out.println("\n--- All Account Details ---");
        for (Account acc : accountList) {
            acc.displayDetails();
        }
    }
}

public class Twenty {
    public static void main(String[] args) {
        Manager bankManager = new Manager("Ramjan");

        bankManager.addAccount(new SavingsAccount("SA101", "Tiyasa Ghosh", 500000.00, 0.04));
        bankManager.addAccount(new SavingsAccount("SA102", "Anushka Chatterjee", 12000.50, 0.05));

        bankManager.addAccount(new CurrentAccount("CA201", "Pragati Mitra", 2500.30));
        bankManager.addAccount(new CurrentAccount("CA202", "Sikriti Debnath", 7500.25));
        bankManager.addAccount(new CurrentAccount("CA203", "Sudeshna Gargari", 1150.00));

        bankManager.calculateSavingsInterest();

        bankManager.printAllAccounts();
    }
}