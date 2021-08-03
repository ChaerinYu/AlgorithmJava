package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 17413. 단어 뒤집기 2
 * 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
 * 태그는 ('<'로 시작해서 '>'로 끝남) 그대로 유지
 */
public class BJ_17413 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> st = new Stack<String>();
		
		
		String input = reader.readLine();

		boolean isTag = false;
		
		// '<' 찾기
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '<') {

				// stack 출력 - 최초 < 전 단어 
				while(!st.isEmpty()) {
					System.out.print(st.peek());
					st.pop();
				}
				
				isTag = true;
			}
			if(isTag) {
				System.out.print(input.charAt(i));
				if(input.charAt(i) == '>') isTag=false;
			} else {
				if(input.charAt(i) == ' ') {
					
					// stack 출력
					while(!st.isEmpty()) {
						System.out.print(st.peek());
						st.pop();
					}
					
					System.out.print(input.charAt(i)); // ' '
				} else {
					st.push(String.valueOf(input.charAt(i)));
				}
			}
		}

		// stack 출력 - (tag아닌) 마지막 단어  
		while(!st.isEmpty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}

}
