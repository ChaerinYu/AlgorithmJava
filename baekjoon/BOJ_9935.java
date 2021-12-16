package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 9935. 문자열 폭발
 * Study 15week
 * @author Chaerin Yu
 * 89144KB 588ms..?
 * stack 사용
 */
public class BOJ_9935 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		String bomb = br.readLine();
		int idx = bomb.length()-1; // 마지막 글자부터 비교해준다.
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
			if(stack.peek() == bomb.charAt(idx)) {
				Stack<Character> tempStack = new Stack<Character>();
				tempStack.push(stack.pop());
				while(idx > 0) {
					idx--;
					if(stack.isEmpty() || stack.peek() != bomb.charAt(idx)) {
						// stack이 비어있거나 다른 단어인 경우 다시 stack에 넣기
						while(!tempStack.isEmpty()) {
							stack.push(tempStack.pop());
						}
						break;
					}
					else {
						// 단어 겹치는 경우 tempStack에 push
						tempStack.push(stack.pop());
					}
				}
				// idx 초기화
				idx = bomb.length()-1;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		if(sb.length()>0) System.out.println(sb.reverse().toString());
		else System.out.println("FRULA");
	}

}
