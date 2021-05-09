/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This class contains the constructor for TffExperienceEvent. 
 * This is an extension of the TffEvent superclass. 
 */

// Subclass
public class Toy extends Item {

	//private String toyType;
	private String category;
	private double weeklyPrice;
	//move these to constructor
	private final double construction = 5.45;
	private final double rideOn = 8.00;
	private final double sport = 6.50;

	// constructor for Toy - extends Item:
	public Toy(String title, String description, boolean available, String category) {
		super(title, description, available);
		this.category = category;
	}

//	// Displays attendee names, ticket types, and price paid:
//	public void displayTickets() {
//		for (int i = 0; i < bookings.length; i++) {
//			if (bookings[i] != null) {
//				// Split the bookings[i] String to format as required:
//				String[] toTable = bookings[i].split(",");
//				System.out.format("%-20s %15s", toTable[0], toTable[1]);
//				if (toTable[1].contains("Adult")) {
//					System.out.printf("%4s%7.2f\n", "$", adult);
//				} else if (toTable[1].contains("Child")) {
//					System.out.printf("%4s%7.2f\n", "$", child);
//				} else if (toTable[1].contains("Concession")) {
//					System.out.printf("%4s%7.2f\n", "$", concession);
//				}
//			}
//		}
//	}

//	// search and return for booking names:
//	public boolean refundName(String targetName) {
//		for (int i = 0; i < getPurchasedTickets(); i++) {
//			if ((this.bookings[i] != null) && (this.bookings[i].toLowerCase().contains(targetName.toLowerCase()))) {
//				// Set reference of i to null to remove that booking:
//				this.bookings[i] = null;
//				// Decrement purchasedTickets:
//				purchasedTickets--;
//				return true;
//			}
//		}
//		return false;
//	}

//	@Override
//	public boolean bookEvent(String ticketType, String name) {
//		if ((maxTickets - getPurchasedTickets()) > 0) {
//			// Calls method from superclass:
//			super.bookEvent(ticketType, name);
//			String msg = " ";
//			msg += name;
//			msg += ", ";
//			msg += ticketType;
//			System.out.println();
//			System.out.println("All bookings for " + getTitle() + ":");
//			System.out.println();
//			for (int i = 0; i < maxTickets; i++) {
//				if (bookings[i] == null) {
//					bookings[i] = msg;
//					break;
//				}
//			}
//		} else {
//			System.out.println("Error - sorry, no tickets remaining for " + getTitle());
//			// Returns false if booking failed:
//			return false;
//		}
//		// Returns true if the booking is performed.
//		return true;
//	}

	@Override
	public void displayItem() {
		// Calls method from superclass:
		super.displayItem();
		// Adds extra details for Toy object only:
		System.out.printf(" Category:  %32s\n", category);
		System.out.printf(" Price/Week:  %32d\n", weeklyPrice);
	}

	@Override
	public Double determinePrice() {
		// TODO Auto-generated method stub
		return null;
	}
}
