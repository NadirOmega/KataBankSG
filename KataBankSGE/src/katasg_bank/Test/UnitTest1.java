
package katasg_bank.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import katasg_bank.Models.SimpleUser;
import katasg_bank.Utils.TransactionExceptions;
import katasg_bank.Utils.TransactionExceptions.InsufficientBalanceException;
import katasg_bank.Utils.TransactionExceptions.NegativeAmmountException;

/**
 * Test class for the Withdraw / deposit methods
 * Many test are performed in this classe such as :
 * <ul>
 *	 <li>Normal test ( simple case of a withdraw and desosit)
 * 	 <li>Exception catch
 * 	 <li>Some inusual case but have to be tested
 * </ul>
 *@author  Nadjem Nadir
 *@version 1.0
 */

class UnitTest1 {

	/**
	 *
	 * @author Nad
	 */

	private static SimpleUser testUser;
	private static double initialBalance=100;
	@BeforeAll
	public static void creatMyTestInstance(){
		testUser = new SimpleUser.UserBuilder("Nadir47", "password")
				.withBalance(initialBalance)
				.build();

	}
	@Before
	public void initialiseBalance(){
		testUser.setBalance(initialBalance);
	}
	/* Normal test */

	@Test 
	public void checkWithdraw() throws TransactionExceptions{
		double amountToWithdraw=10;
		testUser.setBalance(200);
		testUser.withdraw(amountToWithdraw);
		assertEquals(200-amountToWithdraw,testUser.getBalance());

	}

	@Test
	public void checkDeposit() throws TransactionExceptions{
		double amountToDeposit=10;
		testUser.setBalance(200);
		testUser.deposit(amountToDeposit);
		assertEquals(200+amountToDeposit,testUser.getBalance());

	}


	/*End of Normal tests */



	/*EXCEPTION TESTS*/ 
	@Test
	public void withdrawTestNegativAmmountException(){

		assertThrows(NegativeAmmountException.class,()->{
			testUser.withdraw(-100);
		});
	}
	@Test
	public void depositTestNegativAmmountException(){

		assertThrows(NegativeAmmountException.class,()->{
			testUser.deposit(-100);
		});
	}

	@Test
	public void withdrawInsufficientBalanceException(){	 
		assertThrows(InsufficientBalanceException.class,()->{

			testUser.withdraw(120);
		});
	}
	/*END EXCEPTION TESTS*/ 

	/*Negative Ammount TEST */

	@Test
	public void depositTestNegativeAmmount(){

		try{
			testUser.deposit(-120);
		}catch(NegativeAmmountException e){
			// test purpose only to make sure that if amount is negative , the Balance will not change 
		} 
		assertEquals(initialBalance,testUser.getBalance());
	}
	@Test
	public void withdrawTestNegativAmmount() throws InsufficientBalanceException{

		double initialAmount=100;

		try{
			testUser.withdraw(-50);
		}catch(NegativeAmmountException e){
			// test purpose only to make sure that if amount is negative , the Balance will not change 
		}

		assertEquals(initialAmount,testUser.getBalance());
	}
	/*End Negative Ammount TEST */



	@Test
	public void withdrawTestInsufficientBalanceException() throws NegativeAmmountException {

		double initialAmount=100;

		try{
			testUser.withdraw(120);
		}catch(InsufficientBalanceException e){
			// test purpose only to make sure that if amount is negative , the Balance will not change 
		}

		assertEquals(initialAmount,testUser.getBalance());
	}

}

