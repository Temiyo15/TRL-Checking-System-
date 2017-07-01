//Heather comments that the ArrayList data type comes from this library.
import java.time.LocalDate;
import java.util.ArrayList;

/////////////////////////////////////////////////////////////////////////
//File: Patron.java
//
// This file is for a Patron (person) who checks out books from the rental
// library. Each person (Patron) has an ArrayList associated with him. The
// arrayList, called copiesOut, contains a list of books that they have 
// checked out. They should be able to check out more than one (two? 
// See requirements).
//
////////////////////////////////////////////////////////////////////////

public class Patron
{
	private String patron_name;
	private String patron_ID;
	
	
	//Heather comments an ArrayList is a dynamic array that can change size whenever we want.
	//      This ArrayList holds a bunch of Copy objects.
	private ArrayList<Copy> copiesOut;
	private ArrayList<Cla_ss> classes;	
	private ArrayList<Textbook> books_required;
	
	
	//long data type to represent an unsigned 64-bit long, which has a minimum value of 0 and a maximum value of 264-1
	private Long phone;
	
	private String local_address;
	private String perm_address;
	private String email;
	private String term;
	
	
	//In Windows, generate getter and setters with: Alt + Shift + S
	public Patron()
	{
	
		this.patron_name = "";
		this.patron_ID = "";
		
		//ArrayList help
		//See ArrayList Vs. array: https://www.youtube.com/watch?v=ZVJ7kpEMc7U
		//See https://www.youtube.com/watch?v=L1a8R9nkJ4w
		
		//Allocate some memory Copy objects. This has default capacity 10. It will resize when it reaches capacity.
		this.copiesOut = new ArrayList<Copy>();	
		this.classes = new ArrayList<Cla_ss>();
		this.books_required = new  ArrayList<Textbook>();
		//classes = new int[10];
		//num_of_classes = this.classes.size();
		
		phone = (long) 0;
		
		local_address = "";
		perm_address = "";
		email = "";
		term = "";	
		
	}
	//This is used for testing data and methods in the Patron class.
	public Patron(Boolean testData)
	{
		this.patron_name = "Temi A.";
		this.patron_ID = "P6";
		
		ArrayList<Copy> copiesOut= new ArrayList<Copy>();
		ArrayList<Cla_ss> classes = new ArrayList<Cla_ss>();
		ArrayList<Textbook> books_required = new ArrayList<Textbook>();
		
		//Get a couple Copies from the database
		FakeDB db = new FakeDB();
		
		Copy c1 = db.getCopy("C3");
		Copy c2 = db.getCopy("C4");
		
		//Put those Copies from the database into Temi's list of checked out copies .
		
	
		//public Copy putCopy(String copyID, Copy c);
		//copiesOut = db.put("C1");
		this.copiesOut.add(0, c1);//putCopy("C3", c);
		this.copiesOut.add(1, c2);
		
		
		
		//Get a class from the database and add it to Temi's class list.
		Cla_ss s1 = db.getClass((long) 63507);
		this.classes.add(s1);	
		
		////////////////////////////////////////////////////////////////////////////
		//THIS MIGHT BE WHERE THE NULL POINTER EXCEPTION COMES FROM !!!!!!!!!!!!!!!!!!
		/////////////////////////////////////////////////////////////////////////////
		books_required = null;
		
		//phone = (long) 6512227777;
		
		local_address = "123 St thomas blvd.";
		perm_address = null;
		email = "akin@stthomas.edu";
		term = "Summer2017";
	}
	public Patron(String id, String name)
	{

		this.patron_name = name;
		this.patron_ID = id;
		
		
		//ArrayList help
		//See ArrayList Vs. array: https://www.youtube.com/watch?v=ZVJ7kpEMc7U
		//See https://www.youtube.com/watch?v=L1a8R9nkJ4w
		
		//Allocate some memory Copy objects. This has default capacity 10. It will resize when it reaches capacity.
		this.copiesOut = new ArrayList<Copy>();	
		this.classes = new ArrayList<Cla_ss>();	
		//classes = new int[10];
		//num_of_classes = 0;
		
		phone = (long) 0;
		
		local_address = "";
		perm_address = "";
		email = "";
		term = "";	
		
	}
	public String classStrings()
	{
		String classes = "";
		
		for (int i = 0; i < this.classes.size(); i++) {
			classes.equals(classes.concat(""+this.classes.get(i)));
		}
		
		return classes;
	}
//	public String classStrings()
//	{
//		String classes = "";
//		
//		for (int i = 0; i < this.classes.length; i++)
//		{
//			if(this.classes[i] != 0)
//			{
//				classes = classes.concat(" "+ this.classes[i] + "/n");
//			}
//		}
//		
//		return classes;
//	}
	
// Generate getters and setters using Eclipse Source menu.
	
