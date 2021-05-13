import java.io.PrintWriter;
import java.util.Scanner;

/* CPT121 / COSC2135 Programming 1 - Assignment 3
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This class contains the constructor for DressUp objects. 
 * This is an extension of the Item superclass, and is final.
 */

// Subclass of Item:
public final class DressUp extends Item {

	private String genre;
	private int size;
	private int totalPieces;
	private double weeklyPrice;
	private double laundryFee = 3.00;
	private double totalPrice;

	// constructor for DressUp - extends Item:
	public DressUp(String title, String description, boolean available, String genre, int size, int totalPieces) {
		super(title, description, available);
		this.genre = genre;
		this.size = size;
		this.totalPieces = totalPieces;
		this.weeklyPrice = totalPieces * 3.50;
	}

	// Notice we are taking advantage of inheritance
	public DressUp(Scanner sc) {
		super(sc);
		this.genre = sc.nextLine();
		this.size = Integer.parseInt(sc.nextLine());
		this.totalPieces = Integer.parseInt(sc.nextLine());
		this.weeklyPrice = Double.parseDouble(sc.nextLine());
		this.laundryFee = Double.parseDouble(sc.nextLine());
	}

	// Object is responsible for writing its own data - using inheritance:
	@Override
	public void writeData(PrintWriter pw) {
		super.writeData(pw);
		pw.println(this.genre);
		pw.println(this.size);
		pw.println(this.totalPieces);
		pw.println(this.weeklyPrice);
		pw.println(this.laundryFee);
	}

	@Override
	public void displayItem() {
		super.displayItem();
		// Adds extra details for DressUp object only:
		System.out.printf(" Genre        :  %s\n", genre);
		System.out.printf(" Size         :  %d\n", size);
		System.out.printf(" # pieces     :  %d\n", totalPieces);
		System.out.printf(" Price/Week   :  %.2f\n", weeklyPrice);
		System.out.printf(" Cleaning fee :  %.2f\n", laundryFee);
		System.out.println(" ------------ ");
		if (!available) {
			System.out.printf(" On loan to   :  %s for %d weeks\n", customerID, numWeeks);
			System.out.printf(" Total cost   :  %.2f\n", this.determinePrice());
			System.out.println(" ----------------------------------------------- ");
		}
	}
	
	// Overridden abstract method from Item.
	// Calculates total cost to current customer, including laundry fee:
	@Override
	public Double determinePrice() {
		this.totalPrice = weeklyPrice * numWeeks;
		totalPrice += laundryFee;
		return totalPrice;
	}
}
