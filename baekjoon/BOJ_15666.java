package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * 15666. N과 M (12)
 * Study week 17
 * @author Chaerin Yu
 * 2022.01.09
 * 15663과 유사
 * 중복조합문제
 */
public class BOJ_15666 {

	static int N, M;
	static int[] arr;
	static int[] nums;
	static LinkedHashSet<String> set;
	
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
		
		nums = new int[M];
		set = new LinkedHashSet<String>();
		
		comb(0, 0);
		
		StringBuilder sb = new StringBuilder();
		for (String string : set) {
			sb.append(string);
		}
		System.out.println(sb.toString());
	}

	private static void comb(int n, int start) {
		if(n == M) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < M; i++) {
				temp.append(nums[i]).append(" "); 
			}
			temp.append("\n");
			set.add(temp.toString());
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[n] = arr[i];
			comb(n+1, i); // 선택한 수부터 처리
		}
	}

}
