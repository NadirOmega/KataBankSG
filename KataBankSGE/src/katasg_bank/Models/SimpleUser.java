
package katasg_bank.Models;

import java.util.ArrayList;
import katasg_bank.Utils.DateUtil;
import katasg_bank.Utils.MyController;
import katasg_bank.Utils.TransactionExceptions.*;

/**
 * This is the prototype of a simple user 
 * the main user Type of the program
 * inherit from User class and implement the vuilder design pattern
 * in the futur , certainly the user will carry more data , thats why its better 
 * to use this pattern and also to force a simple user to have an 
 * Username and Password as required attribut at the begining 
 *@author  Nadjem Nadir
 *@version 1.0
 */

public class SimpleUser extends User{
	protected static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private double balance;
	private ArrayList<Transaction> transactions =new ArrayList<>();
	private TransactionFactory transactionFactory = new TransactionFactory();;

	// constructor set to private for the builder
	private SimpleUser() {
		super();
	}



	/* Builder class */

	public static class UserBuilder {
		private String userName;
		private String passWord;
		private double balance=100;
		private ArrayList<Transaction> transactions =new ArrayList<>();
		//Force the construction to have userName and passWord atributs as required 
		public UserBuilder(String userName,String passWord){
			this.userName=userName;
			this.passWord=passWord;
		}

		public UserBuilder withBalance(double balance){
			this.balance = balance;
			return this;
		}
		public UserBuilder withTranscations(ArrayList<Transaction> transactions){
			this.transactions =  transactions;
			return this;
		}
		public SimpleUser build(){

			SimpleUser simpleUser = new SimpleUser();
			simpleUser.userName = this.userName;
			simpleUser.passWord = this.passWord;
			simpleUser.balance = this.balance;
			simpleUser.transactions = this.transactions;

			return simpleUser;
		}
	}

	/**method to withdraw money from an account ,
	 * and add this to transaction list
	 * 
	 * @param ammountWithdraw
	 * @throws InsufficientBalanceException ,NegativeAmmountException
	 * @throws katasg_bank.Utils.TransactionExceptions.NegativeAmmountException
	 */
	@Override
	public void withdraw(double ammountWithdraw) throws InsufficientBalanceException,NegativeAmmountException {
		synchronized(this)
		{
			if(ammountWithdraw>balance) 
				throw new InsufficientBalanceException();
			if (MyController.checkIfNegativeAmount(ammountWithdraw)) 
				throw new NegativeAmmountException();


			balance-=ammountWithdraw;
			transactions.add(transactionFactory.getTransaction(TransactionFactory.TYPE_WITHDRAW,DateUtil.getActualDateAsDateObject(),ammountWithdraw));
		}
	}
	/**method to deposit money to an account ,
	 *and add this to transaction list
	 * 
	 * @param amountToDeposit
	 * @throws NegativeAmmountException 
	 */
	@Override
	public void deposit(double amountToDeposit) throws NegativeAmmountException{
		synchronized(this) {
			if (MyController.checkIfNegativeAmount(amountToDeposit)) 
				throw new NegativeAmmountException();

			balance+=amountToDeposit;
			transactions.add(transactionFactory.getTransaction(TransactionFactory.TYPE_DEPOSIT,DateUtil.getActualDateAsDateObject(),amountToDeposit));
		}
	}

	/*GETTERS AND SETTERS */


	@Override
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	/* GETTER AND SETTER */ 

	/**
	 * better to duplicate the list when we get it,
	 * because List is retrieved by reference  
	 */

	public ArrayList<Transaction> getTransactions() {
		//duplicate the list for the Getter
		return new ArrayList<Transaction>(this.transactions);
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	/**
	 * Show all transactions of an user
	 */
	public void showAllTransaction(){
		System.out.println("Showing all transactions \n ");
		this.transactions.forEach((tmpT) -> {
			System.out.println(tmpT.toString());
		});
	}
	/**
	 * same as Show all transaction but evertything is recovered as a String
	 * @return String that containts all the transaction as a String
	 */
	public String getAllTransactionAsString(){
		StringBuffer tempString= new StringBuffer("Showing all transactions \n" );

		this.transactions.forEach((tmpT) -> {
			tempString.append(tmpT.toString());
			tempString.append("\n");
		});
		return tempString.toString();
	}
	/**
	 * Method to get the current state of a costumer account
	 * @return String that contains all important informations of the user
	 */
	public String getState() {
		StringBuffer tempString= new StringBuffer("User name is : ");
		tempString.append(this.userName);
		tempString.append("\n");
		tempString.append(getAllTransactionAsString());
		return tempString.toString();
	}
	/**
	 * Update user info from existing user
	 * this will be used before saving information to the file 
	 * 
	 * @param simpleUser : the user to be duplucated
	 */
	public void updateUser(User simpleUser){

		this.setTransactions(simpleUser.getTransactions());
		this.setBalance(simpleUser.getBalance());
	}

}
