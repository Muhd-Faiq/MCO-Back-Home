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

class Address extends State
{
	private String street;
	private String city;
	private String zip;
	private String state;

	public Address(){}
	public Address(String street,String city,String zip,String state)
	{
		this.street=street;
		this.city=city;
		this.zip=zip;
		this.state=state;
	}
	public String getStreet()
	{
		return street;
	}
	public String getCity()
	{
		return city;
	}
	public String getZip()
	{
		return zip;
	}
	public String getState()
	{
		return state;
	}
	public void setAddress(String locality)
	{
		System.out.println("\n\t\t\t\t\tEnter students's address: ");
		Scanner street1=new Scanner(System.in);
		System.out.print("\t\t\t\t\tStreet: ");
		street=street1.nextLine();
		Scanner zip1=new Scanner(System.in);
		System.out.print("\t\t\t\t\tZip code: ");
		zip=zip1.nextLine();
		Scanner city1=new Scanner(System.in);
		System.out.print("\t\t\t\t\tCity: ");
		city=city1.nextLine();
		String format3="%-22s %-22s %-22s %-22s\n";
		if(locality=="Local")
		{
			boolean loopstate=true;
			while(loopstate)
			{
				try
				{
					Scanner state1=new Scanner(System.in);
					System.out.println("\n\n\t\t\t\t\t========================================State==========================================");
					System.out.println("\t\t\t\t\t(1)Perlis          |  (2)Kelantan         |  (3)Kedah         | (4)Pulau Pinang  ");
					System.out.println("\t\t\t\t\t(5)Terengganu      |  (6)Perak            |  (7)Selangor      | (8)Pahang");
					System.out.println("\t\t\t\t\t(9)Negeri Sembilan |  (10)Melaka          |  (11)Johor        | (12)Sarawak     ");
					System.out.println("\t\t\t\t\t(13)Sabah          |  (14)WP Kuala Lumpur |  (15)WP Putrajaya | (16)WP Labuan");
					System.out.print("\t\t\t\t\tState: ");
					int cho=state1.nextInt();
					setStateex(cho);
					state=getStateex();
					loopstate=false;
				}
				catch(InputMismatchException ex)
				{
					System.out.println("Wrong Input!");
				}
			}
		}

		else if(locality=="International")
		{
			Scanner state2=new Scanner(System.in);
			System.out.print("\t\t\t\t\tCountry: ");
			state=state2.nextLine();
		}
	}


}
