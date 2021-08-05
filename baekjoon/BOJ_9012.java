package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 9012. 괄호 - swea 1218과 유사 
 * 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다. 
 */
public class BOJ_9012 {

	static String answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // testcase
		for (int tc = 1; tc <= N; tc++) {
			
			String input = br.readLine();
			char[] arr = input.toCharArray();
			
			Stack<String> s = new Stack<String>();
			
			boolean checked = false;
			if(arr.length % 2 == 1) {
				checked = true;
			} else {

				for(int i=0; i<arr.length; i++) {
					String temp = String.valueOf(arr[i]);
					
					if(arr[i] == '(') {
						s.push(temp);
					} else if(arr[i] == ')') {
						if (s.isEmpty() || !(s.peek().equals("("))) {
							checked = true;
							break;
						}
						s.pop();
					} 
					
				}
			}
			
			if(s.isEmpty() && !checked) {
				answer = "YES";
			} else {
				answer = "NO";
			}
			
			System.out.println(answer);
		}
	}
}
