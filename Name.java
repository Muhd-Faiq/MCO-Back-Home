import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.InputStream;

class Name
{
	private String name;
	private String matricnum;
	private String college;

	public Name(){}

	public Name(String na,String ma)
	{
		this.name=na;
		this.matricnum=ma;
	}
	public String getName()
	{
		return name;
	}
	public String getMatricNum()
	{
		return matricnum;
	}
	public String getCollege()
	{
		return college;
	}
	public void setNameMatric()
	{
		Scanner name1=new Scanner(System.in);
		System.out.print("\t\t\t\t\tEnter students's name: ");
		name=name1.nextLine();
		Scanner matric1=new Scanner(System.in);
		System.out.print("\t\t\t\t\tEnter students's matric ID: ");
		matricnum=matric1.nextLine();
		setCollege();

	}
	public void setCollege()
	{
		boolean col=true;
		while(col)
		{
			try
			{
				Scanner college1=new Scanner(System.in);
				System.out.println("\n\n\t\t\t\t\t**************************COLLEGE**************************");
				System.out.println("\t\t\t\t\t   (1)KTDI | (2)KTR | (3)KRP    | (4)KP   | (5)KTHO");
				System.out.println("\t\t\t\t\t   (6)KTF  | (7)KTC | (8)K9&K10 | (9)KDSE | (10)KDOJ");
				System.out.print("\t\t\t\t\tStudent's college: ");
				int coll=college1.nextInt();
				if(coll>=1 && coll<=10)
				{
					sortcollege(coll);
					col=false;
				}
				else
				{
					col=true;
				}

			}
			catch(InputMismatchException ex)
			{
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong Input");
				col=true;
			}
		}
	}

	public void sortcollege(int coll)
	{
		if(coll==1)
		{
			college="KTDI";
		}
		else if(coll==2)
		{
			college="KTR";
		}
		else if(coll==3)
		{
			college="KRP";
		}
		else if(coll==4)
		{
			college="KP";
		}
		else if(coll==5)
		{
			college="KTHO";
		}
		else if(coll==6)
		{
			college="KTF";
		}
		else if(coll==7)
		{
			college="KTC";
		}
		else if(coll==8)
		{
			college="K9&K10";
		}
		else if(coll==9)
		{
			college="KDSE";
		}
		else if(coll==10)
		{
			college="KDOJ";
		}
		else
		{
			college=null;
		}
	}
}

