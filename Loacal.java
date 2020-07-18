


class Local extends Student
{
	private Location l=new Location();
	public Local(){}
	public Local(Location l)
	{
		super(l);
	}
	public String category()
	{
		return "Local";
	}

}
