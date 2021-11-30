package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 11047. 동전 0
 * @author Chaerin Yu
 * 2021.11.30
 */
public class BOJ_11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 동전 종류
		int K = Integer.parseInt(st.nextToken()); // 금액
		
		int[] coins = new int[N];
		// 오름차순으로 주어지는 동전 내림차순으로 입력해준다.
		for (int i = N-1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			int cnt = K / coins[i]; // 해당 동전종류에서 사용되는 동전 수
			res += cnt;
			K -= cnt*coins[i]; // 남은 금액
		}
		
		System.out.println(res);
	}
}