	public void setclass(int class_ID) 
	{
		
		
	}
	public ArrayList<Textbook> getRequiredTextbooks() 
	{
		return this.books_required;
	}
	
	public ArrayList<Cla_ss> getClasses() 
	{
		return this.classes;
	}
	
	public String getPatron_name() {
		return patron_name;
	}

	public void setPatron_name(String patron_name) {
		this.patron_name = patron_name;
	}

	public String getPatron_ID() {
		return patron_ID;
	}

	public void setPatron_ID(String patron_ID) {
		this.patron_ID = patron_ID;
	}


	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getLocal_address() {
		return local_address;
	}

	public void setLocal_address(String local_address) {
		this.local_address = local_address;
	}

	public String getPerm_address() {
		return perm_address;
	}

	public void setPerm_address(String perm_address) {
		this.perm_address = perm_address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}


	public ArrayList<Copy> getCopiesOut() 
	{
		return copiesOut;
	}


	public void setCopiesOut(ArrayList<Copy> copiesOut) 
	{
		this.copiesOut = copiesOut;
	}
	
	public int countClasses()
	{
		int count = 0;
		
		count = this.classes.size();
		
		StdOut.println( "--- Patron.countclasses() = " + count);
		
	return count;	
	}
	public void addClasstoSchedule(Cla_ss c)
	{
		this.classes.add(c);
	}
	
	///////////////////////////////////////////////////////
	//	USECASE #1 PATRON CHECKSOUT N BOOKS
	///////////////////////////////////////////////////////
	
//	DONE 1.A Patron brings some number, N, of Textbook Copies. 
//	DONE 2.Worker enters the Patron's patron_ID and initiates the checkout process. 

//	DONE 3.The System checks for Holds on the Patron account. (method checkHasHolds())

//	4. The System retrieves the list of classes that the Patron is taking/teaching, and associates those classes with a list of required Textbooks (book_record). 
//	5. The Worker enters a number, N, that represents the number of Textbook Copies that a Patron has brought to the WorkerStation for checkout. 
//	6. The Worker scans the barcode of a Textbook Copy. 
//	7. The System verifies that the Textbook Copy title is on the Patron's list of required Textbooks (book_record). 
//	8. The Worker enters the book's Copy_ID, a unique identifier for each Copy of the Textbook. 

	
//	9. The System initiates a CheckOut event. It changes the state of this Copy to 'Checked out,' by associating this Copy_ID with the patron_ID and todays_date.  
//     The System makes a Record of this System Event called 'Checkout.' The System concludes this Checkout event by returning a message to the Worker. 
//	     Repeat steps 6, 7, 8, and 9 for each of the N Textbook Copies. 

//	10. The System tells the Worker the due_date for the Checkedout Textbook Copies. The Worker verbally informs the Patron of the due date. 
//	11. The Patron leaves the store with their rented Textbook Copies.
//	
//	
	
	
///////////////////////////////////////////////////////////
//	This is step 3 of UseCase #1. PATRON CHECKSOUT N BOOKS
///////////////////////////////////////////////////////////
	public boolean checkHasHolds()
	{
		boolean has_holds = false;
		
		//search this.copiesOut ArrayList for holds. It is size 10.
		
		if (this.copiesOut.isEmpty())
		{
			has_holds = false;
		}
		else
		{
			for (Copy c : this.copiesOut) 
			{
				  if (c.hasHold() == true)
				  {
					  has_holds = true;
					  break;
				  }
			}
		}
		
		return has_holds;
	}
	
///////////////////////////////////////////////////////////
//UC #1, Steps 3 and 4 are in the controller class, Rental Library.
///////////////////////////////////////////////////////////

	
	public boolean checkCopyOut(Copy c)
	{

		// finish this
		boolean bookCheckedOut = false;
		
		//check holds
		
		
		
		//Put book back into inventory at the Rental office
		this.getCopiesOut().add(c);
		
		//set the value of Copy.outTo to the patron variable
		c.setOutTo(this);
		
		//if the book is NOT in Erics arrayList, then return false. Else, 
		//   the test succeeds and returns true, indicating that Eric
		//   got the book from the rental office. It is now stored in his
		//   arrayList of books.

		bookCheckedOut = this.CopyisInArrayList(c);	
		
		return bookCheckedOut;
	}

