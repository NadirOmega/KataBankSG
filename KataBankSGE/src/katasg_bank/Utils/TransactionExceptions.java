
package katasg_bank.Utils;

/**
This Class create the exception used for the withdraw and deposit 

 *@author  Nadjem Nadir
 *@version 1.0
 */
public class TransactionExceptions extends Exception{

	protected static final long serialVersionUID = 1L;

	public TransactionExceptions(String msg){
		super(msg);
	}


	/**
	 * When Negative ammount is used
	 * @author Nad
	 *
	 */
	public static class NegativeAmmountException extends TransactionExceptions {

		public NegativeAmmountException(){
			super("Error the ammount is negative or invalid " );

		}
	}


	/**
	 * When the balance is'nt sufficient to make operations ( only the withdraw 
	 * method is affected till now, but maybe we can improve the programme by adding
	 * some transfert method )
	 * @author Nad
	 *
	 */
	public static class InsufficientBalanceException extends TransactionExceptions {

		public InsufficientBalanceException(){
			super("Error check your balance");

		}
	}
}

