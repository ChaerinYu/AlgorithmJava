package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2021.12.01
 * @author Chaerin Yu
 * 11659. 구간 합 구하기 4
 * 
 * 시간초과 나기 쉬운 문제 -> 누적 합 배열 따로 만들어서 해결!
 */
public class BOJ_11659 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수 개수
		int M = Integer.parseInt(st.nextToken()); // 합 구해야 하는 횟수
		
		int[] numbers = new int[N]; // 수 
		int[] sums = new int[N]; // 누적 합
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			
			if(i==0) {
				sums[i] = numbers[i];
			} else {
				sums[i] = sums[i-1]+numbers[i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			int sum = 0;
			if(start == 0) {
				sum = sums[end];
			} else {
				sum = sums[end]-sums[start-1];
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb.toString());
	}
}
