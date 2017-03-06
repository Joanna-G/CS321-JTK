import java.util.ArrayList;
import java.util.Iterator;
/**
 *  A class for implementing and managing ChargerMail, a simple mail client
 * @author Tevon Walker
 * 
 */
public class MailSystem {

	/**
	 * Default constructor creates empty system
	 */
	
	public MailSystem(){
		userQueue = new ArrayList();
		accountQueue = new ArrayList();
	}
	
	/**
	 * Checks to see if userName is already taken
	 * @param userName Username to test 
	 * @return a boolean value is returned depending on whether this username is unique or not
	 */
	
	private boolean isNewUserUnique(String userName){
		
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				return false;
			}
		}
		 return true;
	}
	
	/**
	 * Attempts to create a new user within system
	 * @param userName the desired user name of the new user
	 */
	
	public boolean createNewUser(String userName){
		
		if(isNewUserUnique(userName)){
			userQueue.add(new User(userName));
			System.out.print("User '" + userName + "' sucessfully added");
			return true;
		}
		
		else{
			System.out.print("There exists a user with this name already");
			return false;
		}
		
	}
	
	/**
	 * Deletes user from System
	 * @param userName name of user to delete
	 */
	
	public void deleteUser(String userName){
		//TODO: Implement deletion of user
	}
	
	/**
	 * Transfer messages among users
	 * @param msg Message to be sent
	 */
	
	public void transferMessage(Message msg){
		//TODO: Implement message transmission from one user another
	}
	
	
	private ArrayList<User> userQueue;
	private ArrayList<Account> accountQueue;

}
