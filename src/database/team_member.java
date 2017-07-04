package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class team_member {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String URL="jdbc:mysql://localhost:3306/teammanagementsystem";

public boolean assignTeam(int tid, int mid) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("insert into team_member values (?,?)");
			ps.setLong(1,tid);
			ps.setLong(2,mid);
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

public boolean contains(int mid) {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(URL,"root","sathya97#");
		ps=con.prepareStatement("select * from team_member where  mid=?");
		ps.setLong(1,mid);
		rs=(ResultSet) ps.executeQuery();
    }
	catch(Exception e)
	{
		System.out.println(e);
	}
			try {
				if(rs.next())
				{
					ps.close();
					con.close();
					return true;
				}
				else
				{
					ps.close();
					con.close();
					return false;
}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
}

public boolean delete(int mid) {
	try
	{
		con=DriverManager.getConnection(URL,"root","sathya97#");
		ps=con.prepareStatement("delete from team_member where mid=?");
		ps.setLong(1,mid);
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
