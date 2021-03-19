import java.util.*;

class Coach {
	private String destination;
	private double standard;
	private double pensioner;
	private double frequent;
	private double totalBalance = 0;
	private int totalSeats;
	private char[] seats = new char[totalSeats];

	public Coach(String destination, double standard, double pensioner, double frequent) {
		this.destination = destination;
		this.standard = standard;
		this.pensioner = pensioner;
		this.frequent = frequent;
	}

	public void buyStandard(int number) {
		this.totalBalance = (standard * number) + totalBalance;
	}

	public void buyPensioner(int number) {
		this.totalBalance = (pensioner * number) + totalBalance;
	}

	public void buyFrequent(int number) {
		this.totalBalance = (frequent * number) + totalBalance;
	}

	// Get total bus ticket tally
	public double getBalance() {
		return totalBalance;
	}

	public void setPensioner(double pensioner) {
		this.pensioner = pensioner;
	}

	// Get/Set seats:
	public void setSeats(int seats) {
		this.totalSeats = seats;
	}

	public void printDetails() {
		System.out.println();
		System.out.printf("+--------------Coach to %s-------------+\n", destination);
		System.out.printf("%-10s%d\n", "Total seats: ", totalSeats);
		System.out.printf("%-10s$%.2f\n", "Standard Ticket: ", standard);
		System.out.printf("%-10s$%.2f\n", "Pensioner: ", pensioner);
		System.out.printf("%-10s$%.2f\n", "Frequent: ", frequent);
		System.out.println();
	}

	public void displayReceipt() {
		System.out.println("Receipt");
		System.out.println("*******");
		System.out.printf("Destination: %s", destination);
		System.out.println("Number of seats booked : x ");
		System.out.printf("xx * Standard @ $xx.xx = $ xx.xx ");
		System.out.printf("xx * Pensioner @ $xx.xx = $ xx.xx ");
		System.out.printf("xx * Frequent @ $xx.xx = $ xx.xx ");
		System.out.println(" ------ ");
		System.out.println("Total : $xxx.xx ");
	}

}