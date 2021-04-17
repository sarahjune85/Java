import java.util.Arrays;

// Subclass
public class TffExperienceEvent extends TffEvent {

	private int maxTickets;
	private int numBookings;
	String[] bookings; // Class TffExperienceEvent must utilise a 1D String array instance
						// variable, called bookings, to store
	// booking details (i.e. the name list of ticket holder name and price paid).

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
		System.out.println(Arrays.toString(bookings));
		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] != null) {
				System.out.println(bookings[i]);
			}
		}
	}

	// search and return for booking names:
//	public int getPetName(String targetName) {
//		int foundPetIndex = -1;
//		int i = 0;
//
//		while (i < this.currentRecord && !this.petObject[i].getName().equalsIgnoreCase(targetName))
//			i++;
//
//		if (i < this.currentRecord)
//			foundPetIndex = i;
//
//		return foundPetIndex;
//	}
//

	@Override
	public boolean bookEvent(String ticketType, String name) {
		super.bookEvent(ticketType, name);
		// bookings = new String[getPurchasedTickets()];
		String msg = " ";
		msg += name;
		msg += ", ";
		msg += ticketType;
		System.out.println("Printing.... " + msg);
//		while ((numBookings + getPurchasedTickets()) < maxTickets) {
		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] == null) {
				bookings[i] = msg;
				break;
			} else if ((numBookings + getPurchasedTickets()) == maxTickets) {
				System.out.println("Error - maximum tickets sold.");
				return false;
			}
		}

		// This method should make appropriate use of the super construct. The method
		// should return true if a
		// booking was successfully performed, and false if a booking couldn’t be
		// successfully completed.
		return true;
	}

	public void refundBooking(String name) {

	}

	@Override
	public void displayEvent() {
		super.displayEvent();
		System.out.printf("Max tickets:    %30d\n", maxTickets);
		System.out.println("Bookings: " + numBookings);
		// array debugger view - delete me later:
		System.out.println(Arrays.toString(bookings));

		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] != null) {
				System.out.println(bookings[i]);
			}
		}
	}

}
