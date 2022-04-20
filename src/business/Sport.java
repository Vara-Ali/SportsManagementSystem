package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import db.MySQLHandler;

public class Sport {
	private int caseID;
	private String details;
	MySQLHandler m;
	public ArrayList<SportDescription> CasesDesc; //MAI PROPOSED CASES KI DESCRIPTION KI ARRAYLIST HUN
	public ArrayList<SportDescription> ActiveCasesDesc;

	public Sport(int caseid) {
		this.caseID=caseid;
		
	}
	
	public Sport(int caseid2, String name, String description, int goal) {
		// TODO Auto-generated constructor stub
	}

	public Sport() {
		// TODO Auto-generated constructor stub
	}

	public void setDetails()
	{
		
		
	}
	public String getDetails()
	{
		
		return details;
		
	}
	

	/*public void fetchDescription(SportDescription c) throws ClassNotFoundException, SQLException
	{
		c.getAll();
	}
	*/
	public void addProposedCase(String name,String description,int goal) throws ClassNotFoundException, SQLException
	{
		CasesDesc=new ArrayList<SportDescription>();
		CasesDesc.add(new SportDescription(name,description,goal));
		SportDescription c=new SportDescription();
		c.proposedCase(name, description,goal);
	
	}
	
	public void addActiveCase(String name,String description,int goal) throws ClassNotFoundException, SQLException
	{
		ActiveCasesDesc=new ArrayList<SportDescription>();
		ActiveCasesDesc.add(new SportDescription(name,description,goal));
		SportDescription c=new SportDescription();
		c.activeCase(name, description,goal);
	
	}
	
	public void getData() throws ClassNotFoundException, SQLException
	{
		System.out.println("im in getDAta");
		ArrayList<Sport> pcases=new ArrayList<Sport>();
		m=new MySQLHandler();
		CasesDesc=new ArrayList<SportDescription>();
		SportDescription c=new SportDescription();
		c.getAll();
		CasesDesc=c.getAll();
		pcases=m.getInCases();
		//pcases=(ArrayList<Sport>)CasesDesc;
		
		for(int i=0;i<CasesDesc.size();i++) {
			System.out.println("im in loop of getDAta");

			System.out.println("Name "+CasesDesc.get(i).getTitle()+" Username "+CasesDesc.get(i).getDesc()+" email " +CasesDesc.get(i).getTarget());
			
		}
		//return pcases;
	}
	
	public void cases() throws ClassNotFoundException, SQLException
	{
		ArrayList<Sport> pcases=new ArrayList<Sport>();
		m=new MySQLHandler();
		CasesDesc=new ArrayList<SportDescription>();
		SportDescription c=new SportDescription();
		c.getAll();
		CasesDesc=c.getAll();
		pcases=m.getInCases();
		
		for(int i=0;i<CasesDesc.size();i++) {
			System.out.println("im in loop of getDAta");

			//System.out.println("Name "+pcases.get(i).getId()+" Username "+CasesDesc.get(i).getCdescription()+" email " +CasesDesc.get(i).getCgoal());
			
		}
	}
	
	public MySQLHandler sql1;
	public ArrayList<SportDescription> caseDesc;  //MAI ACTIVE CASES KI DESCRIPTION KI ARRAYLIST HUN

	public ArrayList<SportDescription> fetchDescription() throws ClassNotFoundException, SQLException
	{
		caseDesc=new ArrayList<SportDescription>();
		sql1 = new MySQLHandler();
		//caseDesc =new ArrayList<SportDescription>();
		caseDesc = sql1.getDetails();
		Collections.copy(caseDesc,sql1.getDetails());
		for (int i = 0; i < caseDesc.size(); i++) {
			System.out.println("Sport ID " + caseDesc.get(i).getSportsID() + "Title " + caseDesc.get(i).getTitle() + "Description " + caseDesc.get(i).getDesc() + "Amount " + caseDesc.get(i).getTarget());
		}
	return caseDesc;
	}
	
	public void updateTarget(String title,int updatedTarget) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.updateTarget(title,updatedTarget);
	}

	public void deleteCase(String title) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.deleteaRow(title);
	}

}
