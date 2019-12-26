import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import com.moneytransfer.domain.*;
import com.moneytransfer.services.*;

public class MoneyTransferServiceTest {
	public MoneyTransferServiceTest() {
    }
	
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
    	AccountRepository repo = new AccountRepository();
    	
    	// Act
    	MoneyTransferResponse response = repo.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), true);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidAmount() {
    	
    	// Arrange
    	int fromAccnt = 1;
    	int toAccnt = 2;
    	double amount = 0.0;
    	AccountRepository repo = new AccountRepository();
    	
    	// Act
    	MoneyTransferResponse response = repo.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidFromAccount() {
    	
    	// Arrange
    	int fromAccnt = 1;
    	int toAccnt = 0;
    	double amount = 10.0;
    	AccountRepository repo = new AccountRepository();
    	
    	// Act
    	MoneyTransferResponse response = repo.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    @Test
    public void shouldTransferMoneyUnsuccessfullyForInvalidToAccount() {
    	
    	// Arrange
    	int fromAccnt = 0;
    	int toAccnt = 1;
    	double amount = 10.0;
    	AccountRepository repo = new AccountRepository();
    	
    	// Act
    	MoneyTransferResponse response = repo.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }
    
    public void shouldTransferMoneyUnsuccessfullyForInvalidParam() {
    	
    	// Arrange
    	int fromAccnt = 0;
    	int toAccnt = 0;
    	double amount = 0.0;
    	AccountRepository repo = new AccountRepository();
    	
    	// Act
    	MoneyTransferResponse response = repo.TransferMoney(fromAccnt, toAccnt, amount);
    	
    	// Assert
    	assertEquals(response.getTransferStatus(), false);
    }

}
