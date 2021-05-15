import java.io.PrintWriter;
import java.util.Scanner;

/* CPT121 / COSC2135 Programming 1 - Assignment 3
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This class contains the constructor for PlayEquipment Objects. 
 * This is an extension of the Item superclass, and is final.
 */

// Subclass of Item:
public final class PlayEquipment extends Item {

	private String weight;
	private String height;
	private String width;
	private String depth;
	private double weeklyPrice;
	private double totalPrice;

	// Constructor for PlayEquipment:
	public PlayEquipment(String title, String description, boolean available, String weight, String height, String width,
			String depth, double weeklyPrice) {
		super(title, description, available);
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weeklyPrice = weeklyPrice;
	}

	// Using inheritance to build upon Item's file reading method:
	public PlayEquipment(Scanner sc) {
		super(sc);
		this.weight = sc.nextLine();
		this.height = sc.nextLine();
		this.width = sc.nextLine();
		this.depth = sc.nextLine();
		this.weeklyPrice = Double.parseDouble(sc.nextLine());
	}

	// Object is responsible for writing its own data - using inheritance:
	@Override
	public void writeData(PrintWriter pw) {
		super.writeData(pw);
		pw.println(this.weight);
		pw.println(this.height);
		pw.println(this.width);
		pw.println(this.depth);
		pw.println(this.weeklyPrice);
	}
	
	@Override
	public void displayItem() {
		// Calls method from superclass:
		super.displayItem();
		System.out.printf(" Price/Week   :  $%.2f\n", weeklyPrice);
		
		//TODO fix up my display for all specs
		//System.out.println(" -------------- ");
		if (!available) {
			System.out.printf(" On loan to   :  %s for %d weeks\n", customerID, numWeeks);
			System.out.printf(" Cost         :  $%.2f\n", determinePrice());
			System.out.println(" ----------------------------------------------- ");
		}
	}

	@Override
	public Double determinePrice() {
		this.totalPrice = weeklyPrice * numWeeks;
		return totalPrice;
	}
}
