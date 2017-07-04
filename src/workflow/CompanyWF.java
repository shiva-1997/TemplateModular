package workflow;

import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

public class CompanyWF {

	public boolean login(int cid, int pswd)  {
		database.Company company=new database.Company();
		if(company.login(cid,pswd))
			return true;
		else
			return false;
	}

	public boolean addTeam(int tid, String tname, int cid) {
		database.Team team=new database.Team();
		if(team.addTeam(tid,tname,cid))
			return true;
		else
			return false;
	}

	public ArrayList<Integer> getTeams(int cid) {
		database.Team team=new database.Team();
		return team.getTeams(cid);
	}

	public boolean addMember(int mid, String mname, int tid) {
		database.Member member=new database.Member();
		boolean mem=member.addMember(mid,mname);
		boolean tmem;
		if(mem)
		{
		tmem=assignTeam(tid,mid);
		if(!tmem)
			member.delMember(mid);
		return tmem&&mem;
		}
		return false;
		}

	public boolean addTeamLeader(int tid, int mid, int pswd) {
		database.TeamLeader teamLeader=new database.TeamLeader();
		return teamLeader.addTeamLeader(mid,tid,pswd);
	}

	public boolean addMember(int mid, String mname) {
		database.Member member=new database.Member();
		return member.addMember(mid,mname);
	}
	public boolean assignTeam(int tid,int mid)
	{
		database.team_member tmember=new database.team_member();
		if(tmember.contains(mid))
		{
			if(tmember.delete(mid))
			return tmember.assignTeam(tid,mid);
		}
		else
		    return tmember.assignTeam(tid,mid);
		return false;
	}

	public ArrayList<Integer> getMembersWOTeams() {
		database.Member member=new database.Member();
		return member.getTeams();
	}

	public ArrayList<Integer> getTeamsWOTeamLeader(int cid) {
		database.Team team=new database.Team();
		return team.getTeamsWOTeamLeader(cid);
	}

	public void test() {
		database.Team team=new database.Team();
		ResultSet rs=(ResultSet) team.getTeamsNames();
	}

	
}
