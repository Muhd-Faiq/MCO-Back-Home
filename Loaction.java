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

class Location
{
	private String loc;

	public Location(){}
	public Location(String loc)
	{
		this.loc=loc;
	}
	public void setLoc()
	{
		boolean l=true;
		while(l)
		{
			try
			{
				int num;
				Scanner loc1=new Scanner(System.in);
				System.out.print("\t\t\t\t\t'Return home (1)' or 'Stay (2)' ===>");
				num=loc1.nextInt();

				if(num==1)
				{
					l=false;
					loc="Return home";
				}
				else if(num==2)
				{
					l=false;
					loc="Stay";
				}
				else
				{
					System.out.print("Wrong Input! Input must either '1' or '2'.");
				}
			}
			catch(InputMismatchException ex)
			{
				System.out.print("Wrong Input! Input must be integer.");
			}
		}

	}
	public String getLoc()
	{
		return loc;
	}
}
