package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [D3] 3407. 최장 증가 부분 수열
 * @author ChaerinYu
 * 20210916
 * LIS 최장 증가 수열
 */
public class SWEA_3407 {
	
	static int T, N; // 테스트 케이스 수, 수열 길이
	static int[] arr;
	static int[] LIS; // 각 원소를 끝으로 하는 최장 길이
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 수열 길이
			
			arr = new int[N+1];
			LIS = new int[N+1];
			String[] temp = br.readLine().split(" "); // 수열 원소 입력
			for (int i = 1; i <= temp.length; i++) {
				arr[i] = Integer.parseInt(temp[i-1]);
			}
			
			int res = 0;
			for (int i = 1; i <= N; i++) {
				LIS[i] = 1; // 자기 자신만 있는 경우, 길이 1
				// arr 맨 앞부터 단계별로 비교하여 최대값 갱신
				for (int j = 1; j < i; j++) {
					// 자기자신보다 이전 숫자가 작고, LIS값이 이전 숫자가 더 크면
					if(arr[j] < arr[i] && LIS[i] <= LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				res = Math.max(res, LIS[i]);
			}
			System.out.println("#"+tc+" "+res);
		}
	}

}
