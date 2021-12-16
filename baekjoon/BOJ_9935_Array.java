package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 9935. 문자열 폭발
 * Study 15week
 * @author Chaerin Yu
 * 30348kb 244ms
 * Array 사용
 */
public class BOJ_9935_Array {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray(); // 문자열
		String bomb = br.readLine(); // 폭탄
		int idx = 0, len = bomb.length();
		char[] stack = new char[arr.length]; // stack 역할
		
		// Stack 이용한 풀이와 동일하게 bomb 뒷글자부터 체크한다.
		for (int i = 0; i < arr.length; i++) {
			stack[idx] = arr[i]; // 문자열을 stack에 입력
			boolean isBomb = true;
			// 만약 문자열이 폭탄문자보다 작은 경우 또는 stack과 bomb문자 다른경우
			if(idx+1 < bomb.length() || stack[idx] != bomb.charAt(len-1)) {
				isBomb = false;
			}
			else {
				for (int j = 0; j < len; j++) {
					// 문자열 길이 다른 경우, 폭탄역할 못 함
					if(stack[idx-j] != bomb.charAt(len-1-j)) {
						isBomb = false;
						break;
					}
				}
			}
			// 폭탄인 경우 -> idx 크기 폭탄문자열만큼 빼기
			if(isBomb) idx -= (bomb.length()-1);
			// 폭탄아닌 경우 -> idx++
			else idx++;
		}
		
		StringBuilder sb = new StringBuilder();
		if(idx == 0) System.out.println("FRULA");
		else {
			for (int i = 0; i < idx ; i++) {
				sb.append(stack[i]);
			}
			System.out.println(sb.toString());
		}
	}

}
