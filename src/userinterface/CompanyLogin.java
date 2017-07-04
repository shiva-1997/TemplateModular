package userinterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class CompanyLogin {
	public void companyOperation()
	{
		int cid,pswd,choice;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("Enter company id and password");
		cid=in.nextInt();
		pswd=in.nextInt();
		workflow.CompanyWF company=new workflow.CompanyWF();
		if(company.login(cid,pswd))
		{
		do
		{

		System.out.println("Enter the choice\n1.View Teams\n2.Add Team\n3.Add Member\n4.Assign TeamLeader\n5.Add Member without team\n6.Members without Team\n7.Teams without TeamLeader\n8.Assing Team");
		choice=in.nextInt();
		switch(choice)
		{
		case 1:
			ArrayList<Integer> teamList=company.getTeams(cid);
			Iterator<Integer> iterator = teamList.iterator();
			while(iterator.hasNext()){
		System.out.println("Team:"+iterator.next());
			}
			break;
		case 2:
			System.out.println("Enter the Team ID");
			int tid=in.nextInt();
			in.nextLine();
			String tname=in.nextLine();
			if(company.addTeam(tid,tname,cid))
				System.out.println("Team:"+tid+" added successfully");
			else
				System.out.println("Team cannot be added to the company:"+cid);
			break;
		case 3:
			System.out.println("Enter the Member ID,Name,Team ID");
			int mid=in.nextInt();
			in.nextLine();
			String mname=in.nextLine();
			tid=in.nextInt();
			if(company.addMember(mid, mname, tid))
				System.out.println("Member:"+mid+" added successfully");
			else
				System.out.println("Member:"+mid+" cannot be added to the team:"+tid);
			break;
		case 4:
			System.out.println("Enter the Team ID,Member ID,Password");
			tid=in.nextInt();
		    mid=in.nextInt();
			pswd=in.nextInt();
			in.nextLine();
			if(company.addTeamLeader(tid, mid, pswd))
				System.out.println("TeamLeader:"+mid+" added successfully to the team:"+tid);
			else
				System.out.println("TeamLeader:"+mid+" cannot be added to the team:"+tid);
				break;
		case 5:
			System.out.println("Enter the Member ID,Name");
			mid=in.nextInt();
			in.nextLine();
			mname=in.nextLine();
			if(company.addMember(mid, mname))
				System.out.println("Member:"+mid+" added successfully");
			else
				System.out.println("Member:"+mid+" cannot be added");
			break;
		case 6:
			ArrayList<Integer> MemberList=company.getMembersWOTeams();
			iterator = MemberList.iterator();
			while(iterator.hasNext()){
		System.out.println("Member:"+iterator.next());
			}
			break;
		case 7:
			teamList=company.getTeamsWOTeamLeader(cid);
			iterator = teamList.iterator();
			while(iterator.hasNext()){
		System.out.println("Team:"+iterator.next());
			}
			break;
		case 8:
			System.out.println("Enter the Team ID,Member ID");
			tid=in.nextInt();
		    mid=in.nextInt();
			if(company.assignTeam(tid, mid))
				System.out.println("TeamAssigned for member:"+mid+" added successfully to the team:"+tid);
			else
				System.out.println("Member:"+mid+" cannot be assigned to the team:"+tid);
				break;
		case 9:
			company.test();
			break;
		default:
			System.out.println("Enter the correct choice");
			break;
		}
		System.out.println("Enter 6 to continue");
		choice=in.nextInt();
		}while(choice==6);	
	}
		else
			System.out.println("Invalid login");
			
}
}
