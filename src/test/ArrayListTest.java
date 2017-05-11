package test;

import list.ArrayList;
import list.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
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
			System.out.println(i+"번째 항목:"+list.get(i));
		}
		
		//list.removeAll();
		
//		count = list.size();
//		
//		System.out.println("리스트 크기:"+ count);
//		
//		try {
//			list.get(0); // 의미적으로 보면 ㅂ퍼는 안지운거다. - 0으로 접근 못하게 만들어야 한다. - 없는 배열에 접근시 exception을 내야한다.
//		} catch (IndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		
		list.remove(7);
		
		System.out.println("");
		count = list.size();
		System.out.println("리스트 크기:" + count);
		
		for (int i = 0; i < count; i++) {
			System.out.println(i+"번째 항목:"+list.get(i));
		}
		
		for (int i = 0; i < args.length; i++) {
			
		}

	}

}
