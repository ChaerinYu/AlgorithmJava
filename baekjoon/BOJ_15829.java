package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 15829. Hashing
 * @author Chaerin Yu
 * 21.11.25
 */
public class BOJ_15829 {
	static final int mod = 1234567891;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 문자열 길이
		char[] arr = br.readLine().toCharArray();
		
		long ans = 0;
		long num31 = 1;
		for (int i = 0; i < arr.length; i++) {
			ans += (arr[i]-'a'+1)*num31;
			num31 = (num31*31)%mod;
		}
		
		System.out.println(ans%mod);
	}

}
