package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2588. 곱셈
 * 2022.01.11
 * @author Chaerin Yu
 *
 */
public class BOJ_2588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		int total = 0;
		for (int i = 2; i >= 0; i--) {
			int num = a * (arr[i]-'0');
			sb.append(num).append("\n");
			total += num * Math.pow(10, 2-i);
		}
		sb.append(total);
		System.out.println(sb.toString());
	}
}