	public boolean CopyisInArrayList(Copy c)
	{
		boolean result = false;
		
		if (this.getCopiesOut().contains(c))
			result = true;
		else
			result = false;
		
	return result;
	}



	//What does this mean? See requirements.
	
	//Temi wrote this.
	public boolean checkCopyIn(Copy c)
	{
		// finish this
		
		boolean bookReturned = false;
		
		//Get the ID of the book that is being returned (checkedIn).
		String book_ID_for_removal = c.getCopyID();
		
		Patron person_checking_in_a_book = null;
		
		//Get the ID of the person that is returning a book to the rental shop (checkingIn).
		String patron_id = c.getOutToID();
		
		//Get the ID of the person object.
		person_checking_in_a_book = FakeDB.getPatron(patron_id);
		
		//Get the ID of the person's name.
		String patron_name_checked_out_to = person_checking_in_a_book.getPatron_name();
		
		
		//Put book back into inventory at the Rental office

		
		
		StdOut.println("");
		StdOut.println("" + c.toString());
		//StdOut.println("" + c.getOutToID());
		StdOut.println("This book will be returned to the rental shop by Patron named " + patron_name_checked_out_to + ". His ID # is " + c.getOutToID() + "."  );
		StdOut.println("");
		
		//This method used the wrong paramenter. That was the error.
		//bookReturned = this.getCopiesOut().remove(book_ID_for_removal);
		
		bookReturned = this.getCopiesOut().remove(c);
		
		//set the value of Copy.outTo to null because no one has it checked out.
		c.setOutTo(null);
		
		
		//if the book is still in Erics arrayList, then return false, else 
		//   return true, indicating that Eric gave the book back to the rental office.
	
		bookReturned = this.CopyisInArrayList(c);	
		bookReturned = !(bookReturned);
		
		return bookReturned;
	}

	//Heather wrote this.
	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same patron ID
		
		Patron p = (Patron) o;
		
