
package katasg_bank.Models;

import katasg_bank.Models.DepositTransaction;
import katasg_bank.Models.WithdrawTransaction;
import katasg_bank.Models.Transaction;
import java.io.Serializable;
import java.util.Date;

/**
 *class responsible for creating objects of a specific type
 *the factory class must be public and must have 
 * a constructor that accepts no parameters.
 *  The type of Transaction that can be instantiate  :
 * <ul>
 *	 <li>DepositTransaction
 * 	 <li>WithdrawTransaction
 * </ul>
 *@author  Nadjem Nadir
 *@version 1.0
 */

public class TransactionFactory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//1 for deposit
	public static final int TYPE_DEPOSIT = 1;
	//2	for withdraw
	public static final int TYPE_WITHDRAW= 2;

	/**
	 * This method is responsible for creating the transactions
	 * 
	 * @param typeTransaction 1 for the deposit type , 2 for the withdraw type 
	 * @param dateTime of the transcation ( the tile we do the transaction)
	 * @param amount
	 * @return 
	 */
	public Transaction getTransaction(int typeTransaction,Date dateTime,double amount){
		Transaction transaction = null;
		switch(typeTransaction){
		case TYPE_DEPOSIT:
			transaction = new DepositTransaction(dateTime,amount);
			break;
		case TYPE_WITHDRAW:
			transaction = new WithdrawTransaction(dateTime,amount);
			break;
		default:
			throw new IllegalArgumentException("transaction type doesn't exist");
		}
		return transaction;

	}
}
