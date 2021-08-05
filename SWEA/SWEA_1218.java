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
public class SWEA_1218 {
	
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 문자열 길이
			
			String input = br.readLine();
			char[] arr = input.toCharArray();
			
			Stack<String> s1 = new Stack<String>();
			Stack<String> s2 = new Stack<String>();
			Stack<String> s3 = new Stack<String>();
			Stack<String> s4 = new Stack<String>();
			
			for(int i=0; i<arr.length; i++) {
				String temp = String.valueOf(arr[i]);
				
				if(arr[i] == '(') {
					s1.push(temp);
				} else if(arr[i] == '[') {
					s2.push(temp);
				} else if(arr[i] == '{') {
					s3.push(temp);
				} else if(arr[i] == '<') {
					s4.push(temp);
				} else if(arr[i] == ')') {
					if(s1.isEmpty()) break;
					s1.pop();
				} else if(arr[i] == ']') {
					if(s2.isEmpty()) break;
					s2.pop();
				} else if(arr[i] == '}') {
					if(s3.isEmpty()) break;
					s3.pop();
				} else if(arr[i] == '>') {
					if(s4.isEmpty()) break;
					s4.pop();
				}
				
			}
			
			if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty() && s4.isEmpty()) {
				answer = 1;
			} else {
				answer = 0;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}
