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

class Student extends Transportation  implements Food
{
	private Address address=new Address();
	private Name name=new Name();
	private Name nameread=new Name();
	private Name name1=new Name();
	private Location loc=new Location();
	private String typeoffood;
	private ArrayList<String> arraycity=new ArrayList<String>();
	private ArrayList<String> arrayname=new ArrayList<String>();
	private ArrayList<String> arraymatricnum=new ArrayList<String>();
	private ArrayList<String> arraycollege=new ArrayList<String>();
	private ArrayList<String> arraystreet=new ArrayList<String>();
	private ArrayList<String> arrayzip=new ArrayList<String>();
	private ArrayList<String> arraystate=new ArrayList<String>();
	private ArrayList<String> arrayfood=new ArrayList<String>();
	private ArrayList<String> arraytransport=new ArrayList<String>();
	private Vector<Integer> statearray=new Vector<Integer>();
	private Vector<Integer> collegearray=new Vector<Integer>();
	private Vector<Integer> cityarray=new Vector<Integer>();
	private Vector<Integer> foodarray=new Vector<Integer>();

	public Student(){}
	public Student(Location l)
	{
		loc=l;
		name.setNameMatric();
	}
	public void setAdd(String locality)
	{
		if(loc.getLoc()=="Return home")
		{
			address.setAddress(locality);
		}
	}
	public String getNameSt()
	{
		return name.getName();
	}
	public String getMatricNum()
	{
		return name.getMatricNum();
	}
	public String getCollege()
	{
		return name.getCollege();
	}
	public String getStreet()
	{
		return address.getStreet();
	}
	public String getCity()
	{
		return address.getCity();
	}
	public String getZip()
	{
		return address.getZip();
	}
	public String getState()
	{
		return address.getState();
	}
	public Location getObjLocation()
	{
		return loc;
	}
	public String category()
	{
		return "category";
	}
	public String vege()
	{
		return vegetarian;
	}
	public String nonvege()
	{
		return nonvegetarian;
	}
	public String parenttransport()
	{
		return "Parent's Car";
	}
	public String policetransport()
	{
		return "Police's Car";
	}
	public void choosefood()
	{

		boolean loopfood=true;
		while(loopfood)
		{
			try
			{
				System.out.print("\t\t\t\t\tFood Allergies {Vegetarian(1)|Non-vegetarian(2)}: ");
				Scanner food1=new Scanner(System.in);
				int food=food1.nextInt();
				clear();
				if(food==1)
				{
					typeoffood=vege();
					loopfood=false;
				}
				else if(food==2)
				{
					typeoffood=nonvege();
					loopfood=false;
				}
				else
				{
					loopfood=true;
				}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Wrong Input");
			}
		}
	}


