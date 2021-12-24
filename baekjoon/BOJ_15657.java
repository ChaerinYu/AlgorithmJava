package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Study 16week
 * @author Chaerin Yu
 * 15657. N과 M (8)
 * 2021.12.24
 * 중복조합
 */
public class BOJ_15657 {

	static int N, M; // 1 ≤ M ≤ N ≤ 8
	static StringBuilder sb;
	
	static int[] arr;
	
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		
		nums = new int[M];
		
		comb(0, 0);
		
		System.out.println(sb.toString());
	}

	private static void comb(int n, int start) {
		if(n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[n] = arr[i];
			comb(n+1, i);
		}
	}

}
