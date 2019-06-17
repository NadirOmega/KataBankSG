
package katasg_bank;
import katasg_bank.Utils.Loader;
import katasg_bank.Utils.StorageEngine;
import katasg_bank.Utils.TransactionExceptions;
import katasg_bank.View.LoginForm;
import katasg_bank.Models.SimpleUser;
import java.io.IOException;
import java.util.ArrayList;

/**
 *Main class to launch the program
 *File storage is used instead of database
 *GUI interface is used instead of console 
 *@author  Nadjem Nadir
 *@version 1.0
 */

public class KataSG_Bank {
	public static ArrayList<SimpleUser> usersLoaded = new  ArrayList<SimpleUser>();

	public static void main(String[] args) throws IOException, TransactionExceptions, InterruptedException {
		// Comment line below when second use,
		// otherwise there is no save to the new  data !
		Loader.loadInitialData();
		//
		try {
			usersLoaded=StorageEngine.LoadDataFromFile("usersData");
			usersLoaded.forEach((SimpleUser user) -> {
				System.out.println(user.getState());
			});


			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new LoginForm().setVisible(true);
				}
			});
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
