package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1541. 잃어버린 괄호
 * @author Chaerin Yu
 * 2021.11.04
 */
public class BOJ_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		// 가장 큰 수를 빼어야 최소값이 나온다.
		// - 기준으로 분리한 후, 덧셈 진행한다.
		String[] part = s.split("[-]");
		
		int answer = 0;
		for (int i = 0; i < part.length; i++) {
			int temp = 0;
			String[] add = part[i].split("[+]");
			for (int j = 0; j < add.length; j++) {
				temp += Integer.parseInt(add[j]);
			}
			
			if(i==0) answer = temp;
			else answer -= temp;
		}
		
//		String[] numbers = s.split("[^0-9]"); // 숫자
//		String[] opers = s.replaceAll("[0-9]", "").split(""); // 연산자
		
		System.out.println(answer);
	}
}
