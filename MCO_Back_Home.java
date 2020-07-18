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

public class MCO_Back_Home
{
	public static void main(String[] args) throws FileNotFoundException,IOException, InterruptedException
	{

		Student student=new Student();
		Student stu1=new Student();
		String locality="";
		String temptransport="";

		boolean loop=true;
		do
		{
			try
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t******** MCO BACK HOME MENU ********");
				System.out.println();
				System.out.println("\t\t\t\t\t1. Input New Student's Information\n\t\t\t\t\t2. Print Student's Report\n\t\t\t\t\t3. Display Summary Report\n\t\t\t\t\t4. Exit");
				System.out.println();
				System.out.print("\t\t\t\t\tPlease enter your choice (1-4) :");
				Scanner choice1=new Scanner(System.in);
				int choice=choice1.nextInt();
				System.out.println();
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				switch(choice)
				{
					case 1: System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tEnter the information of students's below: ");
							System.out.println();
							Location location=new Location();
							location.setLoc();
							String loc=location.getLoc();
							boolean looplocalint=true;
							while(looplocalint)
							{
								try
								{
									System.out.print("\t\t\t\t\tStudent locality {Local(1)|International(2)}:");
									Scanner loclint1=new Scanner(System.in);
									int loclint=loclint1.nextInt();
									if(loclint==1)
									{
										stu1=new Local(location);
										locality=stu1.category();
										stu1.setAdd(locality);
										looplocalint=false;
									}
									else if(loclint==2)
									{
										stu1=new International(location);
										locality=stu1.category();
										stu1.setAdd(locality);
										looplocalint=false;
									}
									else
									{
										looplocalint=true;
									}
								}
								catch(InputMismatchException ex)
								{
									System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong Input");
								}
							}
							if(loc=="Return home")
							{
								//Student stu1=new Student(location);
								if(locality=="Local")
								{
									boolean looptransport=true;
									while(looptransport)
									{
										try
										{
											System.out.print("\t\t\t\t\tTransportation from police office to home {Parent(1)|Police(2)}:");
											Scanner transp1=new Scanner(System.in);
											int transp=transp1.nextInt();
											if(transp==1)
											{
												temptransport=stu1.parenttransport();
												looptransport=false;
											}
											else if(transp==2)
											{
												temptransport=stu1.policetransport();
												looptransport=false;
											}
											else
											{
												looptransport=true;
											}

										}
										catch(InputMismatchException ex)
										{
											System.out.println("Wrong Input");
										}
									}
								}
							}
							stu1.choosefood();
							stu1.writefile(temptransport,locality);
							break;

					case 2: boolean loopcase2=true;
							int report;
							while(loopcase2)
							{
								try
								{
									new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
									System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t*******Report*******");  //suggestion: case 2 & 3 combine.The, do option to sort students between locality,state,city,typeoffood
									System.out.println("\t\t\t\t\t1) Student want to stay");							//cara sort: input semua data dlm file ke dalam arraylist. contoh: arraycollege,arrayfood,arraycity
									System.out.println("\t\t\t\t\t2) Student want to return home");
									System.out.print("\n\n\t\t\t\t\tYour choice===>");
									Scanner report1=new Scanner(System.in);
									report=report1.nextInt();
									new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
									if(report==1)
									{
										stu1.readfile("Stay");
										loopcase2=false;
									}
									else if(report==2)
									{
										stu1.readfile("Return home");
										loopcase2=false;
									}
									else
									{
										loopcase2=true;
									}
								}
								catch(InputMismatchException ex)
								{
									System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong input!");
									loopcase2=true;
								}
							}

							loop=true;
							break;
					case 3:	boolean l=true;
							String loc4="";
							new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
							while(l)
							{

								System.out.println("\n\n\n\t\t\t\t\t*********REPORT FOR*********");
								System.out.print("\t\t\t\t\t1)Return home\n\t\t\t\t\t2)Stay\n\t\t\t\t\t3)Exit to main menu\n\n\t\t\t\t\tYour choice==>");
								try
								{
									int num;
									Scanner loc1=new Scanner(System.in);
									Scanner loc2=new Scanner(System.in);
									num=loc2.nextInt();
									new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
									if(num==1)
									{
										l=true;
										loc4="Return home";
									}
									else if(num==2)
									{
										l=true;
										loc4="Stay";
									}
									else if(num==3)
									{
										l=false;
									}
									else
									{
										System.out.print("Wrong Input! Input must either '1' or '2'.");
										l=true;
									}
								}
								catch(InputMismatchException ex)
								{
									System.out.print("Wrong Input! Input must be integer.");
								}
								stu1.readfilereport(loc4);
							}
							loop=true;
							break;
					case 4: loop=false;
							break;
					default:loop=true;
				}
				System.out.println();
			}
			catch(InputMismatchException ex)
			{
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong Input");
			}
		}while(loop);




	}
}



