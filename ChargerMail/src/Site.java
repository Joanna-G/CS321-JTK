import java.util.ArrayList;

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
	
	public void deleteAccount(Account account){
		accountQueue.remove(account);
	}

	//TODO: implement Account Class
	private ArrayList<Account> accountQueue;

}
