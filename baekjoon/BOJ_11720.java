package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 11720. 숫자의 합
 * 2021.12.14
 * @author user
 *
 */
public class BOJ_11720 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int ans = 0;
		for (char c : arr) {
			ans += (c-'0');
		}
		System.out.println(ans);
	}
}
