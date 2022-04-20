package business;

import db.MySQLHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class Admin extends Moderator{

	public Admin(String firstname, String username, String email, String password) {
		super(firstname, username, email, password);
		// TODO Auto-generated constructor stub
	}


	public Boolean moderatorAddition(int id,String name, String usrName, String email, String pass) throws ClassNotFoundException, SQLException {
		moderators = new ArrayList<Moderator>();
		m=new MySQLHandler();
		m.moderatorDB(name, usrName, email, pass);
		moderators.add(new Moderator(name,usrName,email,pass));
		for(int i=0;i<moderators.size();i++) {
			System.out.println("Name "+moderators.get(i).getFirstname()+" Username "+moderators.get(i).getUsername()+" email"+moderators.get(i).getEmail()+" password"+moderators.get(i).getPassword());
			return true;
		}
		return false;
	}

}
