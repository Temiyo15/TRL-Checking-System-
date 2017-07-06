import java.util.Date;

////////////////////////////////////////////////////////////////////////////
//File: Copy.java
//
// This file represents books. 
// These books are contained in the arrayList object in file Patron.java.
// The arrayList holds all the books that each person has checked out.
//
/////////////////////////////////////////////////////////////////////////////
//help
public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;
	
	private boolean checked_out;
	private boolean overdue;
	private boolean hold;
	private Date check_out_date;

	public Copy(String copyID, String title)
	{
		this.copyID = copyID;
		this.title = title;
		
		checked_out = false;
		overdue = false;
		hold = false;
		
		//Will this produce a null pointer exception????????????
		check_out_date = null;
	}

// Generate getters and setters using Eclipse Source menu.
	//Heather generated getter and setters by clicking Source -> Generate Getters and Setters.

	public boolean isChecked_out() {
		return checked_out;
	}

	public void setChecked_out(boolean checked_out) {
		this.checked_out = checked_out;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public boolean hasHold() {
		return hold;
	}

	public void setHold(boolean hold) {
		this.hold = hold;
	}

	public Date getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

	public String getCopyID() 
	{
		return copyID;
	}

	public void setCopyID(String copyID) 
	{
		this.copyID = copyID;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public Patron getOutTo() 
	{
		if (this.outTo.equals(null))
		{
			return null;
		}
		
		return outTo;
	}

	public String getOutToID() 
	{
		String id = outTo.getPatron_ID();
		
		return id;
	}

	public void setOutTo(Patron outTo) 
	{
		this.outTo = outTo;
	}

	// Heather wrote this.
	public String toString()
	{
		
		String book = "";
		
		book = book.concat("\nCOPY TITLE: " + this.getTitle() + "\n" + "COPY ID: " + getCopyID());
		
//		if (!(getOutToID().equals(null)))
//		{
//			book = book.concat("COPY CHECKED OUT TO: " + getOutToID());
//		}
		
		return book; 
	}

	//Heather wrote this.
	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same copy ID
		
		Copy c = (Copy) o;
		
		if (this.copyID.equals(c.getCopyID()))
		{
			return true;
		}

		return false;
	}

	//NOTE: HE WANTS OUTPUTS LIKE: StdOut.println("c1" );
	public static void main(String[] args)
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		//This line print the first output.
		StdOut.println("c1" + "\n" + "---");
		System.out.println(c1);
		
		StdOut.println("");
		
		//This line print the second output.
		StdOut.println("p1" + "\n" + "---");
		System.out.println(p1);
		
		Copy c2 = FakeDB.getCopy("C2");
		
		//Heather wrote this.
		//This line print the second output. We can see that they are almost identical.
		StdOut.println("c1" + "\n" + "---" + "\n" + c1.toString() + "\n");
		
		
		
		
	}
}
