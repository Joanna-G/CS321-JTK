import java.util.ArrayList;
import java.util.Scanner;

public class Account {

	String username;
	private String server = "gmail.com";
	private ArrayList<Account> accountList = new ArrayList<Account>();
	private static final int NOTFOUND = -1;
	
	public Account(String user){
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(user).useDelimiter("@");
		username = scan.next();
	}
	
    public boolean equals(Account other){
		
		if(other == null)
			return false;
		
		Account ac = other;
		return username == ac.username; 
	}
	
	public String toString(){
		
		return username + "@" + server;
	}
	
	public void addAccount(Account ac){
		
		accountList.add(ac);
	}
	
    public boolean isInBook(Account ac){
		
		return find(ac) != NOTFOUND;
	}

	public void removeAccount(Account toRemove){
		
         int location = find(toRemove);
		
		//Check whether the location of the account to be removed is found or not
		if(location != NOTFOUND)
			accountList.remove(location);
		else
			throw new IllegalArgumentException("Account not found");
	}
	
        private int find(Account toFind){
		
		int i = 0;
		for(Account ac : accountList){
			
			if(ac.equals(toFind))
				return i;
			i++;
		}
		return NOTFOUND;
	}
}
