

public interface BankTransactions {

    void deposit(double add,String date);
    void withdrawal(double sub,String date);
    void pay(Person person,double amount,String date);


}
