/*package business;

import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLHandler;

public class SportDescription {
	MySQLHandler m;
	private String cname;
	private String cdescription;
	private int cgoal;
	private int id;
	
	public SportDescription( String cname, String cdescription, int cgoal) {
		this.cname = cname;
		this.cdescription = cdescription;
		this.cgoal = cgoal;
	}
	public SportDescription() {
		// TODO Auto-generated constructor stub
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public int getCgoal() {
		return cgoal;
	}
	public void setCgoal(int cgoal) {
		this.cgoal = cgoal;
	}
	
	
	
	public SportDescription(int id, String cname, String cdescription, int cgoal) throws ClassNotFoundException, SQLException {
		super();
		this.id=id;
		this.cname = cname;
		this.cdescription = cdescription;
		this.cgoal = cgoal;
		
	}
	public void proposedCase(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.casesDB(name,description,goal);
	}
	
	public void activeCase(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.activeCasesDB(name,description,goal);
	}
	
	public ArrayList<SportDescription> getAll() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		return m.pcasesGet();
	}
	
	
	/*
	public void getAll() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.getDetails();
		
		for(int i=0;i<m.cd.size();i++) {
			System.out.println("CASES IN DB "+m.cd.get(i));
		}
	}	
		public void getaCase(String caseNo) throws ClassNotFoundException, SQLException
		{
			m=new MySQLHandler();
			m.getPartDetails(caseNo);;
			
			for(int i=0;i<m.cd.size();i++) {
				System.out.println("CASES IN DB "+m.cd.get(i));
			}
			
		}
		
		}
	*/	
		
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLHandler;

public class SportDescription {
	MySQLHandler m;

	private int sportsID;
	private String title;
	private String desc;
	private int target;

	public int getSportsID() {
		return sportsID;
	}

	public void setSportsID(int sportsID) {
		this.sportsID = sportsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public SportDescription(String cname, String cdescription, int cgoal) {
		this.title = cname;
		this.desc = cdescription;
		this.target = cgoal;
	}

	public SportDescription(int caseID, String title, String desc, int target) {
		this.sportsID = caseID;
		this.title = title;
		this.desc = desc;
		this.target = target;
	}


	public SportDescription() {
		// TODO Auto-generated constructor stub
	}

	public void proposedCase(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.casesDB(name,description,goal);
	}
	
	public void activeCase(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.activeCasesDB(name,description,goal);
	}
	
	public ArrayList<SportDescription> getAll() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		return m.pcasesGet();
	}
	

}
	
	



