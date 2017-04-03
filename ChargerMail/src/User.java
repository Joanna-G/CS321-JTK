
/**
 * Class to implement a user within email client system
 * @author Tevon Walker
 *
 */

public class User {
	
	/**
	 * Constructs user object and sets username to username. Also sets up the remote and local sites
	 * @param username name to use for new user
	 */
	
	public User(String username){
		this.username = username;
		localSite = new Site();
		remoteSite = new Site();
	}
	
	/**
	 * Set user name 
	 * @param username desired new username
	 */
	
	public void setUserName(String username){
		this.username = username;
	}
	/**
	 * Retrieve value of username
	 * @return a string containing the username
	 */
	
	public String getUserName()
	{
		return username;
	}
	
	/**
	 * Set given name
	 * @param name set the user's first name to this value
	 */
	
	public void setGivenName(String name){
		givenName = name;
	}
	
	/**
	 * Retrieve value of givenName
	 * @return a string containing the first name of the user
	 */
	
	public String getGivenName(){
		return givenName;
	}
	
	/**
	 * Set surname
	 * @param name set the user's last name to this value
	 */
	
	public void setSurname(String name){
		surname = name;
	}
	
	/**
	 * Retrieve the value of surname
	 * @return a string containing the last name of the user
	 */
	
	public String getSurname(){
		return surname;
	}
	
	public void addAccount(Account newAccount){
		localSite.addAccount(newAccount);
		
	}
	
	public void deleteAccount(String account){
		localSite.deleteAccount(account);
	}
	
	
	
	private String username;
	private String givenName;
	private String surname;
	
	private Site localSite;
	private Site remoteSite;

}
