

public class Main {
    public static void main(String[] args) {

        BankAccount sandro = new BankAccount("Sandro", 100.0, "Bank of America");
        System.out.println(sandro.getInfo());
        sandro.deposit(20, "6/13/2023");
        sandro.withdrawal(121, "6/14/2023");
        sandro.getBalance();
        sandro.getTransactions();

        BankAccount bob  = new BankAccount("Bob",200,"TD bank");
        System.out.println(bob.getInfo());
        bob.pay(sandro,20,"6/15/2023");
        bob.getBalance();
        bob.getTransactions();



    }


}