package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * Study week 3
 * 1182. 부분수열의 합
 * @author Chaerin Yu
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 * combination으로 풀려고 했지만 안풀려서 dfs 사용함
 * bit masking 비트마스킹
 */
public class BOJ_1182 {

	static int N, S; // 정수 개수, 부분수열 합 (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 
	static int[] numbers;
	
	static int res;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정수 개수 
		S = Integer.parseInt(st.nextToken()); // 부분 수열 합
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		// 수열 정수 입력
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0;
		// 1. dfs
//		dfs(0, 0);
		// 2. bit masking
		masking();
		
		System.out.println(res);
	}
	
	// bit masking
	/**
	 * 집합의 원소 값을 이진수 자리 수로 생각해서 풀기 -> 0~(1<<N)
	 * 
	 */
	static void masking() {
		// 1부터 2^N-1 까지의 숫자 -> i는 부분집합을 의미
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			// 부분집합(i)에서 기존 집합(numbers)의 어떤 index를 포함하고 있는지 확인
			for (int j = 0; j < N; j++) {
				// 부분집합과 & 연산했을 때 0이 아닌 경우 -> 해당 부분집합의 원소임을 의미
				if((i & (1<<j)) != 0) {
					sum += numbers[j];
				}
			}
			// 합이 S인 경우 count+1
			if(sum==S) res++;
		}
	}
	
	// dfs
	static void dfs(int sum, int cnt) {
		if(cnt >= N) return; // 수열 원소 개수가 N넘으면 return
		if(sum+numbers[cnt]==S) res++; // 수열 원소 합이 S인 경우
		
		dfs(sum+numbers[cnt], cnt+1); // 원소합 포함할 때
		dfs(sum, cnt+1); // 원소합 포함 안 할 때
	}
	
	private static String src = "5 0\r\n" + 
			"-7 -3 -2 5 8";
}
