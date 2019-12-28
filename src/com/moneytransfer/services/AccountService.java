package com.moneytransfer.services;

import com.moneytransfer.domain.Account;
import com.moneytransfer.domain.AccountRepository;

public class AccountService {
    
        private AccountRepository accountRepository = new AccountRepository();
        
	public MoneyTransferResponse TransferMoney(int fromAccount, int toAccount, double amount) {
		
		Account frmAccnt = null;
		Account toAccnt = null;
		MoneyTransferResponse transferResponse = new MoneyTransferResponse(false, "Transfer unsuccessful");
		
		for(Account accnt : accountRepository.GetAllAccounts()){
			
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
		
                // ideally we'll be wrapping this in a 'transaction'
		if (frmAccnt != null && toAccnt != null && amount > 0) {
                        
                        // first we need to make sure withdraw is success
                        // fromAccount
                        if (frmAccnt.withdraw(amount)){
                            transferResponse.setOldBalance(toAccnt.getBalance());
                            
                            // update the balance
                            toAccnt.makeDeposit(amount);
                            
                            transferResponse.setDepositedAccount(toAccnt.getNumber());
                            transferResponse.setNewBalance(toAccnt.getBalance());
                            transferResponse.setTransferStatus(true);
                            transferResponse.setMessage("Transfer successful"); 
                        }
                        // if withdraw unsuccessful then, 
                        // enough money isn't available in fromAccount
                        else {
                            transferResponse.setOldBalance(toAccnt.getBalance());
                            transferResponse.setDepositedAccount(toAccnt.getNumber());
                            transferResponse.setNewBalance(toAccnt.getBalance());
                            transferResponse.setMessage("Transfer unsuccessful, not enough balance available in sender's account"); 
                        }
                        
		}
		
		return transferResponse;
	}    
}
