/**
 * 
 * @author tevonwalker
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
			sys.createNewUser(username);
			username = in.next();
		}
		

	}

}
