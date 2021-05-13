import java.io.PrintWriter;

/* CPT121 / COSC2135 Programming 1 - Assignment 3
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This class contains the constructor for Toy objects. 
 * This is an extension of the Item superclass, and is final.
 */

// Subclass of Item:
public final class Toy extends Item {

	// private String toyType;
	private String category;
	private double weeklyPrice;
	private double totalPrice;

	// constructor for Toy - extends Item:
	public Toy(String title, String description, boolean available, String category) {
		super(title, description, available);
		this.category = category;

		if (category == "Contruction") {
			weeklyPrice = 5.45;
		} else if (category == "RideOn") {
			weeklyPrice = 8.00;
		} else if (category == "Sport") {
			weeklyPrice = 6.50;
		} else {
			decreaseID();
			throw new IllegalArgumentException("Category must be C, R or S");			
		}
	}


	// We are taking advantage of inheritance - object is now responsible for writing its own data
	@Override
	public void writeData(PrintWriter pw) {
		super.writeData(pw);
		pw.println(this.category);
	}

	@Override
	public void displayItem() {
		// Calls method from superclass:
		super.displayItem();
		// Adds extra details for Toy object only:
		System.out.printf(" Category     :  %s\n", category);
		System.out.printf(" Price/Week   :  %.2f\n", weeklyPrice);
		System.out.println(" -------------- ");
		if (!available) {
			System.out.printf(" On loan to   :  %s for %d weeks\n", customerID, numWeeks);
			System.out.printf(" Total cost   :  %.2f\n", determinePrice());
			System.out.println(" ----------------------------------------------- ");
		}
	}

	@Override
	public Double determinePrice() {
		this.totalPrice = weeklyPrice * numWeeks;
		return totalPrice;
	}
}
