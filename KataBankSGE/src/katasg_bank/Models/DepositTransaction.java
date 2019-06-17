
package katasg_bank.Models;

import katasg_bank.Models.Transaction;

import java.io.Serializable;
import java.util.Date;

/**
 * This is the deposit transaction inherit from the abstract Transaction model
 *@author  Nadjem Nadir
 *@version 1.0
 */
public class DepositTransaction extends Transaction implements Serializable  {

	private static final String type="Deposit ";
	private static final long serialVersionUID = 1L;


	public DepositTransaction(Date dateTime, double amount) {
		super(dateTime,amount);
	}
	/**
	 * This is a a simplest method return
	 * the type of this object in our case its by default "Deposit"
	 */
	public String getTypeAsString(){
		return type;
	}



}
