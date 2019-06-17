

package katasg_bank.Utils;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import katasg_bank.Models.SimpleUser;

/**
 *This class is mainly used for test purpose 
 *it will add some users and information to the storagefile
 *we can also use this class in order to creat new users 
 *@author  Nadjem Nadir
 *@version 1.0
 */

public class Loader {

	/**
	 * This is the main method of this class ,
	 * all edit must be applied here 
	 * @throws TransactionExceptions
	 * @throws InterruptedException
	 */

	public static void loadInitialData() throws TransactionExceptions, InterruptedException {
		ArrayList<SimpleUser> users = new  ArrayList<SimpleUser>();

		SimpleUser nadir = new SimpleUser.UserBuilder("Nadir47", "password")
				.withBalance(120000)
				.build(); 
		SimpleUser saad = new SimpleUser.UserBuilder("Saad", "password2")
				.withBalance(160000)
				.build(); 
		SimpleUser admin = new SimpleUser.UserBuilder("Admin", "password3")
				.withBalance(160000)
				.build();  

		nadir.withdraw(120);
		nadir.withdraw(120);
		nadir.deposit(120);
		nadir.withdraw(120);  
		sleep(2000);
		nadir.deposit(240);
		saad.withdraw(120);
		saad.withdraw(120);
		saad.deposit(120);
		saad.withdraw(120); 
		users.add(nadir);
		users.add(saad);
		users.add(admin);
		StorageEngine.StoreDataToFile(users);


	}
}
