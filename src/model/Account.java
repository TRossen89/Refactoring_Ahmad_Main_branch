package model;



public class Account {
    private int balance;
    public Account(){
    }
    public int getBalance(){
        return balance;
    }

    void setBalance(int amount){
        this.balance = amount;
    }



    public void updateBalance(int amount){
        this.balance += amount;

    }


}


