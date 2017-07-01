import java.time.LocalDate;
//import java.util.Date;

public class Textbook 
{
	
	private String text_title;
	private String publisher_name;
	private int num_in_inventory;
	
	private int class_ID;
	
	private double price_if_lost;
	
	@SuppressWarnings("deprecation")
	//All Textbooks are currently set to have a due_date = Sept 1, 2017
	private LocalDate due_date;
	

	public Textbook() 
	{
		text_title = "";
		publisher_name = "";
		
		num_in_inventory = 0;
		class_ID = 0;
		
		price_if_lost = 0.0;
		
		//due_date = new LocalDate(0, 0, 0);
		
	}
	
	public Textbook(String title, String nameOfPub,int num, int classID, double price, LocalDate date_is_due) 
	{
		this.text_title = title;
		this.publisher_name = nameOfPub;
		
		this.num_in_inventory = num;
		this.class_ID = classID;
		
		this.price_if_lost = price;
		
		this.due_date = date_is_due;
		
	}
	public String toString() {
		return this.getText_title();
	}
	
	//Getter and Setters
	public String getText_title() {
		return text_title;
	}
	public void setText_title(String text_title) {
		this.text_title = text_title;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public int getNum_in_inventory() {
		return num_in_inventory;
	}
	public void setNum_in_inventory(int num_in_inventory) {
		this.num_in_inventory = num_in_inventory;
	}
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	public double getPrice_if_lost() {
		return price_if_lost;
	}
	public void setPrice_if_lost(double price_if_lost) {
		this.price_if_lost = price_if_lost;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	}
