package com.moneytransfer.domain;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
	
	public List<Account> GetAllAccounts(){
		
		List<Account> dummyAccounts = new ArrayList<Account>();
		
		for(int i = 1; i < 100; i++) {			
			dummyAccounts.add(new Account(i, i * 100));	
		}
		
		return dummyAccounts;	
	}

}
