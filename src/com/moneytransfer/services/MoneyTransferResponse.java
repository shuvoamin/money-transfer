package com.moneytransfer.services;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MoneyTransferResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public MoneyTransferResponse() {}
	
	public MoneyTransferResponse(Boolean status, String msg) {
		this.transferStatus = status;
		this.message = msg;
	}
	
	private Boolean transferStatus;
	private String message;
        private int depositedAccount;
        private double newBalance;
        private double oldBalance;
        
	public Boolean getTransferStatus() {
		return transferStatus;
	}
	public void setTransferStatus(Boolean transferStatus) {
		this.transferStatus = transferStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
        public void setDepositedAccount(int depositedAccount){
            this.depositedAccount = depositedAccount;
        }
        public int getDepositedAccount(){
            return depositedAccount;
        }
        public void setNewBalance(double newBalance){
            this.newBalance = newBalance;
        }
        public double getNewBalance(){
            return newBalance;
        }
        public void setOldBalance(double oldBalance){
            this.oldBalance = oldBalance;
        }
        public double getOldBalance(){
            return oldBalance;
        }
}
