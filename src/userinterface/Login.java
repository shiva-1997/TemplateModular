package userinterface;

import java.util.Scanner;

public class Login {
	public static void main(String args[])
	{
		int choice;
		do
		{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the choice \n1.Company\n2.TeamLeader\n3.TeamMember");
		choice=in.nextInt();
	    switch(choice)
		{
		case 1:
			CompanyLogin company=new CompanyLogin();
			company.companyOperation();
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("enter the correct choice");
			break;
				
		}
	    System.out.println("enter 1 to continue");
	    choice=in.nextInt();
		}while(choice==1);
}
}
