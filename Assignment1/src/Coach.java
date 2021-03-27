import java.util.*;

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

	public void setDestination(String destination) {
		this.destination = destination;
	}

	// Sets the total number of coach seats depending on the number of rows entered:
	public void setTotalSeats(int seatRows) {
		this.totalSeats = seatRows * 4;
	}

//	public int getTotalSeats() {
//		return totalSeats;
//	} defunct, using seats[].length
	
	// Returns seats array values:
	public char[] getSeats() {
		return seats;
	}

	// Refund seat method - takes an int value for a specific seat, checks whether
	// it is an S, P or F and updates the counters/values from there:
	public void refundSeat(int seatNum) {
		if ((this.seats[seatNum - 1] == 's') || ((this.seats[seatNum - 1] == 'S'))) {
			System.out.println("Refunding Standard seat...");
			this.seats[seatNum - 1] = '-';
			this.purchasedStandard--;
			this.purchasedSeats--;
		} else if ((this.seats[seatNum - 1] == 'p') || ((this.seats[seatNum - 1] == 'P'))) {
			System.out.println("Refunding Pensioner seat...");
			this.seats[seatNum - 1] = '-';
			this.purchasedPensioner--;
			this.purchasedSeats--;
		} else if ((this.seats[seatNum - 1] == 'f') || ((this.seats[seatNum - 1] == 'F'))) {
			System.out.println("Refunding Frequent seat...");
			this.seats[seatNum - 1] = '-';
			this.purchasedFrequent--;
			this.purchasedSeats--;
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

	//Getters for ticket prices:
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

	//Getters & setters for number of each ticket type sold:
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