// HiringException class - extends Exception class to create custom checked exception, for use in hire/return methods:

@SuppressWarnings("serial")
public class HiringException extends Exception {

	public HiringException(String message) {
		super(message);
	}
}
