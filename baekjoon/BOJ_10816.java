package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10816. 숫자카드2
 * @author Chaerin Yu
 * 2021.11.23
 */
public class BOJ_10816 {

	final static int RANGE = 10_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
		int[] num = new int[N];
		int[] freq = new int[RANGE*2+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			freq[num[i]+RANGE]++;
		}
		
		int M = Integer.parseInt(br.readLine()); // 구해야 할 숫자카드 수
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			sb.append(freq[idx+RANGE]).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
