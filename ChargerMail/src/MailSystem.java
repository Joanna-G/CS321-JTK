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
		int index = 0;
		
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				break;
			}
			index++;
		}
		
		deleteAccount(userName,null);
		userQueue.remove(index);
		
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
	
	public void addAccount(String userName,Account newAccount){

		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				temp.addAccount(newAccount);
				accountQueue.add(newAccount);
			}
		}
		
		printAllAccounts();
		
	}
	
	public void deleteAccount(String userName,String account){
		
		if (account != null){ //deleting a particular account
		
		Iterator<User> list = userQueue.iterator();
		while (list.hasNext())
		{
			User temp = list.next();
			if(temp.getUserName().equals(userName))
			{
				temp.deleteAccount(account);
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
		}
		
		else //deleting all accounts of a user
		{
			Iterator<Account> list = accountQueue.iterator();
			Account temp;
			String uName = null;
			ArrayList<String> tempStore = new ArrayList<String>();
			
			while (list.hasNext())
			{
				temp = list.next();
				uName = temp.getUsername();
				//System.out.println("This account name is: " + temp.getAccountName() + ". The username is: " + temp.getUsername());
				if (temp.getUsername().equals(userName))
				{
					tempStore.add(temp.getAccountName());
				}
			}
			
			Iterator<String> indices = tempStore.iterator();
			
			String tempStr;
			
			while(indices.hasNext())
			{
				tempStr = indices.next();
				deleteAccount(uName,tempStr);
			}
			
		}
		
		//printAllAccounts();

		
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
			System.out.println(temp.getAccountName() + "belongs to: " + temp.getUsername());
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
