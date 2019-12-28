
package com.moneytransfer.services;

public interface IAccountService {
    MoneyTransferResponse TransferMoney(int fromAccount, int toAccount, double amount);
}
