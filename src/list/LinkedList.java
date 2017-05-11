package list;

public class LinkedList<E> implements List<E> {

	private int size;
	private Node<E> head = null;

	@Override
	public void add(E element) {

		Node<E> newNode = new Node<E>(element);

		if (head == null) {
			head = newNode;
		} else {
			Node<E> x = head;
			while (x.next != null) {
				x = x.next;
			}

			x.next = newNode;
		}
		size++;

	}

	@Override
	public void add(int index, E element) {

		if (index > size) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
		}
		if (head == null) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
		} else {
			Node<E> x = head;

			if (index == 1) {
				Node<E> newNode = new Node<E>(element, x);
				head = newNode;
			} else {
				int a = 1;
				while (x.next != null) {
					if (a == index - 1) {
						break;
					}
					x = x.next;
					a++;
				}
				Node<E> newNode = new Node<E>(element, x.next);
				x.next = newNode;
			}
		}
		size++;
	}

	@Override
	public E get(int index) {

		if (size <= index) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
		}

		Node<E> x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		return x.data;
	}

	@Override
	public E remove(int index) {
		E removedata = null;
		if (index > size) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
		}
		if (head == null) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
		} else {
			if(index == 1){
				removedata = head.data;
				head = head.next;
			}else{
				Node<E> old = node(index-2); // 포지션의 이전 노드를 구해옴.
				Node<E> current = old.next; // 이전노드의 link는 현재 포지션의 노드이므로, 임시 저장한다.
				removedata = old.next.data; // 삭제하면서 반환될 임시 데이터
				old.next = current.next; // 이전노드의 link는 현재노드의 link로 지정한다.

				current = null; // help gc
			}

		}
		size--;

		return removedata;

	}

	@Override
	public void removeAll() {
		for (Node<E> x = head; x != null;) {
			Node<E> next = x.next;

			x.data = null;
			x.next = null;

			x = next;
		}

		head = null;
		size = 0;
	}

	@Override
	public int size() {

		return size;
	}

	private Node<E> node(int index) {
		Node<E> temp = head; // head 노드를 임시로 저장

		// index 만큼 돌면서 포지션의 Node에 접근하여 해당 노드 리턴
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/*
	 * 내부 클래스를 만들었는데 여기서 외부글 접근해야 하는 경우 인스턴스 형식으로 만든다 non static 이게 아니고 밖의 클래서
	 * 같이 쓰고 싶은경우 static을 주어야 한다.
	 */
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

}
