/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This class contains the constructor for TffExperienceEvent. 
 * This is an extension of the TffEvent superclass. 
 */

// Subclass
public class DressUp extends Item {

	private String genre;
	private int size;
	private int totalPieces;
	private double weeklyPrice;

	// constructor for DressUp - extends Item:
	public DressUp(String title, String description, boolean available, String genre, int size, int totalPieces) {
		super(title, description, available);
		this.genre = genre;
		this.size = size;
		this.totalPieces = totalPieces;

		weeklyPrice = totalPieces * 3.50;
	}

	// Displays attendee names, ticket types, and price paid:
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
		System.out.printf(" Genre:  %32s\n", genre);
		System.out.printf(" Size:  %32d\n", size);
		System.out.printf(" Total pieces:  %32d\n", totalPieces);
		System.out.printf(" Price/Week:  %32.2f\n", (totalPieces * 3.50));
		System.out.printf(" Cleaning fee:  %32s\n", "$3.00");
	}

	@Override
	public Double determinePrice() {
		// TODO Auto-generated method stub
		return null;
	}
}
