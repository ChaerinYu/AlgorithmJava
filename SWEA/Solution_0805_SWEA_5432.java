package SWEA;

import java.util.Scanner;
import java.util.Stack;
/*
 * 5432. 쇠막대기 자르기
 */
public class Solution_0805_SWEA_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			int res = 0;
			String s = sc.next();
			s = s.replace("()", "$"); // 레이저 문자열 변환
			char[] crr = s.toCharArray();
			
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < crr.length; i++) {
				switch(crr[i]) {
				case '(': // 쇠막대기의 시작
					stack.push('(');
					break;
				case '$': // laser
					res += stack.size();
					break;
				case ')': // 쇠막대기의 마지막. 최상위 막대기 하나 잘려나감 (아래 막대기는 모름)
					res += 1;
					stack.pop();
					break;
				default:
					break;
				}
			}
			System.out.println("#"+t+" "+res);
		}
		
	}

}
