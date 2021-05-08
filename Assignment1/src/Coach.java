/* CPT121 / COSC2135 Programming 1 - Assignment 1
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * 
 * DCA Coach Booking System - Coach class: 
 * This class stores the information for the coach, including price and # of tickets purchased. 
 * It contains the getter & setter methods to feed StageC and allows StageC to update values.
 * 
 */
class Coach {
	private String destination;
	private double standard;
	private double pensioner;
	private double frequent;
	private int purchasedSeats = 0;
	private int purchasedStandard = 0;
	private int purchasedPensioner = 0;
	private int purchasedFrequent = 0;
	private int totalSeats;
	private char[] seats;

	// Getter & setter for destination string:
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	// Sets the total number of coach seats depending on the number of rows entered:
	public void setTotalSeats(int seatRows) {
		this.totalSeats = seatRows * 4;
	}

	// Returns seats[] array values to StageC:
	public char[] getSeats() {
		return seats;
	}

	// Refund seat method - takes an int value for a specific seat, checks whether
	// it is an S, P or F at that index - 1, and updates the value to - (vacant). If
	// seat has no letter at that index, does not refund.
	public void refundSeat(int seatNum) {
		if ((this.seats[seatNum - 1] == 's') || ((this.seats[seatNum - 1] == 'S'))) {
			System.out.println("Refunding Standard seat...");
			this.seats[seatNum - 1] = '-';
		} else if ((this.seats[seatNum - 1] == 'p') || ((this.seats[seatNum - 1] == 'P'))) {
			System.out.println("Refunding Pensioner seat...");
			this.seats[seatNum - 1] = '-';
		} else if ((this.seats[seatNum - 1] == 'f') || ((this.seats[seatNum - 1] == 'F'))) {
			System.out.println("Refunding Frequent seat...");
			this.seats[seatNum - 1] = '-';
		} else {
			System.out.println("Seat not booked, no refund applicable.");
		}
	}

	// Fills the seat array with - (unbooked indicator) on startup:
	public void fillSeats() {
		seats = new char[totalSeats];
		for (int i = 0; i < seats.length; i++)
			seats[i] = '-';
	}

	// Getters for ticket prices:
	public double getStandard() {
		return standard;
	}

	public double getPensioner() {
		return pensioner;
	}

	public double getFrequent() {
		return frequent;
	}

	// Setters for ticket prices, entered on startup:
	public void setStandard(double standard) {
		this.standard = standard;
	}

	public void setPensioner(double pensioner) {
		this.pensioner = pensioner;
	}

	public void setFrequent(double frequent) {
		this.frequent = frequent;
	}

	// Getters & setters for number of each ticket type sold:
	public int getPurchasedStandard() {
		return purchasedStandard;
	}

	public void setPurchasedStandard(int purchasedStandard) {
		this.purchasedStandard = purchasedStandard;
	}

	public int getPurchasedPensioner() {
		return purchasedPensioner;
	}

	public void setPurchasedPensioner(int purchasedPensioner) {
		this.purchasedPensioner = purchasedPensioner;
	}

	public int getPurchasedFrequent() {
		return purchasedFrequent;
	}

	public void setPurchasedFrequent(int purchasedFrequent) {
		this.purchasedFrequent = purchasedFrequent;
	}

	// Getter & setter for all seats in total:
	public int getPurchasedSeats() {
		return purchasedSeats;
	}

	public void setPurchasedSeats(int purchasedSeats) {
		this.purchasedSeats = purchasedSeats;
	}
}