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
		Arrays.fill(increase, 1); // 자기자신을 포함한 횟수 -> 1로 초기화해줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				// i번째 값이 앞의 값보다 큰 수인지 count
				if(arr[i] > arr[j]) increase[i] = Math.max(increase[i], increase[j]+1);
			}
		}
		
		int[] decrease = new int[N];
		Arrays.fill(decrease, 1);
		// 바이토닉 정렬이 특정값 기준으로 오른쪽이 내림차순이므로 끝에서부터 탐색한다.
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
		System.out.println(ans-1); // 자기자신 카운트한 횟수 중복되므로 -1
	}

}
