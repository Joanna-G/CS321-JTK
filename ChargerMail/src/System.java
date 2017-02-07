import java.util.ArrayList;
/**
 * 
 * @author tevonwalker
 * A class for implementing and managing ChargerMail, a simple mail client
 */
public class System {

	/**
	 * Default constructor creates empty system
	 */
	
	public System(){
		
	}
	
	/**
	 * Checks to see if userName is already taken
	 * @param userName Username to test 
	 * @return a boolean value is returned depending on whether this username is unique or not
	 */
	
	private boolean isNewUserUnique(String userName){
		
		//TODO: implement a check to test if this username is already taken
		return true;
	}
	
	/**
	 * Attempts to create a new user within system
	 * @param userName the desired user name of the new user
	 */
	
	public void createNewUser(String userName){
		
		if(isNewUserUnique(userName)){
			userQueue.add(new User(userName));
		}
		
	}
	
	public void deleteUser(String userName){
		//TODO: Implement deletion of user
	}
	
	public void sendMessage(Message msg){
		//TODO: Implement message transmission from one user another
	}
	
	
	private ArrayList<User> userQueue = new ArrayList();

}
