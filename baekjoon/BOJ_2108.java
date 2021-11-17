package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 21.11.17
 * @author Chaerin Yu
 * 2108. 통계학
 */
public class BOJ_2108 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		double ans1 = 0; int max = -4000, min = 4000;
		int[] mode = new int[8001];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			mode[arr[i]+4000]++; // 최빈값 구하기 -> -4000부터 가능하므로 +4000해줌
			
			ans1 += arr[i];
			if(max<arr[i]) max = arr[i]; // 최대
			if(min>arr[i]) min = arr[i]; // 최소
		}
		
		Arrays.sort(arr);
		
		// 빈도 수, 동일 빈도수 인 경우 체크
		int temp = 0, order = 0;
		int ans3 = 0; // 최빈값
		for (int i = 0; i < mode.length; i++) {
			if(mode[i]>=temp) {
				// 지금까지 나온 수와 빈도수 동일한 경우, order++
				if(mode[i]==temp) order++;
				else order = 0;
				// order가 1넘으면 (동일 빈도수가 2개 이상인 경우) 무시
				if(order>1) continue;
				temp = mode[i];
				ans3 = i-4000; // 최빈값은 -4000을 해줘야 한다.
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(ans1/N)).append("\n"); // 산술평균
		sb.append(arr[N/2]).append("\n"); // 중앙값
		sb.append(ans3).append("\n"); // 최빈값
		sb.append(Math.abs(max-min)).toString(); // 범위
		
		System.out.println(sb.toString());
	}

}