		if (this.patron_ID.equals(p.getPatron_ID()))
		{
			return true;
		}
		else
		return false;
	}

	//Heather wrote this
	public String toString()
	{
		// finish this: return basic Patron info as String
		
		String p = "";
		
		p = p.concat("PATRON ID: " + this.getPatron_ID() + "\n" + "PATRON NAME: " + this.getPatron_name() + "\n" + "PATRON'S CHECKED OUT BOOKS: " + this.getCopiesOut() + "\n");
		
		// Heather says test p1.toString() in main.
		
		return p;
	}
	
	//NOTE: Level WANTS OUTPUTS LIKE: StdOut.println("c1" );
	public static void main(String[] args)
	{
		Patron p3 = new Patron("P3", "EricLevel");
		
		//Can I put p3 into the hashmap here....
	
		
		//OUTPUTTING TO THE SCREEN.....
		
		//This is how Ali Navqui liked output:
		//System.out.println("Hello.");
		
		//This is how Eric level wants us to output:
		//StdOut.println("Hello.");
		
		
		//1st output
		//System.out.println("We created a Patron object using the Patron constructor. \n");
		StdOut.println("We created a Patron object using the Patron constructor. \n");
		
		//2nd output - confirms that toString() works
		//System.out.println("" + p3);
		

		StdOut.println("----------------------------------------");
		StdOut.println("" + p3);
		
		//Patron p1 = new Patron();

		//3rd output 
		//System.out.println("getPatron() from FakeDB " + "\n" +  "----------------------" + "\n" + p1);
		//System.out.println("");
		
		
		FakeDB database = new FakeDB();
		//p1 = database.getPatron("P1");
		
		Patron p1 = database.getPatron("P1");
		
		p1.toString();
		
		StdOut.println("getPatron() from FakeDB " + "\n" +  "------------------------" + "\n" + p1.toString());
		//StdOut.println("");
		
		//4th output 
		Copy c1 = FakeDB.getCopy("C1");
		//System.out.println("getCopy() from FakeDB " + "\n" +  "----------------------" + "\n" + c1);
		//System.out.println("");
		StdOut.println("getCopy() of book from FakeDB " + "\n" +  "-----------------------------" + "\n" + c1);
		StdOut.println("");
		
		//5th output - Get a second book from the database
		Copy c2 = FakeDB.getCopy("C2");
		StdOut.println("getCopy() of a second book from FakeDB " + "\n" +  "--------------------------------------" + "\n" + c2);
		StdOut.println("");
		
		//Build tests????
		
		//Note on refractoring:
		//Before refractoring, build a solid test suite. They must be self checking. (Fowler, p8)
	
		///////////////////////////////////////////////////////////
		//	REQUIREMENTS TEST
		//////////////////////////////////////////////////////////
		
		//test #1. Eric has no books in his arrayList.
		StdOut.println("");
		
		StdOut.println("Eric goes to the rental office to checkout a book." );
		StdOut.println("This is Eric's list of books before checkout ...");
		StdOut.println("");

		StdOut.println("--------------------------");
		StdOut.println("BEFORE CHECKOUT OF TEXTBOOK: ");
		StdOut.println("--------------------------");
		StdOut.println("" + p1.toString());
		
		//CHECKOUT METHODS HERE - Checkout 2 books
		
		//test #2. Eric has ONE book in his arrayList.
		StdOut.println("---------------------------------");
		StdOut.println("AFTER CHECKOUT OF FIRST TEXTBOOK:");
		StdOut.println("---------------------------------");
		//StdOut.println("" + p1.getName() + "'s checked out books: " + p1.getCopiesOut());
		StdOut.println("A book was checked out: " + p1.checkCopyOut(c1));
		StdOut.println("");
		StdOut.println("" + p1.toString());
		StdOut.println("");
		
		//test #3. Eric has two bookS in his arrayList.
		StdOut.println("------------------------------------");
		StdOut.println("AFTER CHECKOUT OF A SECOND TEXTBOOK:");
		StdOut.println("------------------------------------");
		//StdOut.println("" + p1.getName() + "'s checked out books: " + p1.getCopiesOut());
		StdOut.println("A book was checked out: " + p1.checkCopyOut(c2));
		StdOut.println("");
		StdOut.println("" + p1.toString());
		
		//CHECKOUT METHODS HERE - Return (checkIn) 1 book to the rental office.
		
		StdOut.println("------------------------------------");
		StdOut.println("AFTER RETURNING THE SECOND TEXTBOOK:");
		StdOut.println("------------------------------------");
		StdOut.println("A book was checked in: " + p1.checkCopyIn(c2));
		StdOut.println("");
		StdOut.println("" + p1.toString());
		
		
		
	}	

}
