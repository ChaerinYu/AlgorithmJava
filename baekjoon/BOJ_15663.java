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
 * 결과-> 1 2 19
 * 
 * LinkedHashSet이 아닌 TreeSet을 사용하면 안되는 이유
 * 
 * 둘 다 정렬이 가능한 Set이라는 점은 동일하지만 LinkedHashSet은 입력순으로 정렬되고, 
 * TreeSet은 생성시 인자로 Comparator를 넘겨주지 않는다면 기본적으로 오름차순 정렬한다.
 * 
 * 따라서, TreeSet을 사용하면 String을 기준으로 오름차순 정렬하기 때문에 
 * 기존에 숫자가 작은순으로 오름차순 정렬했던 순서가 깨지게 된다.
 * 
 * 8 8
 * 10000 9999 9998 9997 9996 9995 9994 9993
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
