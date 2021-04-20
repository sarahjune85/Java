// Superclass
public class TffEvent {

	// protected allows subclass (TffExperienceEvent) to directly
	// access variables, without a getter/setter.
	private String title;
	private String description;
	protected double adult;
	protected double child;
	protected double concession;
	protected int purchasedTickets = 0;

	// constructor for TffEvent:
	public TffEvent(String title, String description, double adult, double child, double concession) {
		this.title = title;
		this.description = description;
		this.adult = adult;
		this.child = child;
		this.concession = concession;
	}

	public String getTitle() {
		return title;
	}

	public int getPurchasedTickets() {
		return purchasedTickets;
	}

	public void displayEvent() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf(" Event title:  %32s\n", title);
		System.out.printf(" Description:  %32s\n", description);
		System.out.printf(" Adult Price:    %30.2f\n", adult);
		System.out.printf(" Child Price:    %30.2f\n", child);
		System.out.printf(" Concession:     %30.2f\n", concession);
		System.out.printf(" Total ticket sales:    %23d\n", purchasedTickets);
	}

	public boolean bookEvent(String ticketType, String name) {
		// Prints ticket details and increments the count of tickets
		// sold to indicate that a booking has occurred:
		System.out.println(" Printing ticket......");
		System.out.println("+-------------------------------------------------+");
		System.out.println("|------------- T F F Events Presents -------------|");
		System.out.println("+-------------------------------------------------+");
		System.out.printf("| Event: %40s |\n", title);
		System.out.println("+-------------------------------------------------+");
		System.out.printf("| Name:           %31s |\n", name);
		System.out.printf("| Ticket type:    %31s |\n", ticketType);
		switch (ticketType) {
		case "Adult":
			System.out.printf("| Price:   %32s%6.2f |\n", "$", adult);
			break;
		case "Child":
			System.out.printf("| Price:   %32s%6.2f |\n", "$", child);
			break;
		case "Concession":
			System.out.printf("| Price:   %32s%6.2f |\n", "$", concession);
			break;
		}
		System.out.println("+-------------------------------------------------+");
		// return true only as we have no ticket limits:
		purchasedTickets++;
		return true;
	}
}
