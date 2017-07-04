package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Member {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String URL="jdbc:mysql://localhost:3306/teammanagementsystem";


	public boolean addMember(int mid, String mname) {
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(URL,"root","sathya97#");
				ps=con.prepareStatement("insert into member values (?,?)");
				ps.setLong(1,mid);
				ps.setString(2,mname);
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


	public void delMember(int mid) {
		try
		{
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("delete from member where mid=?");
			ps.setLong(1,mid);
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	public ArrayList<Integer> getTeams() {
		ArrayList<Integer> memberList=new ArrayList<Integer>();
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","sathya97#");
			ps=con.prepareStatement("select mid from member where mid not in (select mid from team_member)");
			rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
			memberList.add(Integer.parseInt(rs.getString(1)));
			}
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return memberList;
	}

}
