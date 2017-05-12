package stack;

public class stack<E> extends ArrayList<E> {

	public void push(E item) {	
	add(item);
	}
	
	public E pop() throws StackExcaption {
		
		if(empty()){
			throw new StackExcaption("stack is empty");
		}
		return remove(size() -1);
	}
	
	public E peek() {
		return get(size() -1);
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
}
