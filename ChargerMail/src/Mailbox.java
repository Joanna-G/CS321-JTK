import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a mailbox
 * @author Joanna Pease
 *
 */

public class Mailbox {

	/**
	 * Creates a mailbox
	 * @param Account The current Account address
	 * @param boxName Inbox, Sent, or Trash
	 */
	public Mailbox(String Account, String boxName) {
		this.boxName = boxName;
		currentAccount = Account;
	}
	
	/**
	 * Create a new message to send.
	 */
	public void newMessage() {
		String toAddress;
		String messageText;
		
		input = new Scanner(System.in);
		toAddress = input.nextLine();
		input.next();

		messageText = input.nextLine();
		input.next();
		
		Message newMessage = new Message();
		newMessage.setTo(toAddress);
		newMessage.setFrom(currentAccount);
		newMessage.setMessageText(messageText);
		
		// Some way to actually send the message.
		// Like:
		// currentAccount.send(newMessage); ??

	}
	
	/**
	 * Add a message to the queue
	 * @param message
	 */
	public void addMessage(Message message) {
		messageQueue.add(message);
	}
	
	/**
	 * Move a message to the trash
	 * @param message
	 */
	public void removeMessage(Message message) {
		/* some Account function that copies a message to Trash box.
		 * Like:
		 * if (currentAccount.getName() != Trash)
		 * currentAccount.move(message, Trash); ??
		 */
	
		messageQueue.remove(message);
	}
	
	/**
	 * Empty the trash.
	 * @return true if emptied, false if not.
	 */
	public boolean emptyTrash() {
		// Check to make sure this is the Trash
		if (boxName.equals("Trash")) {
			messageQueue.clear();
			return true;
		}
		// If this is not the Trash, error popup or nothing happens ??
		else
			return false;
	}
	
	public String getName() {
		return boxName;
	}
	
	private String boxName;
	private Scanner input;
	
	// Need some way to know what the current account is:
	// private Account currentAccount;  ??
	// For now, using a String.
	private String currentAccount;
	
}
