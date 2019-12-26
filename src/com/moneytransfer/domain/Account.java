package com.moneytransfer.domain;


public class Account {
	
	public Account() { }
	
	public Account(int number, double balance) {
		this.number = number;
		this.balance = balance;
	}
	
	private int number;
	private Double balance;
	
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

}
