
package katasg_bank.Utils;

import static katasg_bank.KataSG_Bank.usersLoaded;
import katasg_bank.Models.SimpleUser;
import katasg_bank.Models.User;

/**
 *Controller class that contains major check process 
 *@author  Nadjem Nadir
 *@version 1.0
 */

public class MyController {
	public static User checkUserPswd(String user,String password){

		for(SimpleUser userFromList : usersLoaded){
			if (userFromList.getUserName().equals(user)){
				if (userFromList.getPassWord().equals(password)){
					System.out.println("FOUND ONE ");
					return userFromList;
				}
			}
		} 
		System.out.println("NOTHING HERE ");
		return null;

	}
	public static boolean checkIfNegativeAmount(double amount){
		return (amount<0) ? true: false;

	}
	public static boolean checkIfCorrectValue(String amount) {
		if(amount!=null && !amount.equals(""))
			return true;
		return false;

	}
}
