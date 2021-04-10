// This will be like "PetObject" from ITP assignment 3

// Superclass
public class TffEvent {

	private String title;
	private String description;
	private double adult;
	private double child;
	private double concession;
	private int counter;

	// constructor
	public TffEvent(String title, String description, double adult, double child, double concession)
	   {
	      this.title = title;
	      this.description = description;
	      this.adult = adult;
	      this.child = child;
	      this.concession = concession;	     
	   }

	public void displayEvent() {
		System.out.printf("Event title:   %s\n", title);
		System.out.printf("Description:    %s\n", description);
		System.out.printf("Adult Price:    %.2f\n", adult);
		System.out.printf("Child Price:    %.2f\n", child);
		System.out.printf("Concession:    %.2f\n", concession);
		System.out.printf("Total ticket sales:    %d\n", counter);
	}

	public boolean bookEvent(String ticketType, String name) {

		/*
		 * where ticketType indicates the type of the ticket being booked (“Adult”,
		 * “Child” or “Concession”), and name is the name of the attendee. This method
		 * should print ticket details and manipulate the count of tickets sold to
		 * indicate that a booking has occurred. The method returns true
		 */

		return true;
	}

}
