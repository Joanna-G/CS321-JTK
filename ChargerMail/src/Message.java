import java.util.Date;

/**
 * Creates an email message
 * @author Joanna Pease
 *
 */

public class Message implements Comparable<Message> {
	
	public Message() {
	}
	
	/**
	 * Parameterized constructor.
	 * @param toAddress String for address the message is to.
	 * @param fromAddress String for address the message is from.
	 * @param message String ArrayList for message text.
	 */
	public Message(String toAddress, String fromAddress, 
			String message) {
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		messageText = message;
		this.timeStamp = new Date();
	}
	
	public String getTo() {
		return toAddress;
	}
	
	public void setTo(String toAddress) {
		this.toAddress = toAddress;
	}
	
	public String getFrom() {
		return fromAddress;
	}
	
	public void setFrom(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public void setMessageText(String message) {
		messageText = message;
	}
	
	public void setTimeStamp(Date time) {
		timeStamp = time;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	/**
	 * Compare two message dates.
	 * @return an integer representing comparison
	 */
	public int compareTo(Message otherMessage) {
	    return getTimeStamp().compareTo(otherMessage.getTimeStamp());
	  }
	
	
	private String toAddress;
	private String fromAddress;
	private String messageText;
	private Date timeStamp;
	
}
