package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
/**
 * Study 16week
 * @author Chaerin Yu
 * 15663. N과 M (9)
 * 2021.12.24
 * 순열
 * 
 * 3 1
 * 1 19 2
 * 
 * 결과-> 1 2 19
 */
public class BOJ_15663 {

	static int N, M; // 1 ≤ M ≤ N ≤ 8
	// 전역변수 선언 후, perm method에서 append해주는 경우 출력초과 발생
//	static StringBuilder sb;
	
	static int[] arr;
	
	static boolean[] isSelected;
	static int[] nums;
	static LinkedHashSet<String> tempArr;
	
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
		
//		sb = new StringBuilder();
		isSelected = new boolean[N];
		nums = new int[M];
		tempArr = new LinkedHashSet<String>();
		
		perm(0);
		
		StringBuilder ans = new StringBuilder();
		for (String string : tempArr) {
			ans.append(string).append("\n");
//			sb.append(string).append("\n");
		}
		
		System.out.print(ans.toString());
//		System.out.println(sb.toString());
	}

	private static void perm(int n) {
		if(n == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			tempArr.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			nums[n] = arr[i];
			perm(n+1);
			isSelected[i] = false;
		}
	}

}
