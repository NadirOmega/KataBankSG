
package katasg_bank.Models;

import java.io.Serializable;
import java.util.ArrayList;
import katasg_bank.Utils.TransactionExceptions.InsufficientBalanceException;
import katasg_bank.Utils.TransactionExceptions.NegativeAmmountException;

/**
 *This class represente the model of user 
 *abstract class is used for a better adaptation to the futur improvement .
 *ex: 
 *<ul>
 *	 <li>Professional user
 * 	 <li>Administrator
 * 	 <li>Teenagers
 * </ul>
 *@author  Nadjem Nadir
 *@version 1.0
 */


public abstract class User implements Serializable {
	protected static final long serialVersionUID = 1L;
	public abstract void withdraw(double ammountWithdraw) throws InsufficientBalanceException,NegativeAmmountException;
	public abstract void deposit(double amountToDeposit) throws NegativeAmmountException;
	public abstract void updateUser(User temp);
	public abstract String getPassWord();
	public abstract String getUserName();
	public abstract ArrayList<Transaction> getTransactions();
	public abstract double getBalance() ;
	public abstract String getState();
}
