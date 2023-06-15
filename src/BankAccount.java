
import java.util.HashMap;

public class BankAccount extends Person implements BankTransactions {

    private double balance;
    private final String bankName;
    HashMap<String, Double> map = new HashMap<>();

    public BankAccount(String name, double balance, String bankName) {
        super(name);
        this.balance = balance;
        this.bankName = bankName;
    }

    public String getInfo() { //gets name, bank name and balance
        return "~~~~~\n" + this.name + " is using " + bankName + ".\nAccount balance: $" + balance + "\n~~~~~";
    }


    @Override //From BankTransactions interface
    public void deposit(double add, String date) {
        map.put(date + " Deposit: + $", add);
        balance += add;
        System.out.println(this.name + " deposited $" + add + " with remaining balance of $" + this.balance);
    }

    @Override //From BankTransactions interface
    public void withdrawal(double sub, String date) {
        if (balance - sub < 0) {
            map.put(date + " Action declined: ", 0.0);
            System.out.println("Cannot withdraw $" + sub + ". Balance cannot be negative.");
        } else {
            map.put(date + " Withdraw: - $", sub);
            balance -= sub;
            System.out.println(this.name + " withdrew $" + sub + " with remaining balance of $" + this.balance);
        }
    }

    @Override //From BankTransactions
    public void pay(Person person, double amount, String date) {
        if (balance - amount < 0) {
            map.put(date + " Action declined: ", 0.0);
            System.out.println("Cannot send $" + amount + "to " + person + " Balance cannot be negative.");
        }else {
            map.put(date+" Money sent to "+ person+": $",amount);
            balance-=amount;
            System.out.println(this.name + " sent $"+ amount+" to " +person+" with remaining balance of $" + this.balance);
        }

    }



    public void getBalance() {
        System.out.println(this.name + " has a balance of $" + balance);
    }




    public void getTransactions() {
        if (!map.isEmpty()) {
            System.out.println(this.name + "'s transactions:\n---------------");
            map.forEach((key, value) -> System.out.println(key + value));
            System.out.println("---------------");
        } else {
            System.out.println(this.name + "'s transactions:\n---------------");
            System.out.println("No transactions");
            System.out.println("---------------");
        }

    }


}
