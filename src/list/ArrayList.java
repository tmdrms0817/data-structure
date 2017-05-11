package list;

public class ArrayList<E> implements List<E> {

	private static final int INIT_CAPACITY = 10;
	private int size;
	private E[] data;

	public ArrayList() {
		size = 0;
		resize();
	}

	@SuppressWarnings("unchecked")
	private void resize() { // 2배로 리사이즈 모든 데이터를 늘리는 것들을 담당

		int capacity = (data == null) ? INIT_CAPACITY : data.length * 2; // 초기
																			// 선언시
		E[] temp = (E[]) new Object[capacity * 2];

		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}

		data = temp;
	}

	@Override
	public void add(E element) {
		if (data.length <= size) {
			resize();
		}

		data[size] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, E element) {
		if (data.length <= size) {
			resize();
		}
		E[] temp = (E[]) new Object[size+1];
		
		for (int i = 0; i <= size; i++) {
			if(i<index){
				temp[i] = data[i];
			}else if(i == index){
				temp[i] = element;
			}else if(i > index){
				temp[i] = data[i-1];
			}
		}
		
		data = temp;
		size++;

	}

	@Override
	public E get(int index) {
		if(index == size){
			throw new IndexOutOfBoundsException("index:"+ index + ",size:" + size); // 이건 checked exception이 아니기에 메소드에 throws를 적을 필요가 없다.
		}
		return data[index];
	}

	@Override
	public E remove(int index) {
		
		E[] temp = (E[]) new Object[size];
		
		for (int i = 0; i < size; i++) {
			if(i<index-1){
				temp[i] = data[i];
			}else{
				temp[i] = data[i+1];
			}
		}
		
		data = temp;
		
		size--;
		
		return null;
	}

	@Override
	public void removeAll() {
		
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		
		size = 0;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
