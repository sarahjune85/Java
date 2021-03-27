import java.util.*;

class Coach {
	private String destination;

	private double standard;
	private double pensioner;
	private double frequent;
	private double totalBalance; //

	private int purchasedSeats = 0;
	private int purchasedStandard = 0;
	private int purchasedPensioner = 0;
	private int purchasedFrequent = 0;

	private int totalSeats;
	private char[] seats;

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTotalSeats(int seatRows) {
		this.totalSeats = seatRows * 4;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public char[] getSeats() {
		return seats;
	}
	

	// Refund seat method - takes an int value for a specific seat, checks whether
	// it is an S, P or F and refunds from there:
	public void refundSeat(int seatNum) {		
		if ((this.seats[seatNum - 1] == 's') || ((this.seats[seatNum - 1] == 'S'))) {
			System.out.println("Refunding Standard seat.");
			this.seats[seatNum -1] = '-';
			this.purchasedStandard--;
			this.purchasedSeats--;
		} else if ((this.seats[seatNum - 1] == 'p') || ((this.seats[seatNum - 1] == 'P'))) {
			System.out.println("Refunding Pensioner seat.");
			this.seats[seatNum -1] = '-';
			this.purchasedPensioner--;
			this.purchasedSeats--;
		} else if ((this.seats[seatNum - 1] == 'f') || ((this.seats[seatNum - 1] == 'F'))) {
			System.out.println("Refunding Frequent seat.");
			this.seats[seatNum -1] = '-';
			this.purchasedFrequent--;
			this.purchasedSeats--;
		} else {
			System.out.println("Seat not booked, no refund applicable.");
		}	
		
	}

	public void fillSeats() {
		seats = new char[totalSeats];
		Arrays.fill(seats, '-');
	}

	public double getBalance() {
		return totalBalance;
	}

	public double getStandard() {
		return standard;
	}

	public double getPensioner() {
		return pensioner;
	}

	public double getFrequent() {
		return frequent;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setStandard(double standard) {
		this.standard = standard;
	}

	public void setPensioner(double pensioner) {
		this.pensioner = pensioner;
	}

	public void setFrequent(double frequent) {
		this.frequent = frequent;
	}

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

	public int getPurchasedSeats() {
		return purchasedSeats;
	}

	public void setPurchasedSeats(int purchasedSeats) {
		this.purchasedSeats = purchasedSeats;
	}

}