package clc;

import java.util.Scanner;

public class calculater {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		ClcChange cl = new ClcChange();
		System.out.println("계산기 시작 값을 입력하세요~!");
		System.out.print("==>");

		while (sc.hasNext()) {
			String input = sc.nextLine();
			if (input.equals("exit")) {
				System.out.println("계산기 종료.");
				break;
			} else {
				String postfix = cl.postfix(input);
				System.out.println("postfix 값:" + postfix);
				System.out.println("결과:" + cl.Stack(postfix));
				System.out.println("------------------------------------------------");
				System.out.print("==>");
			}
		}

	}

}
