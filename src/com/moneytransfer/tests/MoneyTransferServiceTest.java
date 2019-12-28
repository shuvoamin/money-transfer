package com.moneytransfer.tests;

import static org.junit.Assert.*;
import org.junit.*;
import com.moneytransfer.services.*;

public class MoneyTransferServiceTest {
    
    private final IAccountService _accountService;
    
    public MoneyTransferServiceTest() {
        _accountService = new AccountService();
    }
        
    // TODO : we need to mock up the account repository
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {       
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void shouldTransferMoneySuccessfully() {
    	
    	// Arrange
    	int fromAccnt = 1;
    	int toAccnt = 2;
    	double amount = 10.0;
    	
    	// Act
    	MoneyTransferResponse response = _accountService.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), true);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidAmount() {
    	
    	// Arrange
    	int fromAccnt = 1;
    	int toAccnt = 2;
    	double amount = 0.0;
    	
    	// Act
    	MoneyTransferResponse response = _accountService.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidFromAccount() {
    	
    	// Arrange
    	int fromAccnt = 1;
    	int toAccnt = 0;
    	double amount = 10.0;
    	
    	// Act
    	MoneyTransferResponse response = _accountService.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidToAccount() {
    	
    	// Arrange
    	int fromAccnt = 0;
    	int toAccnt = 1;
    	double amount = 10.0;
    	
    	// Act
    	MoneyTransferResponse response = _accountService.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidParam() {
    	
    	// Arrange
    	int fromAccnt = 0;
    	int toAccnt = 0;
    	double amount = 0.0;
    	
    	// Act
    	MoneyTransferResponse response = _accountService.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    // TODO
    @Test
    public void shouldWithdrawMoneyFromSenderOnSuccessfullTransfer(){
        assertEquals(true, true);
    }
    
    // TODO
    @Test
    public void senderAndReceiverMustBeDifferentAccount(){
        assertEquals(true, true);
    }

}
