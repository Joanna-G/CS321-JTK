import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
	public Mailbox(String boxName) {
		this.boxName = boxName;
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
	public Message removeMessage(String message) {
		
		int index = 0;
		Iterator<Message> list = messageQueue.iterator();
		Message temp = null;
		while (list.hasNext())
		{
			temp = list.next();
			if(temp.getMessageSubject().equals(message))
			{
				break;
			}
			index++;
		}
		
		
		messageQueue.remove(index);
		
		return temp;
	}
	
	/**
	 * Return the name of the mailbox
	 * @return string with mailbox name
	 */
	public String getName() {
		return boxName;
	}
	
	
	/**
	 * Returns cloned array of messages to Mailsystem
	 * @return cloned array of messages
	 */
	public ArrayList<Message> getMessages()
	{
		ArrayList<Message> clone = (ArrayList<Message>) messageQueue.clone();
		return clone;
	}
	/**
	 * Returns current number of messages in mailbox
	 * @return integer with number of messages
	 */
	public int getSize()
	{
		return messageQueue.size();
	}
	
	private ArrayList<Message> messageQueue = new ArrayList<Message>();
	private String boxName;
	
}
