/**
 * class to test MailSystem
 * @author Tevon Walker
 *	
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MailSystemTester {

	/**
	 * Test method for {@link Mailbox#newMessage()}.
	 */
	@Test
	public void testConstructor() {
		
		MailSystem ms = new MailSystem();
		assertTrue(ms != null && ms.getClass() == MailSystem.class);
	}
	
	@Test
	public void testAddNewUser(){
		User newUser = new User("test");
		MailSystem ms = new MailSystem();
		ms.addNewUser(newUser);
		ms.addNewUser(null);
		assertTrue(ms.isNewUserUnique("test") == false && ms.getNumUsers() == 1);
	}
	
	@Test
	public void testIsUserUnique(){
		
		User newUser = new User("test");
		User newUser2 = new User("test2");
		MailSystem ms = new MailSystem();
		ms.addNewUser(newUser);
		ms.addNewUser(newUser2);
		assertTrue(ms.isNewUserUnique("test") == false && ms.isNewUserUnique("test2") == false );
	}
	
	@Test
	public void testDeleteUser(){
		
		User newUser = new User("test");
		User newUser2 = new User("test2");
		MailSystem ms = new MailSystem();
		ms.addNewUser(newUser);
		ms.addNewUser(newUser2);
		ms.deleteUser("test2");
		ms.deleteUser("test");
		assertTrue(ms.isNewUserUnique("test") == true && ms.isNewUserUnique("test2") == true);
	}
	
	@Test
	public void testGetNumUsers(){

		User newUser = new User("test");
		MailSystem ms = new MailSystem();
		int initial = ms.getNumUsers();
		
		ms.addNewUser(newUser);
		
		
		assertTrue(initial == 0 && ms.getNumUsers() == 1);
	}
	
	
	
	@Test
	public void testAccountExists(){

		User newUser = new User("test");
		Account a1 = new Account("a1","test");
		Account a2 = new Account("a2","test");
		MailSystem ms = new MailSystem();
		
		ms.addNewUser(newUser);
		
		ms.addAccount("test", a1, true);
		ms.addAccount("test", a2, false);
		
		
		assertTrue(ms.accountExists("a1") && ms.accountExists("a2"));
	}
	
	
	
	@Test
	public void testAddAccount(){

		User newUser = new User("test");
		Account a1 = new Account("a1","test");
		
		MailSystem ms = new MailSystem();
		
		ms.addNewUser(newUser);
		
		ms.addAccount("test", a1, true);
		ms.addAccount("test", null, false);
		
		
		assertTrue(ms.accountExists("a1"));
	}

	@Test
	public void testDeleteAccount(){

		User newUser = new User("test");
		Account a1 = new Account("a1","test");
		Account a2 = new Account("a2","test");
		MailSystem ms = new MailSystem();
		
		ms.addNewUser(newUser);
		
		ms.addAccount("test", a1, true);
		ms.addAccount("test", a2, false);
		
		ms.deleteAccount("test", "a1",true);
		ms.deleteAccount("test", "a2",false);
		
		
		assertTrue(!ms.accountExists("a1") && !ms.accountExists("a2"));
	}
	
	@Test
	public void testGetMessages(){
		
		User newUser = new User("test");
		Account a1 = new Account("a1","test");
		
		MailSystem ms = new MailSystem();
		
		ms.addNewUser(newUser);
		
		ms.addAccount("test", a1, true);
		
		ArrayList<Message> temp = ms.getMessages("a1", 0);
		
		assertTrue(temp.size() == 0 && ms.getMessages("NonExistentUser", 0) == null);
	}
	
	@Test
	public void testTransferMessages(){
		
		User newUser = new User("test");
		Account a1 = new Account("a1","test");
		Account a2 = new Account("a2","test");
		Message m1 = new Message("a1","a1","test","test");
		MailSystem ms = new MailSystem();
		
		ms.addNewUser(newUser);
		
		ms.addAccount("test", a1, true);
		ms.addAccount("test", a2, true);
		
		
		ms.transferMessage("a1", "a1", null, 0);
		
		ArrayList<Message> temp = ms.getMessages("a1", 0);
		
		ms.transferMessage("a1", "a1", m1, 0);
		
		

		
		assertTrue(!temp.contains(m1) && ms.getMessages("a1", 0).contains(m1));
	}
	
	@Test
	public void testDeleteMessage(){
		
		User newUser = new User("test");
		Account a1 = new Account("a1","test");
		Account a2 = new Account("a2","test");
		Message m1 = new Message("a1","a1","test","test");
		Message m2 = new Message("a1","a2","test","test");
		MailSystem ms = new MailSystem();
		
		ms.addNewUser(newUser);
		
		ms.addAccount("test", a1, true);
		ms.addAccount("test", a2, true);
		
		ms.transferMessage("a1", "a1", m1, 0);
		ms.transferMessage("a2", "a2", m2, 1);
		
		ms.deleteMessage("a1", "test", 0);
		ms.deleteMessage("a2", "test", 1);

		ArrayList<Message> temp = ms.getMessages("a1", 0);
	
		
		assertTrue(!temp.contains(m1) && !ms.getMessages("a2", 1).contains(m2));
	}
	

}