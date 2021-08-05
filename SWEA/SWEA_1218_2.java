package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * [D4] 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
 * 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열
 * 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음).
 */
public class SWEA_1218_2 {
	
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 문자열 길이

			String input = br.readLine();
			char[] arr = input.toCharArray();
			
			Stack<String> s = new Stack<String>();
			
			boolean checked = false;
			if(arr.length % 2 == 1) {
				checked = true;
			} else {

				for(int i=0; i<arr.length; i++) {
					String temp = String.valueOf(arr[i]);
					
					if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<') {
						s.push(temp);
					} else if(arr[i] == ')') {
						if (s.isEmpty() || !(s.peek().equals("("))) {
							checked = true;
							break;
						}
						s.pop();
					} else if(arr[i] == ']') {
						if (s.isEmpty() || !(s.peek().equals("["))) {
							checked = true;
							break;
						}
						s.pop();
					} else if(arr[i] == '}') {
						if (s.isEmpty() || !(s.peek().equals("{"))) {
							checked = true;
							break;
						}
						s.pop();
					} else if(arr[i] == '>') {
						if (s.isEmpty() || !(s.peek().equals("<"))) {
							checked = true;
							break;
						}
						s.pop();
					}
					
				}
			}
			
			if(s.isEmpty() && !checked) {
				answer = 1;
			} else {
				answer = 0;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}
