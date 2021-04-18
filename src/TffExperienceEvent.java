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

	public void refundBooking(String name) {

		
		
		
	}
	
	@Override
	public boolean bookEvent(String ticketType, String name) {		
		//
		// IT WORKS  - LEAVE IT
		if ((maxTickets - getPurchasedTickets()) > 0) {
			super.bookEvent(ticketType, name);
			String msg = " ";
			msg += name;
			msg += ", ";
			msg += ticketType;
			System.out.println("Printing.... " + msg);
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
		System.out.printf("Max tickets:    %30d\n", maxTickets);
		System.out.println("Bookings: " + numBookings);
		
		// array debugger view - delete me later:
		System.out.println(Arrays.toString(bookings));
		// deeleete meee

		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] != null) {
				System.out.println(bookings[i]);
			}
		}
	}
}
