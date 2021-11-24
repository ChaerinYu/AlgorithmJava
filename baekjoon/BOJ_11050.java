package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 11050. 이항 계수 1
 * @author Chaerin Yu
 * 2021.11.24
 */
public class BOJ_11050 {

	static int[] fac;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		fac = new int[11];
		fac[0] = fac[1] = 1;
		for (int i = 2; i <= 10; i++) {
			fac[i] = i*fac[i-1];
		}
		
		int N = Integer.parseInt(st.nextToken()); // 자연수
		int K = Integer.parseInt(st.nextToken()); // 정수
		
		System.out.println(fac[N]/fac[K]/fac[N-K]);
	}
}
