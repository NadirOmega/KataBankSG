
package katasg_bank.Utils;

import katasg_bank.Models.SimpleUser;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *This class represente the Storage Engine of the project
 *All data are saved in a file as an array List
 *We can improve this programme by saving this Data as a Key value Array,
 *also make path as an attribut, the purpose of this program is to transactions 
 *that why storage is neglected
 *@author  Nadjem Nadir
 *@version 1.0
 **/
public class StorageEngine {

	/**
	 * Method that save users list to a file 
	 * @param users: list of used to be saved to the current File
	 */
	public static void StoreDataToFile(ArrayList<SimpleUser> users){
		try
		{
			File myDataFileStorage =new File("usersData");
			FileOutputStream fos = new FileOutputStream(myDataFileStorage);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	/**
	 * This class is usef to load User data from a file 
	 * @param path of the file to read
	 * @return list of Saved users in the file 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<SimpleUser> LoadDataFromFile(String path) throws ClassNotFoundException, IOException{
		ArrayList<SimpleUser> users = new ArrayList<SimpleUser>();
		try
		{

			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		}
		catch (EOFException e){System.out.println("File is empty ");}
		catch (FileNotFoundException e){ 
			System.out.println("we are here ");
			File file = new File(path);
			if(file.createNewFile())System.out.println("FILE CREATED !");
			else System.out.println ("Error ");}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		return users;
	}  

}
