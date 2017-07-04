package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Company {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String URL="jdbc:mysql://localhost:3306/teammanagementsystem";

	public  boolean login(int cid, int pswd)
	{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(URL,"root","sathya97#");
				ps=con.prepareStatement("select * from company where cid=? and pswd=?");
				ps.setLong(1,cid);
				ps.setLong(2,pswd);
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

}
