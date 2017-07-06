import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Workstation 
{
	//yazeed
	//no
	//This is our controller class
	LocalDateTime checkoutDate ;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	String patron_ID_entered;
	
	public Workstation() 
	{
		this.patron_ID_entered = "P0";
		
	}
	public Workstation(String patronID) 
	{
		
		this.patron_ID_entered = patronID;
		
	}
	public void getRequiredTextbookList(Patron p)
	{
		
	}
	
	public void startCheckout(String worker_ID)
	{
		Gui g = new Gui();
		
		//Worker enters Patron id
		
		String patronID = "";
		
		patronID = g.enterPatronID();
		
		
		//get Patron name from DB
		
		FakeDB db = new FakeDB();
		
		Patron p = new Patron();
		
		//build a second patron that contains data already.
		//Patron temiIsPatron = new Patron(true);
	
		//get patron from database
		
		p = db.getPatron(patronID);
		
		//check for holds
		
		Boolean has_holds = p.checkHasHolds();
		//Boolean temi_has_holds = temiIsPatron.checkHasHolds();
		
		
		StdOut.println( "" );
		
		//output any holds to Worker.
		
		StdOut.println( "" + p.getPatron_name() + g.outputHolds(has_holds));
		StdOut.println("");
		
		//StdOut.println("" + temiIsPatron.getPatron_name() + g.outputHolds(temi_has_holds));
		//get Patron classes
		
		////////////////////////////////////////////
		//Put some class data and Textbooks into Patron here...This is an External Event.
		////////////////////////////////////////////
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		String formattedDate = formatter.format(LocalDate.now());
		
		//public Textbook(String title, String nameOfPub,int num, int classID, double price, Date date_is_due) 
		Textbook t1  = new Textbook("Technical Communications", "Wiley",14, 63507, 15.63, LocalDate.now());
		Textbook t2  = new Textbook("Designing SQl", "Wiley",22, 63002, 123.55, LocalDate.now());
		
		//ADD Class data --> this is an External event
		//	public Cla_ss(int id,String name,String term,LocalDate start_date,LocalDate end_date,int max_num,String dept, boolean nxt_sem, ArrayList<Textbook> text )
		Cla_ss c1 = new Cla_ss(63507,"Tech Comm","Summer2017",LocalDate.now(),LocalDate.now(),10,"SIES", true,t1);
		Cla_ss c2 = new Cla_ss(63002,"Database Design","Summer2017",LocalDate.now(),LocalDate.now(),15,"SIES", true,t2 );
		//Add a class to patrons schedule
		p.addClasstoSchedule(c1);
		p.addClasstoSchedule(c2);
		//temiIsPatron.addClasstoSchedule(c);
	
		 //show patron schedule
	
		StdOut.println( "Patron Name: " + p.getPatron_name() + "\n" + "Patron classes: "+ p.getClasses().toString());
		StdOut.println( "\nPatrons Required Textbooks: " + p.getRequiredTextbooks() );
		StdOut.println( "");
		
		//Worker enters the number of copies brought to the counter by the Patron.
		int numBooksAtCounter = g.enterNumberOfBooks();
		
		StdOut.println( "----Begin checkout of " + numBooksAtCounter + " books----");
		
		//This is an external event where the student registers for two classes.
		
		//ERROR HERE......I need a valid classCount.
		//p.setclass(60201);	//p has registered for class 602, section 02 
		//p.setclass(63507);	//p has registered for class 635, section 07 
		
		//StdOut.println( "Patron name: " + p.getPatron_name());
		//StdOut.println("Classes:" + p.getClasses());
		//StdOut.println("" + p.classStrings());
		
		
		//Loop logic starts here.
		
		
		
		
		
	}
	
	public void checkOutLoop()
	{
		
	}
	
	public void endCheckout()
	{
		//set the checkout date to today and time to now().
	
		//System.out.println(dtf.format(now)); //2016/11/16 12:08:43
		
		checkoutDate = LocalDateTime.now();
		
		
	}
	
	public static void main(String[] args)
	{
		
		Workstation myWorkStation = new Workstation();
		
		Worker myWorker = new Worker();
		
		myWorker.setWorker_ID("W1");
		
		myWorkStation.startCheckout(myWorker.getWorker_ID());
		
		myWorkStation.checkOutLoop();
	
	}

}
