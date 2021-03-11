import java.util.*;

// broken - don't get it?
public class TestWhile {
	public static void main(String[] args) {
		int num, sum = 0;
		Scanner console = new Scanner(System.in);
		System.out.print("Enter numbers to sum. ");
		System.out.print("Enter -ve number to terminate ");
		num = console.nextInt();
		do {
			sum += num;
		} while (num >= 0);

		if (num <= 0) {
			System.out.println("Sum of all +ve numbers = " + sum);
		}
	}
}