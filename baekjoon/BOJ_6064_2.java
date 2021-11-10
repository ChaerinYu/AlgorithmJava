package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6064. 카잉달력
 * @author Chaerin Yu
 * https://jaimemin.tistory.com/808
 * 40456kb 572ms
 * 씽크빅이 중요한 문제..
 */
public class BOJ_6064_2 {

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
			
			// 멸망년도
			int maxYear = lcm(M, N);
			
			while(true) {
				// 멸망년도 벗어나는 경우 or 만족하는 년도 찾은 경우
				// (x-1) % N + 1 : ex) 10 % 5 == 0 -> 10-1=9, 9%5=4, 4+1 = 5
				// 모듈러 연산의 결과는 0~N-1이지만 문제에서는 1~N으로 나와야한다.
				if (x>maxYear || (x-1) % N + 1 == y) break;
				
				x+=M; // M으로 나눈 나머지 x
			}
			
			// 최소공배수보다 큰 경우 -1
			int answer = (x > maxYear) ? -1 : x;
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
