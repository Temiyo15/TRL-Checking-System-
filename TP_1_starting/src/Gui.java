
public class Gui 
{

	public Gui() 
	{
	
	}

	public String enterPatronID()
	{
		String patron_id = "";
		
		StdOut.println( "--- Please enter the Patron's ID number ----");
		StdOut.println( "    Enter either 'P1' or 'P2' >> ");
		
		patron_id = StdIn.readLine();
	
		return patron_id;
	}
	
	public String outputHolds(boolean has_holds)
	{
		String holds;
		
		if (has_holds == true)
		{
			holds = " has Holds on account.";
		}
		else
			holds =  " has no holds on account.";
		
		
		return holds;
	}
	public int enterNumberOfBooks()
	{
		int num = 0;
		
		StdOut.println( "--- Please enter the # of books brought to the counter by Patron ----");
		StdOut.println( "    Enter an integer value >> ");
		
		num = StdIn.readInt();
		
		return num;
	}
	
}
