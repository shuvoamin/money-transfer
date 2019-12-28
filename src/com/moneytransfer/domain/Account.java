package com.moneytransfer.domain;


public class Account {
	
	public Account() { }
	
	public Account(int number, double balance) {
		this.number = number;
		this.balance = balance;
	}
	
	private int number;
	private double balance;
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void makeDeposit(double ammount) {
            balance = balance + ammount;
            setBalance(balance);
        }
        
        public Boolean withdraw(double amount) {
            if (balance >= amount){
                balance = balance - amount;
                setBalance(balance);
                return true;
            }
            
            return false;
        }

}
