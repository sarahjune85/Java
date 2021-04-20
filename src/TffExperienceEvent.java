import java.util.Arrays; // deleet mee when done

// Subclass
public class TffExperienceEvent extends TffEvent {

	private int maxTickets;
	private int numBookings = 0;
	String[] bookings;

	public TffExperienceEvent(String title, String description, double adult, double child, double concession,
			int maxTickets) {
		super(title, description, adult, child, concession);
		this.maxTickets = maxTickets;
		this.bookings = new String[maxTickets];
	}

	public int getMaxTickets() {
		return maxTickets;
	}

	public int getNumBookings() {
		return numBookings;
	}

	public String[] getBookings() {
		return bookings;
	}

	public void setNumBookings(int numTickets) {
		numBookings += numTickets;
	}

	public void displayTickets() {
		//System.out.println(Arrays.toString(bookings));
		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] != null) {
				System.out.println(bookings[i]);
			}
		}
	}

	// search and return for booking names:
	public boolean refundName(String targetName) {
		for (int i = 0; i < getPurchasedTickets(); i++) {
			if ((this.bookings[i] != null) && (this.bookings[i].toLowerCase().contains(targetName.toLowerCase()))) {
				this.bookings[i] = null;
				purchasedTickets--;
				// You can move up the bookings in the array to cover a 'deleted' ticket if you
				// want - or even easier, just set that reference to null and ensure you are
				// checking for nulls whenever you want to find an empty spot for a new string,
				// or print out a string etc.
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
//			System.out.println("Printing.... " + msg);
//			System.out.printf("%s %30s\n", name, ticketType);
			System.out.println("Bookings for " + getTitle() + ":");
			for (int i = 0; i < maxTickets; i++) {
				if (bookings[i] == null) {
					bookings[i] = msg;
					break;
				}
			}
		} else {
			System.out.println("Error - sorry, no tickets remaining.");
			// Returns false if booking failed:
			return false;
		}
		// Returns true if the booking is performed.
		return true;
	}

	@Override
	public void displayEvent() {
		super.displayEvent();
		System.out.printf(" Max tickets:    %30d\n", maxTickets);
		System.out.println(" Bookings: " + numBookings);

		// array debugger view - delete me later:
		System.out.println(Arrays.toString(bookings));
		// deeleete meee

		displayTickets();
	}
}
