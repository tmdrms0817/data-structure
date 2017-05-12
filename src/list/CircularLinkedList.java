package list;

public class CircularLinkedList<E> implements List<E> {
	private int size = 0;
	private Node<E> tail = null;
	private Node<E> pos = null;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);

		if (tail == null) {
			tail = newNode.next = newNode;
		} else {
			newNode.next = tail.next; // head
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		if( size < index || index < 0 ) {
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		}
		 
		if (index == 0) {
			final Node<E> newNode = new Node<E>( element, tail.next );
			tail.next = newNode;
		} else {
			Node<E> x = tail; // head
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			final Node<E> newNode = new Node<E>( element, x.next );
			x.next = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		if (size <= index) {
			throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
		}

		Node<E> x = tail.next; // head
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next; // head로 이동

		while (x != tail) {
			Node<E> next = x.next;

			x.next = null;
			x = next;
		}

		tail.next = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		if (tail == null) {
			return arr;
		}

		int index = 0;
		Node<E> x = tail.next;
		while (true) {
			arr[index++] = x.data;
			x = x.next;
			if (x == tail.next) { // 다시 head로 이동됨
				break;
			}
		}

		return arr;
	}

	public E next() {
		return null;
	}

	private static class Node<E> {
		private Node<E> next;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}