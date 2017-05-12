package stack;

public class StackTest {

	public static void main(String[] args) {
		try {

			stack<String> stack = new stack<String>();
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.empty() == false) {
				String s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new stack<String>();
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());
			
		} catch (StackExcaption e) {
			e.printStackTrace();
		}

	}

}
