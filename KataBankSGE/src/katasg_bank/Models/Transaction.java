

package katasg_bank.Models;

import java.io.Serializable;
import java.util.Date;
import katasg_bank.Utils.DateUtil;


/**
 *This class is  an abstract  model of a transaction ,
 *the inheritance will be used to anticipate the future improvement,
 *in case other transactions will be added (transfer of money, loan)
 *@author  Nadjem Nadir
 *@version 1.0
 */

public abstract class Transaction implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected Date dateTime;
	protected double amount;

	/**method that Compares transaction object with the other transaction
	 * depending on the date time
	 * method will be used to sort a list with date time 
	 * @param transaction
	 * @return 0 if equals ,1 if superior , -1 if inferior
	 */
	public int compareTo(Transaction transaction) {
		return getDateTime().compareTo(transaction.getDateTime());
	}
	
	
	/**
	 * @return The type of the transaction 
	 */
	public abstract String getTypeAsString();

	public Transaction(Date dateTime, double amount) {
		this.dateTime = DateUtil.getActualDateAsDateObject();
		this.amount = amount;
	}


	/**
	 *toString method to describe a transaction object
	 *@return : description of a transaction
	 */

	public String toString(){
		StringBuffer tempString= new StringBuffer();
		tempString.append("Type de transaction : ");
		tempString.append(this.getTypeAsString());
		tempString.append(" Amount :");
		tempString.append(this.amount);
		tempString.append(" Date : ");
		tempString.append(DateUtil.getStringFromDate(this.dateTime));
		return tempString.toString();

	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}
