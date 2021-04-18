
// Superclass
public class TffEvent {
	
	// protected allows subclasses (in this case, TffExperienceEvent) to directly
	// access variables, without a getter/setter.
	private String title;
	private String description;
	private double adult;
	private double child;
	private double concession;
	private int purchasedTickets = 0;

	// constructor
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

//	public String getDescription() {
//		return description;
//	}
	// do i need these?
//	public double getAdult() {
//		return adult;
//	}
//
//	public double getChild() {
//		return child;
//	}
//
//	public double getConcession() {
//		return concession;
//	}

	public int getPurchasedTickets() {
		return purchasedTickets;
	}
	
	public void setPurchasedTickets(int purchasedTickets) {
		this.purchasedTickets = purchasedTickets;
	}

	public void displayEvent() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("Event title:    %30s\n", title);
		System.out.printf("Description:    %30s\n", description);
		System.out.printf("Adult Price:    %30.2f\n", adult);
		System.out.printf("Child Price:    %30.2f\n", child);
		System.out.printf("Concession:     %30.2f\n", concession);
		System.out.printf("Total ticket sales:    %23d\n", purchasedTickets);
	}

	public boolean bookEvent(String ticketType, String name) {

		System.out.println(" ----------------------------------------------- ");
		System.out.printf("Event title:    %30s\n", title);
		System.out.printf("Name:           %30s\n", name);
		System.out.printf("Ticket type:    %30s\n", ticketType);
		
		 /* 
		 * This method should print ticket details and manipulate the count of tickets sold to
		 * indicate that a booking has occurred. The method returns true.
		 */

		// return true only
		purchasedTickets++;
		return true;
	}
	

//	// Looks at a single petObject[] index to print one pet's values to a String:
//	public String getPetArray(int index) {
//		int i = index;
//		String message = this.petObject[i].getName() + "," + this.petObject[i].getBreed() + ","
//				+ +this.petObject[i].getAge() + "," + this.petObject[i].getSex() + "," + this.petObject[i].getWeight()
//				+ "," + this.petObject[i].getDesexed() + "," + this.petObject[i].getLastVisit();
//		return message;
//	}
//
//	// public String to find one pet by name - offers a copy of the variables in
//	// backEnd without relinquishing control to the other classes:
//	public String getPetSummary(String petName) {
//		String searchResult = null;
//		int foundIndex = getPetName(petName);
//		if (foundIndex >= 0) {
//			searchResult = "" + this.petObject[foundIndex].toString();
//		}
//		return searchResult;
//	}

}
