package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
/**
 * topdown 시간초과 문제는 https://www.acmicpc.net/board/view/34829 참조
 * @author user
 *
 */
public class Solution_BOJ_1463 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	// memp[i] = i를 1로 만들기 위해 필요한 최소 연산 회수
	static int[] memo;
	
	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new StringReader(src)); // 제출할 때 주석처리
		N = Integer.parseInt(input.readLine());
		
		memo = new int[N+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		// 1을 1로 만들기 위한 필요한 연산 회수
		memo[1] = 0;
//		System.out.println(topDown(N));
		System.out.println(bottomUp(N));
	}
	
	static int bottomUp(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		// 1을 1로 만들기 위한 필요한 연산 회수
		memo[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			int temp = memo[i-1]; // -1이 적용되는 경우
			if(i%2==0) {
				temp = Math.min(temp, memo[i/2]);
			}
			if(i%3==0) {
				temp = Math.min(temp, memo[i/3]);
			}
			memo[i] = temp+1;
		}
		return memo[n];
	}
	
	// top down 방식 - 재귀 기반 (시간 초과)
	// Math.min안쓰고 풀어쓰면 시간초과 안남..
	static int topDown(int n) {
		if(n == 1) return 0;
		if(memo[n] != Integer.MAX_VALUE) {
			return memo[n];
		}
		// 1을 빼는 경우
		int temp = topDown(n-1);
		// 3으로 나눠진다면..
		if(n%3 == 0) {
			temp = Math.min(temp, topDown(n/3));
		}
		// 2로 나눠진다면
		if(n%2 == 0) {
			temp = Math.min(temp, topDown(n/2));
		}
		// n이 1로 되는 최소 값은 기존의 연산값 + 1
		return memo[n] = temp+1;
	}
	
	
	private static String src="10";
}
