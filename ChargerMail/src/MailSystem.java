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
	
	public boolean isNewUserUnique(String userName){
		
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				System.out.print("There exists a user with this name already");
				return false;
			}
		}
		 return true;
	}
	
	/**
	 * Attempts to create a new user within system
	 * @param userName the desired user name of the new user
	 */
	
	public void addNewUser(User newUser){
		
		
			userQueue.add((newUser));		
	}
	
	/**
	 * Deletes user from System
	 * @param userName name of user to delete
	 */
	
	public void deleteUser(String userName){
		
		//remove from system userQueue
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			if(list.next().getUserName().equals(userName))
			{
				list.remove();
			}
		}
		
		
		//remove user accounts from accountQueue
		
		Iterator<Account> listb = accountQueue.iterator();
		while (listb.hasNext())
		{
			
			if(listb.next().getUsername().equals(userName))
			{
				listb.remove();
			}
		
		}
		
		printAllAccounts();
		
	}
	
	/**
	 * Transfer messages among users
	 * @param msg Message to be sent
	 */
	
	public void transferMessage(String aNameSender,String aNameReceiver,Message msg,int type){
		
		
		if(type == 0) //send to recipient inbox
		{
			Iterator<Account> list = accountQueue.iterator();
			while (list.hasNext())
			{
				Account temp = list.next();
				
				if(temp.getAccountName().equals(aNameReceiver))
				{
					temp.receiveMessage(type, msg);
				}
			}
			
		}
		
		else if (type == 1) //send to sent box
		{
			Iterator<Account> list = accountQueue.iterator();
			while (list.hasNext())
			{
				Account temp = list.next();
				
				if(temp.getAccountName().equals(aNameSender))
				{
					temp.receiveMessage(type, msg);
				}
			}
			
		}
		
		
		
	}
	
	/**
	 * Sends user firstname to GUI when username is provided
	 * @param username
	 * @return first name of user
	 */
	public String retrieveFirstName(String username)
	{
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(username))
			{
				return temp.getGivenName();
			}
		}
		return null; //since a user must be clicked on, this statement is never actually reached. This is inserted to comply with Java syntax
		
		
	}
	
	public String retrieveLastName(String username)
	{
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(username))
			{
				return temp.getSurname();
			}
		}
		return null; //since a user must be clicked on, this statement is never actually reached. This is inserted to comply with Java syntax
		
		
	}
	
	public int getNumUsers()
	{
		return userQueue.size();
	}
	
	public void addAccount(String userName,Account newAccount,boolean local){

		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				temp.addAccount(newAccount,local);
				accountQueue.add(newAccount);
			}
		}
		
		printAllAccounts();
		
	}
	
	public void deleteAccount(String userName,String account,boolean local){
		
		
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				temp.deleteAccount(account,local);
			}
		}
		
		Iterator<Account> listA = accountQueue.iterator();
		
		int index = 0;
		
		while (listA.hasNext())
		{
			Account temp = listA.next();
			if(temp.getAccountName().equals(account))
			{
				break;
			}
			index++;
		}
		
		accountQueue.remove(index);
		
		printAllAccounts();
		}
	
	
		
		
	
	

	public ArrayList<Message> getMessages(String aName,int type)
	{
		Iterator<Account> list = accountQueue.iterator();
		while (list.hasNext())
		{
			Account temp = list.next();
			if(temp.getAccountName().equals(aName))
			{
				return temp.getMailboxMessages(type);
			}
		}
		
		return null;
		
	}
	
	public void printAllAccounts()
	{
		Iterator<Account> list = accountQueue.iterator();
		System.out.println("SYSTEM:");
		Account temp;
		while (list.hasNext())
		{
			temp = list.next();
			System.out.println(temp.getAccountName() + " which belongs to: " + temp.getUsername());
		}
	}
	
	public boolean accountExists(String aName)
	{
		Iterator<Account> list = accountQueue.iterator();
		Account temp;
		while (list.hasNext())
		{
			temp = list.next();
			if(temp.getAccountName().equals(aName))
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	public void deleteMessage(String account, String mess,int type)
	{
		Iterator<Account> list = accountQueue.iterator();
		Account temp;
		while (list.hasNext())
		{
			temp = list.next();
			if(temp.getAccountName().equals(account))
			{
				temp.removeMessage(mess, type);
			}
		}
		
		
		
	}
	
	private ArrayList<User> userQueue;
	private ArrayList<Account> accountQueue;

}
