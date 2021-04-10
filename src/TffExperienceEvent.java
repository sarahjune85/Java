
// Subclass
public class TffExperienceEvent extends TffEvent {

	private int totalTickets;
	private int numBookings = 0;
	String[] bookings = new String[numBookings]; // Class TffExperienceEvent must utilise a 1D String array instance
												// variable, called bookings, to store
	// booking details (i.e. the name list of ticket holder name and price paid).

	public TffExperienceEvent(String title, String description, double adult, double child, double concession) {
		super(title, description, adult, child, concession);
		this.bookings = bookings;
	}

	@Override
	public boolean bookEvent(String ticketType, String name) {
		super.bookEvent(ticketType, name);
		// This method should make appropriate use of the super construct. The method
		// should return true if a
		// booking was successfully performed, and false if a booking couldn’t be
		// successfully completed.
		return true;
	}

	@Override
	public void displayEvent() {
		super.displayEvent();
		System.out.printf("Max tickets:    %d\n", totalTickets);
		System.out.println("Bookings");
		//bookings array to string goes here);
	}

}
