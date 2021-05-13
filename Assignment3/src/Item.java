import java.io.PrintWriter;
import java.util.Scanner;

/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This superclass contains the constructor for Item. 
 * StageD creates an arrayList of these objects. Each class is responsible for their own writing and loading to file.
 */

// Superclass
public abstract class Item {

	// protected allows subclass to directly
	// access variables, without a getter/setter.
	private static int itemID = 100;
	protected int toyID;
	private String title;
	private String description;
	protected boolean available;
	protected String customerID;
	protected int numWeeks;

	// Constructor for abtract class "Item" - this is extended by each subclass:
	public Item(String title, String description, boolean available) {
		this.title = title;
		this.description = description;
		this.available = available;
		++itemID;
		toyID = itemID;
	}

	// It is good object-oriented programming to have an object responsible
	// for reading it's own data from file.
	// The argument for this constructor is a stream (e.g. a file) which
	// the object can access to obtain its data.
	public Item(Scanner sc) {
		this.toyID = Integer.parseInt(sc.nextLine());
		this.title = sc.nextLine();
		this.description = sc.nextLine();
		this.available = Boolean.parseBoolean(sc.nextLine());
	}

	public String getTitle() {
		return title;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getToyID() {
		return toyID;
	}

	// Method used to reduce itemID count down by 1, after Toy constructor exception
	// is thrown:
	public void decreaseID() {
		Item.itemID--;
	}

	// Display item method:
	public void displayItem() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf(" ID           :  %d\n", toyID);
		System.out.println(" Type         :  " + getClass().getSimpleName());
		System.out.printf(" Item title   :  %s\n", title);
		System.out.printf(" Description  :  %s\n", description);
		System.out.printf(" Available?   :  %s\n", available);
	}

	public void hireItem(String customerID, int numWeeks) throws HiringException {
		this.customerID = customerID;
		this.numWeeks = numWeeks;
		if (!available) {
			throw new HiringException("Item is already on loan.");
		} else {
			available = false;
			System.out.println("Item " + toyID + " loaned for " + numWeeks + " weeks to ID# " + customerID);
		}
	}

	public void returnItem() throws HiringException {
		if (available) {
			throw new HiringException("Item is not on loan.");
		} else {
			available = true;
			System.out.println("Item " + toyID + " returned by customer ID# " + customerID);
			customerID = null;
			numWeeks = 0;
		}
	}

	// Abstract method determinePrice() - all subclasses are forced to implement
	// this method, each one will contain its own specific body:
	public abstract Double determinePrice();

	// The object is responsible for writing its own data to a stream (e.g. file)
	public void writeData(PrintWriter pw) {
		// getSimpleName gets the name of the class of the object
		pw.println(this.getClass().getSimpleName());
		pw.println(this.toyID);
		pw.println(this.title);
		pw.println(this.description);
		pw.println(this.available);
	}
}
