/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This superclass contains the constructor for Item, StageD creates an array of these objects.  
 */

// Superclass
public abstract class Item {

	// protected allows subclass to directly
	// access variables, without a getter/setter.
	private String title;
	private String description;
	private static int itemID = 100;
	protected boolean available;

	// constructor for Item:
	public Item(String title, String description, boolean available) {
		this.title = title;
		this.description = description;
		this.available = available;
	}

	public String getTitle() {
		return title;
	}

	// Display item method:
	public void displayItem() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf(" ID:  %32s\n", itemID);
		System.out.printf(" Item title:  %32s\n", title);
		System.out.printf(" Description:  %32s\n", description);
		System.out.printf(" Available for hire?:  %32s\n", available);
	}

	public boolean hireItem(String customerID, int numWeeks) {

		return false; // if already hired out - true if available.

	}

	public boolean returnItem() {

		return false; // if it was not hired - true if it was.
	}
	
	// All 'concrete' subclasses of Student must
	// implement method calculateGrade.
	public abstract Double determinePrice();

//	public boolean bookEvent(String ticketType, String name) {
//		// Prints ticket details and increments the count of tickets
//		// sold to indicate that a booking has occurred:
//		System.out.println(" Printing ticket......");
//		System.out.println("+-------------------------------------------------+");
//		System.out.println("|------------- T F F Events Presents -------------|");
//		System.out.println("+-------------------------------------------------+");
//		System.out.printf("| Event: %40s |\n", title);
//		System.out.println("+-------------------------------------------------+");
//		System.out.printf("| Name:           %31s |\n", name);
//		System.out.printf("| Ticket type:    %31s |\n", ticketType);
//		switch (ticketType) {
//		case "Adult":
//			System.out.printf("| Price:   %32s%6.2f |\n", "$", adult);
//			break;
//		case "Child":
//			System.out.printf("| Price:   %32s%6.2f |\n", "$", child);
//			break;
//		case "Concession":
//			System.out.printf("| Price:   %32s%6.2f |\n", "$", concession);
//			break;
//		}
//		System.out.println("+-------------------------------------------------+");
//		// return true only as we have no ticket limits:
//		purchasedTickets++;
//		return true;
//	}
}
