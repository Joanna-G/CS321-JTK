import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Joanna Pease
 *
 */
public class MailboxTest {

	/**
	 * Test method for {@link Mailbox#newMessage()}.
	 */
	@Test
	public void testNewMessage() {
		
		Mailbox newBox = new Mailbox("Inbox");
		assertTrue(newBox.newMessage() != null);

	}

	/**
	 * Test method for {@link Mailbox#addMessage(Message)}.
	 */
	@Test
	public void testAddMessage() {
		Message newMessage = new Message("toAddress", "fromAddress", "message", "subject");
		Mailbox newBox = new Mailbox("in");
		newBox.addMessage(newMessage);
		assertTrue(newBox.getMessage("subject") != null);

	}

	/**
	 * Test method for {@link Mailbox#removeMessage(java.lang.String)}.
	 */
	@Test
	public void testRemoveMessage() {
		Message newMessage = new Message("toAddress", "fromAddress", "message", "subject");
		Mailbox newBox = new Mailbox("in");
		newBox.addMessage(newMessage);
		assertTrue(newBox.removeMessage("subject") != null);	}

	/**
	 * Test method for {@link Mailbox#eraseAll()}.
	 */
	@Test
	public void testEraseAll() {
		Message newMessage = new Message("toAddress", "fromAddress", "message", "subject");
		Message newMessage2 = new Message("toAddress", "fromAddress", "message", "subject");
		Message newMessage3 = new Message("toAddress", "fromAddress", "message", "subject");
		Mailbox newBox = new Mailbox("Trash");
		newBox.addMessage(newMessage);	
		newBox.addMessage(newMessage2);
		newBox.addMessage(newMessage3);
		assertTrue(newBox.eraseAll());
	}

	/**
	 * Test method for {@link Mailbox#sortMessages()}.
	 */
	@Test
	public void testSortMessages() {
		Message newMessage = new Message("toAddress", "fromAddress", "message", "subject");
		Message newMessage2 = new Message("toAddress", "fromAddress", "message", "subject2");
		Message newMessage3 = new Message("toAddress", "fromAddress", "message", "subject3");
		Mailbox newBox = new Mailbox("in");
		newBox.addMessage(newMessage);	
		newBox.addMessage(newMessage2);
		newBox.addMessage(newMessage3);
		newBox.sortMessages();
		assertTrue(newBox.getMessage("subject").getTimeStamp().compareTo(newBox.getMessage("subject2").getTimeStamp()) == 0);
		
	}

}
