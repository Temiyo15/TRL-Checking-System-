import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//hello
/////////////////////////////////////////////////////////////////////////
//File: FakeDB.java
//
// This file is a database that holds all the data for people (Patron's) and 
// textbooks (Copy's). 
//
// The data is stored in a HashMap.
//
// Each HashMap is like a table in a database.
//
// There is one hashMap for people (Patrons). It stores all the data for people 
//      who check out textbooks. It is called patronStore.
//
// There is a second hashMap for textbooks (Copies). It stores all the data for
//      textbooks. It is called copyStore.
//
// HashMaps have a key, which is a String, associated with each person or book. 
//
// Keys MUST be unique.
//
// Equals() and HashCode() methods should be defined in order to use the HashMap.
//
// References
// -----------
// HashMaps : https://www.youtube.com/watch?v=hgawTLk0o3Y
// See page 561 on HashCode: https://zimslifeintcs.files.wordpress.com/2011/12/head-first-java-2nd-edition.pdf
// HashCodes: https://www.youtube.com/watch?v=DSTpMWv0IlA
//
//
//
////////////////////////////////////////////////////////////////////////

public class FakeDB
{
	private static Map<String,Patron> patronStore;
	private static Map<String,Copy> copyStore;
	private static Map<String,Textbook> textbookStore;
	private static Map<Long, Cla_ss> classStore;
	
	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();
		//Changed this from : copyStore = new HashMap<String,Copy>();
		// to a TreeMap so its sorted???
		copyStore = new HashMap<String,Copy>();
		
		textbookStore = new HashMap<String,Textbook>();
		
		patronStore.put("P1", new Patron("P1", "Eric"));
		patronStore.put("P2", new Patron("P2", "Heather"));
		//patronStore.put("P3", value)
		//patronStore.put("P4", value)
		
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		copyStore.put("C3",new Copy("C3", "Java Programming") );
		copyStore.put("C4", new Copy("C4", "Pattern-Oriented Software Architecture"));
			
		@SuppressWarnings("deprecation")
		//All Textbooks are currently set to have a due_date = Sept 1, 2017
		
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		LocalDate date_is_due = today.plus(100, ChronoUnit.DAYS);
		
		textbookStore.put("Pattern-Oriented Software Architecture", new Textbook("Pattern-Oriented Software Architecture","Wiley",7, 76301, 44.57,date_is_due));
		//Using the book title as the key is a problem if two classes use the same textbook.
		textbookStore.put("Java Programming", new Textbook("Java Programming","Liang",30, 60101, 67.43,date_is_due));
		textbookStore.put("Java Programming", new Textbook("Java Programming","Liang",29, 60201, 67.43,date_is_due));
		textbookStore.put("Technical Communications", new Textbook("Technical Communications the easy way","Johnson",10, 60501, 78.99,date_is_due));
		//int id,String name,String term,LocalDate start_date,LocalDate end_date,int max_num,String dept, boolean nxt_sem, ArrayList<Textbook> text )
		//having a null in the Cla_ss constructor causes a nul pointer exception!!!!!!!!!!!!
		//classStore.put((long) 63507, new Cla_ss());
	
	}

	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	
	
	//Heather wrote this. It isn't exactly right. P13 should count the number of elements in the hashmap and increment.
	public static void putPatron(Object patron)
	{
		Patron p = (Patron) patron;
				
		patronStore.put("" + p.getPatron_ID(), new Patron("" + p.getPatron_ID(), p.getPatron_name()));	
		
	}
	
	public static Copy getCopy(String copyID)
	{
		return copyStore.get(copyID);
	}
	//this cant be a static method
	public void putCopy(String copyID, Copy c)
	{
		this.copyStore.put(copyID, c);
	}
	public static Cla_ss getClass(Long class_ID)
	{
		return classStore.get(class_ID);
	}
	//this cant be a static method
	public void putClass(Long class_ID, Cla_ss c)
	{
		this.classStore.put(class_ID, c);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	

}
