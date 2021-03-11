import java.util.*;

public class Validate {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int mark;
		do {
			System.out.print("Enter mark [0-100]: ");
			mark = sc.nextInt();
			if (mark < 0 || mark > 100)
				System.out.print("Invalid – Reenter.");
		} while (mark < 0 || mark > 100);
		if (mark >= 50)
			System.out.print("Pass");
		else
			System.out.print("Fail");

		sc.close();
	}
}
