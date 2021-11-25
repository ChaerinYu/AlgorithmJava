package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 2021.11.25
 * 4949. 균형잡힌 세상
 * @author Chaerin Yu
 *
 */
public class BOJ_4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			char[] arr = br.readLine().toCharArray();
			// 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
			if(arr.length==1 && arr[0]=='.') break;
			
			Stack<Character> stack = new Stack<Character>();
			boolean flag = false;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]=='[') {
					stack.push('[');
				} else if(arr[i]==']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						flag = true;
						break;
					}
				} else if(arr[i]=='(') {
					stack.push('(');
				} else if(arr[i]==')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						flag = true;
						break;
					}
				}
			}
			// stack size가 0 이상인 경우-> 짝이 없는 경우 ex) [ab
			if(!flag && stack.size() == 0) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
			
		}
		System.out.print(sb.toString());
	}
}
