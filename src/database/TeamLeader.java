package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeamLeader {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String URL="jdbc:mysql://localhost:3306/teammanagementsystem";

public boolean addTeamLeader(int mid, int tid, int pswd) {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(URL,"root","sathya97#");
		ps=con.prepareStatement("insert into teamleader values (?,?,?)");
		ps.setLong(1,mid);
		ps.setLong(2,tid);
		ps.setLong(3,pswd);
		ps.executeUpdate();
		ps.close();
		con.close();
		return true;
    }
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
}
		
	}


