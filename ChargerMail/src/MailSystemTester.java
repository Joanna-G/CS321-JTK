/**
 * class to test MailSystem
 * @author Tevon Walker
 *	
 */


import java.util.Scanner;

public class MailSystemTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MailSystem sys = new MailSystem();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Hello, enter a new userName");
		
		String username;
		
		username = in.next();
		
		while(!username.equals("quit"))
		{
			if (sys.isNewUserUnique(username)){
				User newUser = new User(username);
				sys.addNewUser(newUser);
			}
			username = in.next();
		}
		

	}

}
