package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Team {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String URL="jdbc:mysql://localhost:3306/teammanagementsystem";


	public boolean addTeam(int tid, String tname, int cid) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("insert into team values (?,?,?)");
			ps.setLong(1,tid);
			ps.setString(2,tname);
			ps.setLong(3,cid);
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


	public ArrayList<Integer> getTeams(int cid) {
		ArrayList<Integer> teamList=new ArrayList<Integer>();
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("select tid from team where cid=?");
			ps.setLong(1,cid);
			rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
			teamList.add(Integer.parseInt(rs.getString(1)));
			}
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return teamList;
	}
	public ResultSet getTeamsNames() {
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("select * from team where cid=111");
			rs=(ResultSet) ps.executeQuery();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return rs;
	}


	public ArrayList<Integer> getTeamsWOTeamLeader(int cid) {
		ArrayList<Integer> teamList=new ArrayList<Integer>();
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("select tid from team where cid=? AND tid not in(select tid from teamleader)");
			ps.setLong(1,cid);
			rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
			teamList.add(Integer.parseInt(rs.getString(1)));
			}
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return teamList;
	}

}
