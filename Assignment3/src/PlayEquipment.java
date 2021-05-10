/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This class contains the constructor for TffExperienceEvent. 
 * This is an extension of the TffEvent superclass. 
 */

// Subclass
public class PlayEquipment extends Item {

	private String weight;
	private String height;
	private String width;
	private String depth;
	private double weeklyPrice;

	// constructor
	public PlayEquipment(String title, String description, boolean available, String weight, String height, String width,
			String depth, double weeklyPrice) {
		super(title, description, available);
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weeklyPrice = weeklyPrice;
	}


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
//		if ((weight - getPurchasedTickets()) > 0) {
//			// Calls method from superclass:
//			super.bookEvent(ticketType, name);
//			String msg = " ";
//			msg += name;
//			msg += ", ";
//			msg += ticketType;
//			System.out.println();
//			System.out.println("All bookings for " + getTitle() + ":");
//			System.out.println();
//			for (int i = 0; i < weight; i++) {
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
		//System.out.printf(" Category:  %32s\n", category);
		System.out.printf(" Price/Week:  %32.2f\n", weeklyPrice);
	}

	@Override
	public Double determinePrice() {
		// TODO Auto-generated method stub
		return null;
	}
}