	public void writefile(String temptransp,String locality)
	{
		if(loc.getLoc()=="Return home")
		{
			if(locality=="Local")
			{
				//String tempstate=getState()+".txt";
				try
				{
					BufferedWriter outStream= new BufferedWriter(new FileWriter("Return home.txt",true));
					outStream.write(getCity()+"\n");
					outStream.write(getNameSt()+"\n");
					outStream.write(getMatricNum()+"\n");
					outStream.write(getCollege()+"\n");
					outStream.write(getStreet()+"\n");
					outStream.write(getZip()+"\n");
					outStream.write(getState()+"\n");
					outStream.write(typeoffood+"\n");
					outStream.write(temptransp+"\n");
					 //kena letak police car dan parents car semua benda dekat sini
					outStream.flush();


				}
				catch(IOException ex)
				{
					System.out.print("File Error!");
				}
			}
			else if(locality=="International")
			{
				String tempstate="KLIA.txt";
				try
				{
					BufferedWriter outStream= new BufferedWriter(new FileWriter(tempstate,true));
					outStream.write(getCity()+"\n");
					outStream.write(getNameSt()+"\n");
					outStream.write(getMatricNum()+"\n");
					outStream.write(getCollege()+"\n");
					outStream.write(getStreet()+"\n");
					outStream.write(getZip()+"\n");
					outStream.write(getState()+"\n");
					outStream.write(typeoffood+"\n");
					outStream.flush();


				}
				catch(IOException ex)
				{
					System.out.print("File Error!");
				}
			}
		}
		else
		{
			try
			{
				BufferedWriter outStream= new BufferedWriter(new FileWriter("StayUTM.txt",true));
				outStream.write(getNameSt()+"\n");
				outStream.write(getMatricNum()+"\n");
				outStream.write(getCollege()+"\n");
				outStream.write(typeoffood+"\n");
				outStream.flush();
			}
			catch(IOException ex)
			{
				System.out.print("File Error!");
			}

		}



	}
	public void readfilereport(String loc4)
	{
		String tempcity="";
		//Start of Return home
		if(loc4.equals("Return home"))
		{
			//start of reading file of Return home.txt
			try
			{
				BufferedReader inStream=new BufferedReader(new FileReader("Return home.txt"));

				while((tempcity=inStream.readLine())!=null)
				{
					arraycity.add(tempcity);
					arrayname.add(inStream.readLine());
					arraymatricnum.add(inStream.readLine());
					arraycollege.add(inStream.readLine());
					arraystreet.add(inStream.readLine());
					arrayzip.add(inStream.readLine());
					arraystate.add(inStream.readLine());
					arrayfood.add(inStream.readLine());
					arraytransport.add(inStream.readLine());
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found!");
			}
			catch(IOException ex)
			{
				System.out.println("File not found!");
			}

		//end of read file Return home.txt


		//start of reading file KLIA.txt

			try
			{
				BufferedReader inStream2=new BufferedReader(new FileReader("KLIA.txt"));

				while((tempcity=inStream2.readLine())!=null)
				{
					arraycity.add(tempcity);
					arrayname.add(inStream2.readLine());
					arraymatricnum.add(inStream2.readLine());
					arraycollege.add(inStream2.readLine());
					arraystreet.add(inStream2.readLine());
					arrayzip.add(inStream2.readLine());
					arraystate.add(inStream2.readLine());
					arrayfood.add(inStream2.readLine());
					arraytransport.add(null);
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found!");
			}
			catch(IOException ex)
			{
				System.out.println("File not found!");
			}

		//end of reading file KLIA.txt

			String format2="%-15s %-2s %-3s\n";
			System.out.println("\n\n\n\n\t\t\t\t\t==============================================");
			System.out.println("\t\t\t\t\t                Return Home                   ");
			System.out.println("\t\t\t\t\t==============================================");
			State stateco=new State();
			int statecount,arrstasize;
			for(statecount=1;statecount<=16;statecount++)
			{
				stateco.setStateex(statecount);
				String state4=stateco.getStateex();
				arrstasize=0;
				int nums=0;
				for(arrstasize=0;arrstasize<arraystate.size();arrstasize++)
				{
					if(state4.equals(arraystate.get(arrstasize)))
					{
						nums++;
					}
				}
				System.out.print("\t\t\t\t\t");
				System.out.printf(format2,state4,"= ",nums);
			}
			int loopnum,numint=0;
			for(loopnum=0;loopnum<arraystate.size();loopnum++)
			{
				if(arraytransport.get(loopnum)==null)
				{
					numint++;
				}
			}
			System.out.print("\t\t\t\t\t");
			System.out.printf(format2,"International","= ",numint);
			System.out.println();
			System.out.println("\t\t\t\t\t----------------------------------------------");
			System.out.print("\t\t\t\t\t");
			System.out.printf(format2,"Total","= ",arrayname.size());
			System.out.println("\t\t\t\t\t==============================================");
			arraycity.clear();
			arrayname.clear();
			arraymatricnum.clear();
			arraycollege.clear();
			arraystreet.clear();
			arrayzip.clear();
			arraystate.clear();
			arrayfood.clear();
			arraytransport.clear();
		}
		//end of Return home

		//start of stay UTM
		if(loc4.equals("Stay"))
		{
			//start of reading file StayUTM.txt
			try
			{
				BufferedReader inStream3=new BufferedReader(new FileReader("StayUTM.txt"));

				while((tempcity=inStream3.readLine())!=null)
				{
					arraycity.add(null);
					arrayname.add(tempcity);
					arraymatricnum.add(inStream3.readLine());
					arraycollege.add(inStream3.readLine());
					arraystreet.add(null);
					arrayzip.add(null);
					arraystate.add(null);
					arrayfood.add(inStream3.readLine());
					arraytransport.add(null);
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found!");
			}
			catch(IOException ex)
			{
				System.out.println("File not found!");
			}

		//end of reading file StayUTM.txt
			String format2="%-15s %-2s %-3s\n";
			int collegecount,arrstasize;
			System.out.println("\n\n\n\n\t\t\t\t\t==============================================");
			System.out.println("\t\t\t\t\t                Stay in UTM                   ");
			System.out.println("\t\t\t\t\t==============================================");
			for(collegecount=1;collegecount<=10;collegecount++)
			{
				name1.sortcollege(collegecount);
				String college4=name1.getCollege();
				arrstasize=0;
				int nums=0;
				for(arrstasize=0;arrstasize<arraycollege.size();arrstasize++)
				{
					if(college4.equals(arraycollege.get(arrstasize)))
					{
						nums++;
					}
				}
				System.out.print("\t\t\t\t\t");
				System.out.printf(format2,college4,"= ",nums);
			}
			System.out.println();
			System.out.println("\t\t\t\t\t----------------------------------------------");
			System.out.print("\t\t\t\t\t");
			System.out.printf(format2,"Total","= ",arrayname.size());
			System.out.println("\t\t\t\t\t==============================================");

			arraycity.clear();
			arrayname.clear();
			arraymatricnum.clear();
			arraycollege.clear();
			arraystreet.clear();
			arrayzip.clear();
			arraystate.clear();
			arrayfood.clear();
			arraytransport.clear();
		}
		//end of Stay UTM

	}


	public void readfile(String rep)
	{

		String tempcity;
		String negeri="";
		State sta=new State();



		String tempstate1;
		if(rep=="Return home")
		{
			//start choosingg locality
			String locality="";
			boolean looplocalint=true;
			while(looplocalint)
			{
				try
				{
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tStudent locality {Local(1)|International(2)}:");
					Scanner loclint1=new Scanner(System.in);
					int loclint=loclint1.nextInt();
					if(loclint==1)
					{
						locality="Local";
						looplocalint=false;
					}
					else if(loclint==2)
					{
						locality="International";
						looplocalint=false;
					}
					else
					{
						looplocalint=true;
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("Wrong Input");
				}
			}

			//end choosing locality
			//start locality=Local
			if(locality.equals("Local"))
			{
			try
			{
				BufferedReader inStream=new BufferedReader(new FileReader("Return home.txt"));

				while((tempcity=inStream.readLine())!=null)
				{
					arraycity.add(tempcity);
					arrayname.add(inStream.readLine());
					arraymatricnum.add(inStream.readLine());
					arraycollege.add(inStream.readLine());
					arraystreet.add(inStream.readLine());
					arrayzip.add(inStream.readLine());
					arraystate.add(inStream.readLine());
					arrayfood.add(inStream.readLine());
					arraytransport.add(inStream.readLine());
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found!");
			}
			catch(IOException ex)
			{
				System.out.println("File not found!");
			}
			boolean loopstate=true;
			while(loopstate)
			{
				try
				{
					clear();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t========================================State==========================================");
					System.out.println("\t\t\t\t\t(1)Perlis          |  (2)Kelantan         |  (3)Kedah         | (4)Pulau Pinang  ");
					System.out.println("\t\t\t\t\t(5)Terengganu      |  (6)Perak            |  (7)Selangor      | (8)Pahang");
					System.out.println("\t\t\t\t\t(9)Negeri Sembilan |  (10)Melaka          |  (11)Johor        | (12)Sarawak     ");
					System.out.println("\t\t\t\t\t(13)Sabah          |  (14)WP Kuala Lumpur |  (15)WP Putrajaya | (16)WP Labuan");
					System.out.print("\t\t\t\t\tState: ");
					Scanner state2=new Scanner(System.in);
					int cho2=state2.nextInt();
					sta.setStateex(cho2);
					negeri=sta.getStateex();
					loopstate=false;
				}
				catch(InputMismatchException ex)
				{
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong Input!");
				}

				//tempstate1=negeri+".txt";
			}
			//read file starts here

			//read file ends here
			int choicesort;
			boolean loopsort=true;
			while(loopsort)
			{
				try
				{
					System.out.println("\n\n\n\t\t\t\t\t******SORT BASED ON******");
					System.out.println("\t\t\t\t\t1)College");
					System.out.println("\t\t\t\t\t2)City");
					System.out.println("\t\t\t\t\t3)Food Allergies");
					System.out.println("\t\t\t\t\t4)Exit Sort Menu");
					System.out.print("\n\n\t\t\t\t\tYour choice==>");
					Scanner choicesort1=new Scanner(System.in);
					choicesort=choicesort1.nextInt();
					int numarraystate=arraystate.lastIndexOf(negeri);
					clear();
					if(choicesort==1)
					{
						System.out.print("\n\n\n\n\n\n\n\n\n");
						nameread.setCollege();
						String colle=nameread.getCollege();
						boolean loopsortstate=true;
						int numsortstate=0;
						while(loopsortstate)
						{
							if(numsortstate<arraystate.size() && negeri.equals(arraystate.get(numsortstate)))
							{
								statearray.addElement(numsortstate);
								numsortstate++;
								loopsortstate=true;
							}
							else
							{
								numsortstate++;
							}
							if(numsortstate>=arraystate.size())
							{
								loopsortstate=false;
							}

						}
						boolean loopsortcollege=true;
						int numsortcollege=0;
						int numarraycollege=arraycollege.lastIndexOf(colle);

						while(loopsortcollege)
						{
							if(numsortcollege>=arraycollege.size())
							{
								loopsortcollege=false;
							}
							else if(numsortcollege<statearray.size())
							{
								if(colle.equals(arraycollege.get(statearray.get(numsortcollege))))
								{
									collegearray.addElement(statearray.get(numsortcollege));
								}
								numsortcollege++;
								loopsortcollege=true;
							}
							else
							{
								numsortcollege++;
							}

						}
						print(rep,1,"Local");
						loopsort=true;
					}
					else if(choicesort==2)
					{
						System.out.print("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tEnter city: ");
						Scanner inputcity1=new Scanner(System.in);
						String inputcity=inputcity1.nextLine();


						boolean loopsortstate=true;
						int numsortstate=0;
						while(loopsortstate)
						{
							if(numsortstate<arraystate.size() && negeri.equals(arraystate.get(numsortstate)))
							{
								statearray.addElement(numsortstate);
								numsortstate++;
								loopsortstate=true;
							}
							else
							{
								numsortstate++;
							}
							if(numsortstate>=arraystate.size())
							{
								loopsortstate=false;
							}

						}

						//start sort city


						boolean loopsortcity=true;
						int numsortcity=0;

						while(loopsortcity)
						{
							if(numsortcity>=arraycity.size())
							{
								loopsortcity=false;
							}
							else if(numsortcity<statearray.size())
							{
								if(inputcity.equals(arraycity.get(statearray.get(numsortcity))))
								{
									cityarray.addElement(statearray.get(numsortcity));
								}
								numsortcity++;
								loopsortcity=true;
							}
							else
							{
								numsortcity++;
							}

						}

						//end sort city
						print(rep,2,"Local");
						loopsort=true;
					}
					else if(choicesort==3)
					{
						String foodtype="";
						boolean loopchoosefood=true;
						while(loopchoosefood)
						{
							try
							{
								System.out.print("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tVegetarian(1) OR Non-vegetarian(2):");
								Scanner choosefood1=new Scanner(System.in);
								int choosefood=choosefood1.nextInt();
								if(choosefood==1)
								{
									foodtype=vege();
									loopchoosefood=false;
								}
								else if(choosefood==2)
								{
									foodtype=nonvege();
									loopchoosefood=false;
								}
								else
								{
									loopchoosefood=true;
								}
							}
							catch(InputMismatchException ex)
							{
								System.out.println("Wrong Input");
							}
						}

						boolean loopsortstate=true;
						int numsortstate=0;
						while(loopsortstate)
						{
							if(numsortstate<arraystate.size() && negeri.equals(arraystate.get(numsortstate)))
							{
								statearray.addElement(numsortstate);
								numsortstate++;
								loopsortstate=true;
							}
							else
							{
								numsortstate++;
							}
							if(numsortstate>=arraystate.size())
							{
								loopsortstate=false;
							}

						}

						//start sort typeoffood


						boolean loopsortfood=true;
						int numsortfood=0;

						while(loopsortfood)
						{
							if(numsortfood>=arrayfood.size())
							{
								loopsortfood=false;
							}
							else if(numsortfood<statearray.size())
							{
								if(foodtype.equals(arrayfood.get(statearray.get(numsortfood))))
								{
									foodarray.addElement(statearray.get(numsortfood));
								}
								numsortfood++;
								loopsortfood=true;
							}
							else
							{
								numsortfood++;
							}

						}

						//end sort typeoffood
						print(rep,3,"Local");

						loopsort=true;
					}
					else if(choicesort==4)
					{
						loopsort=false;
					}
					else
					{
						loopsort=true;
					}
				}
				catch(InputMismatchException ex)
				{
					clear();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong input!");
				}
			}
		}
		//end of if locality=Local

		//start of locality=International
		else if(locality.equals("International"))
		{
			try
			{
				BufferedReader inStream=new BufferedReader(new FileReader("KLIA.txt"));

				while((tempcity=inStream.readLine())!=null)
				{
					arraycity.add(tempcity);
					arrayname.add(inStream.readLine());
					arraymatricnum.add(inStream.readLine());
					arraycollege.add(inStream.readLine());
					arraystreet.add(inStream.readLine());
					arrayzip.add(inStream.readLine());
					arraystate.add(inStream.readLine());
					arrayfood.add(inStream.readLine());
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found!");
			}
			catch(IOException ex)
			{
				System.out.println("File not found!");
			}

			int choicesort;
			boolean loopsort=true;
			while(loopsort)
			{
				try
				{
					System.out.println("\n\n\n\t\t\t\t\t******SORT BASED ON******");
					System.out.println("\t\t\t\t\t1)College");
					System.out.println("\t\t\t\t\t2)Food Allergies");
					System.out.println("\t\t\t\t\t3)Exit Sort Menu");
					System.out.print("\n\n\t\t\t\t\tYour choice==>");
					Scanner choicesort1=new Scanner(System.in);
					choicesort=choicesort1.nextInt();
					int numarraystate=arraystate.lastIndexOf(negeri);
					clear();
					if(choicesort==1)
					{
						System.out.print("\n\n\n\n\n\n\n\n\n");
						nameread.setCollege();
						String colle=nameread.getCollege();
						boolean loopsortcollege=true;
						int numsortcollege=0;
						while(loopsortcollege)
						{
							if(numsortcollege<arraycollege.size() && colle.equals(arraycollege.get(numsortcollege)))
							{
								collegearray.addElement(numsortcollege);
								numsortcollege++;
								loopsortcollege=true;
							}
							else
							{
								numsortcollege++;
							}
							if(numsortcollege>=arraycollege.size())
							{
								loopsortcollege=false;
							}

						}


						print(rep,4,"International");
						loopsort=true;
					}
					else if(choicesort==2)
					{
						String foodtype="";
						boolean loopchoosefood=true;
						while(loopchoosefood)
						{
							try
							{
								System.out.print("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tVegetarian(1) OR Non-vegetarian(2):");
								Scanner choosefood1=new Scanner(System.in);
								int choosefood=choosefood1.nextInt();
								if(choosefood==1)
								{
									foodtype=vege();
									loopchoosefood=false;
								}
								else if(choosefood==2)
								{
									foodtype=nonvege();
									loopchoosefood=false;
								}
								else
								{
									loopchoosefood=true;
								}
							}
							catch(InputMismatchException ex)
							{
								System.out.println("Wrong Input");
							}
						}

						boolean loopsortfood=true;
						int numsortfood=0;
						//start sort typeoffood
						while(loopsortfood)
						{
							if(numsortfood<arrayfood.size() && foodtype.equals(arrayfood.get(numsortfood)))
							{
								foodarray.addElement(numsortfood);
								numsortfood++;
								loopsortfood=true;
							}
							else
							{
								numsortfood++;
							}
							if(numsortfood>=arrayfood.size())
							{
								loopsortfood=false;
							}

						}
						//end sort typeoffood
						print(rep,5,"International");

						loopsort=true;
					}
					else if(choicesort==3)
					{
						loopsort=false;
					}
					else
					{
						loopsort=true;
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("Wrong input!");
				}
			}

		}
		//end of locality=International


		}//end of if return home


		else if(rep=="Stay")
		{
			String tempname="";
			try
			{
				BufferedReader inStream=new BufferedReader(new FileReader("StayUTM.txt"));
				while((tempname=inStream.readLine())!=null)
				{
					arrayname.add(tempname);
					arraymatricnum.add(inStream.readLine());
					arraycollege.add(inStream.readLine());
					arrayfood.add(inStream.readLine());
				}
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File not found!");
			}
			catch(IOException ex)
			{
				System.out.println("File not found!");
			}

			int choicesort;
			boolean loopsort=true;
			while(loopsort)
			{
				try
				{
					System.out.println("\n\n\n\t\t\t\t\t******SORT BASED ON******");
					System.out.println("\t\t\t\t\t1)College");
					System.out.println("\t\t\t\t\t2)Food Allergies");
					System.out.println("\t\t\t\t\t3)Exit Sort Menu");
					System.out.print("\n\n\t\t\t\t\tYour choice==>");
					Scanner choicesort1=new Scanner(System.in);
					choicesort=choicesort1.nextInt();
					int numarraystate=arraystate.lastIndexOf(negeri);
					clear();
					if(choicesort==1)
					{
						System.out.print("\n\n\n\n\n\n\n\n\n");
						nameread.setCollege();
						String colle=nameread.getCollege();
						boolean loopsortcollege=true;
						int numsortcollege=0;
						while(loopsortcollege)
						{
							if(numsortcollege<arraycollege.size() && colle.equals(arraycollege.get(numsortcollege)))
							{
								collegearray.addElement(numsortcollege);
								numsortcollege++;
								loopsortcollege=true;
							}
							else
							{
								numsortcollege++;
							}
							if(numsortcollege>=arraycollege.size())
							{
								loopsortcollege=false;
							}

						}


						print(rep,1,null);
						loopsort=true;
					}
					else if(choicesort==2)
					{
						String foodtype="";
						boolean loopchoosefood=true;
						while(loopchoosefood)
						{
							try
							{
								System.out.print("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tVegetarian(1) OR Non-vegetarian(2):");
								Scanner choosefood1=new Scanner(System.in);
								int choosefood=choosefood1.nextInt();
								if(choosefood==1)
								{
									foodtype=vege();
									loopchoosefood=false;
								}
								else if(choosefood==2)
								{
									foodtype=nonvege();
									loopchoosefood=false;
								}
								else
								{
									loopchoosefood=true;
								}
							}
							catch(InputMismatchException ex)
							{
								System.out.println("Wrong Input");
							}
						}
						boolean loopsortfood=true;
						int numsortfood=0;

						//start sort typeoffood
						boolean loopsortstate=true;
						int numsortstate=0;
						while(loopsortfood)
						{
							if(numsortfood<arrayfood.size() && foodtype.equals(arrayfood.get(numsortfood)))
							{
								foodarray.addElement(numsortfood);
								numsortfood++;
								loopsortfood=true;
							}
							else
							{
								numsortfood++;
							}
							if(numsortfood>=arrayfood.size())
							{
								loopsortfood=false;
							}
						}
						//end sort typeoffood
						print(rep,2,null);
						loopsort=true;
					}
					else if(choicesort==3)
					{
						loopsort=false;
					}
					else
					{
						loopsort=true;
					}
				}
				catch(InputMismatchException ex)
				{
					clear();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\tWrong Input");
				}

			}

		}
		arraycity.clear();
		arrayname.clear();
		arraymatricnum.clear();
		arraycollege.clear();
		arraystreet.clear();
		arrayzip.clear();
		arraystate.clear();
		arrayfood.clear();
		arraytransport.clear();
	}//throws FileNotFoundException,IOException, InterruptedException
	public void clear()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{
		}
		catch(InterruptedException ex)
		{
		}
	}

	public void print(String rep,int sort,String locality)
	{
		clear();
		boolean lop=true;
		boolean firstloop=true;
		boolean record=true;
		if(rep=="Return home")
		{
			String format="%-5s %-36s %-12s %-10s %-21s %-11s %-17s %-17s %-17s %-19s\n";
			String format1="%-5s %-36s %-12s %-21s %-11s %-17s %-17s %-19s\n";
			String format2="%-5s %-36s %-12s %-10s %-21s %-11s %-17s %-19s\n";
			String format3="%-5s %-36s %-12s %-10s %-21s %-11s %-17s %-19s\n";
			String format4="%-5s %-36s %-12s %-17s %-17s\n";
			String format5="%-5s %-36s %-12s %-10s %-17s\n";
			int num=0;

			if(sort==1)
			{
				System.out.println("=================================================================================================================================================");
				System.out.printf(format1,"Num |","                Name               |"," Matric ID |","       Street       |"," Zip Code |","      City      |","   Allergies    |","  Transportation  |");
				System.out.println("=================================================================================================================================================");

				if(collegearray.size()>0)
				{
				for(num=0;num<collegearray.size();num++)
				{
					System.out.printf(format1,(num+1),arrayname.get(collegearray.get(num)),arraymatricnum.get(collegearray.get(num))/*,arraycollege.get(collegearray.get(num))*/,arraystreet.get(collegearray.get(num)),arrayzip.get(collegearray.get(num)),arraycity.get(collegearray.get(num))/*,arraystate.get(collegearray.get(num))*/,arrayfood.get(collegearray.get(num)),arraytransport.get(collegearray.get(num)));
				}
				}
				else
				{
					System.out.println("No record");
					record=false;
				}

				System.out.println("=================================================================================================================================================");
			}
			else if(sort==2)
			{
				System.out.println("==========================================================================================================================================");
				System.out.printf(format2,"Num |","                Name               |"," Matric ID |"," College |","       Street       |"," Zip Code |","   Allergies    |","  Transportation  |");
				System.out.println("==========================================================================================================================================");

				if(collegearray.size()>0)
				{
				for(num=0;num<cityarray.size();num++)
				{
					System.out.printf(format2,(num+1),arrayname.get(cityarray.get(num)),arraymatricnum.get(cityarray.get(num)),arraycollege.get(cityarray.get(num)),arraystreet.get(cityarray.get(num)),arrayzip.get(cityarray.get(num)),/*arraycity.get(cityarray.get(num)),arraystate.get(cityarray.get(num)),*/arrayfood.get(cityarray.get(num)),arraytransport.get(cityarray.get(num)));
				}
				}
				else
				{
					System.out.println("No record");
					record=false;
				}
				System.out.println("==========================================================================================================================================");
			}
			else if(sort==3)
			{
				System.out.println("==========================================================================================================================================");
				System.out.printf(format3,"Num |","                Name               |"," Matric ID |"," College |","       Street       |"," Zip Code |","      City      |","  Transportation  |");
				System.out.println("==========================================================================================================================================");

				if(collegearray.size()>0)
				{
				for(num=0;num<foodarray.size();num++)
				{
					System.out.printf(format3,(num+1),arrayname.get(foodarray.get(num)),arraymatricnum.get(foodarray.get(num)),arraycollege.get(foodarray.get(num)),arraystreet.get(foodarray.get(num)),arrayzip.get(foodarray.get(num)),arraycity.get(foodarray.get(num)),/*arraystate.get(foodarray.get(num)),arrayfood.get(foodarray.get(num)),*/arraytransport.get(foodarray.get(num)));
				}
				}
				else
				{
					System.out.println("No record");
					record=false;
				}
				System.out.println("==========================================================================================================================================");
			}
			else if(sort==4)
			{
				System.out.println("========================================================================================");
				System.out.printf(format4,"Num |","                Name               |"," Matric ID |","   Allergies    |","  Country      |");
				System.out.println("========================================================================================");
				if(collegearray.size()>0)
				{
				for(num=0;num<collegearray.size();num++)
				{
					System.out.printf(format4,(num+1),arrayname.get(collegearray.get(num)),arraymatricnum.get(collegearray.get(num)),arrayfood.get(collegearray.get(num)),arraystate.get(collegearray.get(num)));
				}
				}
				else
				{
					System.out.println("No record");
					record=false;
				}

				System.out.println("=======================================================================================");
			}
			else if(sort==5)
			{
				System.out.println("====================================================================================");
				System.out.printf(format5,"Num |","                Name               |"," Matric ID |"," College |","  Country      |");
				System.out.println("====================================================================================");

				if(collegearray.size()>0)
				{
				for(num=0;num<foodarray.size();num++)
				{
					System.out.printf(format5,(num+1),arrayname.get(foodarray.get(num)),arraymatricnum.get(foodarray.get(num)),arraycollege.get(foodarray.get(num)),arraystate.get(foodarray.get(num)));
				}
				}
				else
				{
					System.out.println("No record");
					record=false;
				}
				System.out.println("===================================================================================");
			}

			if(record)
			{
			System.out.print("Sort based on: ");
			if(sort==1)
			{
				System.out.println(arraycollege.get(collegearray.get(0))+" & "+arraystate.get(collegearray.get(0)));
			}
			else if(sort==2)
			{
				System.out.println(arraycity.get(cityarray.get(0))+" & "+arraystate.get(cityarray.get(0)));
			}
			else if(sort==3)
			{
				System.out.println(arrayfood.get(foodarray.get(0))+" & "+arraystate.get(foodarray.get(0)));
			}
			else if(sort==4)
			{
				System.out.println(arraycollege.get(collegearray.get(0)));
			}
			else if(sort==5)
			{
				System.out.println(arrayfood.get(foodarray.get(0)));
			}
			}


		}
		else if(rep=="Stay")
		{
			String format="%-5s %-36s %-12s %-10s %-17s\n";
			int num;
			System.out.println("====================================================================================");
			System.out.printf(format,"Num |","                Name               |"," Matric ID |"," College |","   Allergies    |");
			System.out.println("====================================================================================");

			if(sort==1)
			{
				for(num=0;num<collegearray.size();num++)
				{
					System.out.printf(format,(num+1),arrayname.get(collegearray.get(num)),arraymatricnum.get(collegearray.get(num)),arraycollege.get(collegearray.get(num)),arrayfood.get(collegearray.get(num)));
				}
				System.out.println("====================================================================================");
				System.out.println("Sort based on: "+arraycollege.get(collegearray.get(num-1)));
			}
			else if(sort==2)
			{
				for(num=0;num<foodarray.size();num++)
				{
					System.out.printf(format,(num+1),arrayname.get(foodarray.get(num)),arraymatricnum.get(foodarray.get(num)),arraycollege.get(foodarray.get(num)),arrayfood.get(foodarray.get(num)));
				}
				System.out.println("====================================================================================");
				System.out.println("Sort based on: "+arrayfood.get(foodarray.get(num-1)));
			}


		}


		statearray.clear();
		collegearray.clear();
		cityarray.clear();
		foodarray.clear();
	}


}
