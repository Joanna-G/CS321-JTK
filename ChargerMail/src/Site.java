import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to implement user Site 
 * @author Tevon Walker
 *
 */

public class Site {

	/**
	 * Constructs new Site object reference and creates new queue for accounts 
	 */
	public Site(){
		accountQueue = new ArrayList<Account>();
	}
	
	
	/**
	 * Adds a new account to account queue
	 * @param newAccount reference to new account object
	 */
	public void addAccount(Account newAccount){
		accountQueue.add(newAccount);
		
	}
	
	public void deleteAccount(String account){
		int index = 0;
		
		Iterator<Account> list = accountQueue.iterator();
		while (list.hasNext())
		{
			Account temp = list.next();
			if(temp.getAccountName().equals(account))
			{
				break;
			}
			index++;
		}
		
		accountQueue.remove(index);
	}

	private ArrayList<Account> accountQueue;

}
