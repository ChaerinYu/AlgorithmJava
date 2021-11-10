package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6064. 카잉달력
 * @author Chaerin Yu
 * 18364kb 360ms
 */
public class BOJ_6064 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int M, N, x, y;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int temp = x % N;
			int answer = x;
			// x를 먼저 맞추고 y를 M만큼 증가하고 N으로 나머지 연산하나.
			for (int i = 0; i < N; i++) {
				int t = temp % N == 0 ? N : temp % N;
				if(t==y) break;
				temp = t + M;
				answer = answer + M;
			}
			
			// 최소공배수보다 큰 경우 -1
			answer = (answer > lcm(M, N)) ? -1 : answer;
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	/*
	 * 최소공배수
	 */
	private static int lcm(int m, int n) {
		return m*n/gcd(m,n);
	}

	/**
	 * 최대공약수
	 * @param m
	 * @param n
	 * @return
	 */
	private static int gcd(int m, int n) {
		while(n!=0) {
			int r = m%n;
			m = n;
			n = r;
		}
		return m;
	}

}
