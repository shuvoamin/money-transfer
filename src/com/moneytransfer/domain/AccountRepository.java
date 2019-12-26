package com.moneytransfer.domain;

import java.util.ArrayList;
import java.util.List;

import com.moneytransfer.services.MoneyTransferResponse;

public class AccountRepository {
	
	public MoneyTransferResponse TransferMoney(int fromAccount, int toAccount, double amount) {
		
		Account frmAccnt = null;
		Account toAccnt = null;
		MoneyTransferResponse transferResponse = new MoneyTransferResponse(false, "Transfer unsuccessful");
		
		for(Account accnt : GetAllAccounts()){
			
			if(accnt.getNumber() == fromAccount) {
				frmAccnt = accnt;
			}
			else if(accnt.getNumber() == toAccount) {
				toAccnt = accnt;
			}			
		}
		
		if (frmAccnt == null) {
			transferResponse.setMessage("Invalid 'fromAccount'");
		}
		
		if (toAccnt == null) {
			transferResponse.setMessage("" + transferResponse.getMessage() + ", Invalid 'toAccount'");
		}
		
		if (amount <= 0) {
			transferResponse.setMessage(("" + transferResponse.getMessage() + ", Transfer amount must be greater than '0'"));
		}
		
		if (frmAccnt != null && toAccnt != null && amount > 0) {
			
			toAccnt.makeDeposit(amount);
			
			transferResponse.setTransferStatus(true);
			transferResponse.setMessage("Transfer successful");
		}
		
		return transferResponse;
	}
	
	private List<Account> GetAllAccounts(){
		
		List<Account> dummyAccounts = new ArrayList<Account>();
		
		for(int i = 1; i < 100; i++) {			
			dummyAccounts.add(new Account(i, i * 100));	
		}
		
		return dummyAccounts;	
	}

}
