package clc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

interface Operation {
	String calculate(double a, double b);
}

public class ClcChange {
	static final Map<String, Operation> opByName = new HashMap<String, Operation>();

	// map 선언과 동시에 초기화
	static {
		opByName.put("+", new Operation() {
			public String calculate(double a, double b) { // 값을 더하고 String으로 리턴
				return Double.toString(a + b);
			}
		});
		opByName.put("-", new Operation() {
			public String calculate(double a, double b) {
				return Double.toString(a - b);
			}
		});
		opByName.put("*", new Operation() {
			public String calculate(double a, double b) {
				return Double.toString(a * b);
			}
		});
		opByName.put("/", new Operation() {
			public String calculate(double a, double b) {
				return Double.toString(a / b);
			}
		});
	}

	public String Stack(String str) {

		Stack<String> stack = new Stack<String>();
		String postfix = new String();
		
		if(str.equals("Incorrect data entry")){
			return "Incorrect data entry";
		}
		
		for (int i = 0; i < str.length(); i++) {
			Character cr = new Character(str.charAt(i));

			if (cr.toString().matches("(^[0-9]*$)") == true) { // 숫자인 경우
				stack.push(cr.toString());
			} else {
				int a = 0;
				if (stack.size() > 0) { // stack 사이즈가 0보다 클때
					double F = 0;
					double L = 0;
					while (stack.empty() == false) {

						if (a > 1) {
							break;
						} else if (a == 0) {
							F = Double.parseDouble(stack.pop());
						} else if (a == 1) {
							L = Double.parseDouble(stack.pop());
							if (F == 0) {
								System.out.println("문제 발생");
								break;
							}
							stack.push(opByName.get(cr.toString()).calculate(L, F)); // 산술연산
							F = 0;
							L = 0;
						}
						a++;
					}
				}
			}
		}

		System.out.println("stack 크기:" + stack.size());
		postfix = stack.pop();
		return postfix;
	}

	public String postfix(String str) {

		Stack<String> stack = new Stack<String>(); // 초기 post fix를 담을 stack
		String firstdata = Pattern.compile("\\s").matcher(str).replaceAll(""); // 공백제거
		String postfix = new String(); // 결과 값 리턴할 변수
		
		if(!firstdata.matches("^[0-9//(//)[+][*]/-]*$")) { // 입력 박은 값에 한글 영어 포함 여부 측정
			return "Incorrect data entry";
		}

		for (int i = 0; i < firstdata.length(); i++) { // scanner로 받아드린 String값을
														// char만큼 반복
			Character cr = new Character(firstdata.charAt(i)); // char 배열로 생성

			if (cr == ')' || i == firstdata.length() - 1) {
				stack.push(cr.toString());
				while (stack.empty() == false) {
					String popdata = stack.pop();
					if (popdata.equals("(") == false && popdata.equals(")") == false) {
						postfix += popdata;
					}
				}
			} else {
				if (cr.toString().matches("(^[0-9]*$)") == true) { // 숫자인 경우
					postfix += cr.toString();
				} else {
					stack.push(cr.toString());
				}
			}
		}

		return postfix;
	}
}
