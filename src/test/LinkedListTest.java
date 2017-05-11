package test;

import list.LinkedList;
import list.List;

public class LinkedListTest {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<Integer>();

		list.add(11);
		list.add(22);
		list.add(22);
		list.add(22);
		list.add(22);
		list.add(45);
		list.add(56);

		int count = list.size();
		System.out.println("리스트 크기:" + count);

		for (int i = 0; i < count; i++) {
			System.out.println(i + "번째 항목:" + list.get(i));
		}

		System.out.println("");

		list.add(2, 12);
		
		count = list.size();
		System.out.println("리스트 크기:" + count);
		for (int i = 0; i < count; i++) {
			System.out.println(i + "번째 항목:" + list.get(i));
		}
		
		System.out.println("");
		
		System.out.println("삭제한값:"+list.remove(4));
		
		count = list.size();
		System.out.println("리스트 크기:" + count);
		for (int i = 0; i < count; i++) {
			System.out.println(i + "번째 항목:" + list.get(i));
		}

	}

}
