
// Subclass
public class TffExperienceEvent extends TffEvent {

	private int maxTickets;
	String[] bookings;

	// constructor for TffExperienceEvent - extends TffEvent:
	public TffExperienceEvent(String title, String description, double adult, double child, double concession,
			int maxTickets) {
		super(title, description, adult, child, concession);
		this.maxTickets = maxTickets;
		this.bookings = new String[maxTickets];
	}

	public int getMaxTickets() {
		return maxTickets;
	}

	public String[] getBookings() {
		return bookings;
	}

	// Displays attendee names, ticket types, and price paid:
	public void displayTickets() {
		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] != null) {
				// Split the bookings[i] String to format as required:
				String[] toTable = bookings[i].split(",");
				System.out.format("%-20s %15s", toTable[0], toTable[1]);
				if (toTable[1].contains("Adult")) {
					System.out.printf("%4s%7.2f\n", "$", adult);
				} else if (toTable[1].contains("Child")) {
					System.out.printf("%4s%7.2f\n", "$", child);
				} else if (toTable[1].contains("Concession")) {
					System.out.printf("%4s%7.2f\n", "$", concession);
				}
			}
		}
	}

	// search and return for booking names:
	public boolean refundName(String targetName) {
		for (int i = 0; i < getPurchasedTickets(); i++) {
			if ((this.bookings[i] != null) && (this.bookings[i].toLowerCase().contains(targetName.toLowerCase()))) {
				// Set reference of i to null to remove that booking:
				this.bookings[i] = null;
				// Decrement purchasedTickets:
				purchasedTickets--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean bookEvent(String ticketType, String name) {
		if ((maxTickets - getPurchasedTickets()) > 0) {
			// Calls method from superclass:
			super.bookEvent(ticketType, name);
			String msg = " ";
			msg += name;
			msg += ", ";
			msg += ticketType;
			System.out.println();
			System.out.println("All bookings for " + getTitle() + ":");
			System.out.println();
			for (int i = 0; i < maxTickets; i++) {
				if (bookings[i] == null) {
					bookings[i] = msg;
					break;
				}
			}
		} else {
			System.out.println("Error - sorry, no tickets remaining for " + getTitle());
			// Returns false if booking failed:
			return false;
		}
		// Returns true if the booking is performed.
		return true;
	}

	@Override
	public void displayEvent() {
		// Calls method from superclass:
		super.displayEvent();
		// Adds extra details for TffExperienceEvent only:
		System.out.printf(" Max tickets:    %30d\n", maxTickets);
		System.out.println(" ------");
		System.out.println(" Guest list: ");
		System.out.println(" ------");
		displayTickets();
		System.out.println();
	}
}
