package stack;

public class StackExcaption extends Exception {
	
	private static final long serialVersionUID = 1L;

	
	public StackExcaption(){
		super("Stack excption Occurs");
	}
	public StackExcaption(String string) {
		super(string);
	}
	
}
