package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1107.리모컨
 * @author ChaerinYu
 * 2021.11.04
 */
public class BOJ_1107 {
	
//	private static String N; // 채널
	private static int N; // 채널
	private static int M; // 고장난 버튼 개수
	private static boolean[] btns; // 버튼, true: 고장

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 채널
//		N = br.readLine(); // 채널
		M = Integer.parseInt(br.readLine()); // 고장난 버튼 수
		
		btns = new boolean[10];
		if(M!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 고장난 버튼 true로 업데이트
			for (int i = 0; i < M; i++) {
				btns[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
//		int answer = Math.abs(Integer.parseInt(N)-100);
		int answer = Math.abs(N-100);
		// 가장 큰 수가 500_000 이지만, 9를 제외한 모든 수가 고장난 경우 고려 -> 1_000_000
		for (int i = 0; i < 1_000_000; i++) {
			String s = String.valueOf(i);
			int len = s.length();
			
			boolean flag = false;
			for (int j = 0; j < len; j++) {
				// 고장난 버튼 누르는 경우
				if(btns[s.charAt(j)-'0']) {
					flag = true;
					break;
				}
			}
			
			// 고장난 버튼 아닌 경우
			if(!flag) {
				int min = Math.abs(N-i)+len; // i 입력한 후, target까지 이동하는 횟수
				answer = Math.min(min, answer);
			}
		}
		
		System.out.println(answer);
		
	}
}
