
public class MessageTest {

	/**
	 * @param args command-line inputs
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create Message object reference
		Message m1 = new Message();
		
		//test message setting function
		m1.setMessage("ChargerMailClient");
		
		//test message getting function
		System.out.println(m1.getMessage());

	}

}
