import java.util.*;

class Coach {
	private String destination;
	private double standard;
	private double pensioner;
	private double frequent;
	private int totalSeats;
	private char[] seats;
	private double totalBalance;
	double grandTotal;

	public Coach() {

	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTotalSeats(int seatRows) {
		this.totalSeats = seatRows * 4;
	}

	public int getAllSeats() {
		return totalSeats;
	}

	public char[] getSeats() {
		return seats;
	}

	public void setSeat(int data, char value) {
		while ((this.seats[data - 1] == 'S') || (this.seats[data - 1] == 'P') || (this.seats[data - 1] == 'F')) {
			System.out.println("Seat already booked - please choose another: ");
			Scanner in = new Scanner(System.in);
			data = Integer.parseInt(in.nextLine());
		}
		this.seats[data - 1] = value;		
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

	public void setStandard(double standard) {
		this.standard = standard;
	}

	public void setPensioner(double pensioner) {
		this.pensioner = pensioner;
	}

	public void setFrequent(double frequent) {
		this.frequent = frequent;
	}

}