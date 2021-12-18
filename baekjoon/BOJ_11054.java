package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 11054. 가장 긴 바이토닉 부분 수열
 * Study 15week
 * @author user
 * 오름차순 dp + 내림차순 dp
 */
public class BOJ_11054 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수열 크기
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] increase = new int[N];
		Arrays.fill(increase, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) increase[i] = Math.max(increase[i], increase[j]+1);
			}
		}
		int[] decrease = new int[N];
		Arrays.fill(decrease, 1);
		for (int i = N-1; i >= 0; i--) {
			for (int j = N-1; j > i; j--) {
				if(arr[i] > arr[j]) decrease[i] = Math.max(decrease[i], decrease[j]+1);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(ans < increase[i]+decrease[i]) {
				ans = increase[i]+decrease[i];
			}
		}
		System.out.println(ans-1);
	}

}
