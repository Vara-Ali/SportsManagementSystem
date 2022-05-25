package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import db.MySQLHandler;

public class Account {
	
	protected ArrayList<Player> donors;
	protected ArrayList<Moderator> moderators;

	protected MySQLHandler m;

	public Account() {
	
		// TODO Auto-generated constructor stub
	}
	

	public void signUp(String name, String usrName, String email, String pass) throws ClassNotFoundException, SQLException {
		donors = new ArrayList<Player>();
		m=new MySQLHandler();
		m.playerDB(name, usrName, email, pass);
		donors.add(new Player(name,usrName,email,pass));
		for(int i=0;i<donors.size();i++) {
			System.out.println("Name "+donors.get(i).getFirstname()+" Username "+donors.get(i).getUsername()+" email"+donors.get(i).getEmail()+" password"+donors.get(i).getPassword());
			
		}
		
		//party_id=0;
		
		
	}
	
	public void moderatorAddition(String name, String usrName, String email, String pass) throws ClassNotFoundException, SQLException {
		moderators = new ArrayList<Moderator>();
		m=new MySQLHandler();
		m.moderatorDB(name, usrName, email, pass);
		moderators.add(new Moderator(name,usrName,email,pass));
		for(int i=0;i<moderators.size();i++) {
			System.out.println("Name "+moderators.get(i).getFirstname()+" Username "+moderators.get(i).getUsername()+" email"+moderators.get(i).getEmail()+" password"+moderators.get(i).getPassword());
			
		}
	}
	public void getData() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		donors=m.playerGet();
		Collections.copy(donors,m.playerGet());

		for(int i=0;i<donors.size();i++) {
			System.out.println("Name "+donors.get(i).getFirstname()+" Username "+donors.get(i).getUsername()+" email"+donors.get(i).getEmail()+" password"+donors.get(i).getPassword());
			
		}
	}
	
	public Boolean signIn(String usrName, String pass) throws ClassNotFoundException, SQLException {

		m=new MySQLHandler();
		donors=m.playerGet();
		Collections.copy(donors,m.playerGet());
		for(int i=0;i<donors.size();i++)
		{	//size ka function to get arraylist ka size
				
			if((usrName.equalsIgnoreCase(donors.get(i).getFirstname()))&&(pass.equalsIgnoreCase(donors.get(i).getPassword())))
			{
				System.out.println("Good work\n");
				return true;
			}
			}
			return false;
		}
	

	public Boolean moderatorsignIn(String usrName, String pass) throws ClassNotFoundException, SQLException {
		
		m=new MySQLHandler();
		moderators=m.moderatorGet();
		Collections.copy(moderators,m.moderatorGet());
		for(int i=0;i<moderators.size();i++) {	//size ka function to get arraylist ka size
				
				if((usrName.equalsIgnoreCase(moderators.get(i).getUsername()))&&(pass.equalsIgnoreCase(moderators.get(i).getPassword()))) {
					
					//System.out.println("Element name "+mylist.get(i).name+" number "+mylist.get(i).number);
					System.out.println("Good work\n");
					return true;
					
				}
				
			}
			return false;
		}

	public ArrayList<Moderator> getAllmoderator() throws ClassNotFoundException, SQLException {

		m=new MySQLHandler();
		moderators=m.moderatorGet();
		Collections.copy(moderators,m.moderatorGet());
		for(int i=0;i<moderators.size();i++) {	//size ka function to get arraylist ka size
			 {
				System.out.println("Good work\n"+ moderators.get(i).getUsername());
			}
		}
		return moderators;
	}

	public void deletemoderator(String name) throws ClassNotFoundException, SQLException {

		m=new MySQLHandler();
		m.moderatorDelete(name);
	}




}
