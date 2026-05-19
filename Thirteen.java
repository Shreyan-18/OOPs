class AccountManager {
    String name;
    BankAccount[] accounts; 
    int count;              
    final int MAX_SIZE = 100; 

    AccountManager(String name) {
        this.name = name;
        this.accounts = new BankAccount[MAX_SIZE];
        this.count = 0;
    }

    public void create(int accno, float balance, String name) {
        if (count < MAX_SIZE) {
            accounts[count] = new BankAccount(accno, name, balance);
            count++;
        } else {
            System.out.println("Bank is full!");
        }
    }

    public void delete(int accno) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accno) {
               for (int j = i; j < count - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[count - 1] = null; 
                count--;
                return;
            }
        }
        System.out.println("Not found");
    }

    public void credit(int accno, float n) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accno) {
                accounts[i].add(n);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void debit(int accno, float n) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accno) {
                accounts[i].subtract(n);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("empty");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Name = " + accounts[i].name + 
                               " Account number = " + accounts[i].getAccountNumber() + 
                               " Balance = " + accounts[i].balance);
        }
    }
}
class BankAccount
{
    final int accno;
    float balance;
    String name;
    BankAccount(int accno,String name,float balance)
    {
        this.accno = accno;
        this.name = name;
        this.balance = balance;
    }
    public void balance()
    {
        System.out.println("Balance = "+balance);
    }
    public void add(float n)
    {
        balance+=n;
    }
    public void subtract(float n)
    {
        if(n>0 && this.balance>=n)
        balance-=n;
        else
        System.out.println("Not possible");
    }
    public int getAccountNumber()
    {
        return accno;
    }

}
class Thirteen
{
    public static void main(String[] args) 
    {
       AccountManager a = new AccountManager("Raj"); 
       String name[] = {"Ramesh","Suresh","Mukesh","Ritesh","Digvesh"};
       int[] accno = {1,2,3,4,5};
       float[] balance = {10000.34f,802.33f,0.0f,36478.98f,160.93f};
       for(int i = 0; i<5; i++)
       {
          a.create(accno[i],balance[i],name[i]);
       }
       a.printAll();
       System.out.println("Lets see credit");
       float k = 10000.0f;
       for(int i = 0; i<5; i++)
       {
          a.credit(accno[i],k);
          k=k+1000;
       }  
       a.printAll();    
       System.out.println("Lets see Debit");
       k = 10000;
       for(int i = 0; i<5; i++)
       {
          a.debit(accno[i],k);
          k=k+1000;
       } 
       a.printAll();         
    }
}