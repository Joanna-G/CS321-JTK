
public class MailboxTest {

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mailbox m = new Mailbox("inbox");
		Message m1 = new Message();
		Message m2 = new Message();
		
		m.addMessage(m1);
		
		m.checkMessage(m2);
		
		return;
	}

}
