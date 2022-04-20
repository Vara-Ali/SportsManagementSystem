package business;

import java.sql.SQLException;
import java.util.ArrayList;

public class SportsClub {
	public ArrayList<Account> accounts=new ArrayList<Account>();
	public ArrayList<Player> donors=new ArrayList<Player>();
	public ArrayList<Sport> pcases;
	public ArrayList<Sport> ActiveCases;

	
	public void proposedCases(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		pcases=new ArrayList<Sport>();
		pcases.add(new Sport());
		Sport pcase=new Sport();
		pcase.addProposedCase(name, description, goal);
		
		
	}
	public void getData() throws ClassNotFoundException, SQLException
	{
		pcases=new ArrayList<Sport>();

		//Print array list
				for(int i=0;i<pcases.size();i++) {
					System.out.println("Element name "+pcases.get(i).CasesDesc.get(i));
					
					
				}
		
	}
	
	public void addCases(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		ActiveCases=new ArrayList<Sport>();
		ActiveCases.add(new Sport());
		Sport ActiveCases=new Sport();
		ActiveCases.addActiveCase(name, description, goal);
		
		
	}

	
}
