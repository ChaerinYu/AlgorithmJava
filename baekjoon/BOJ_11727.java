package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11727 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 1,000
		
		int[] rectangles = new int[1001];
		rectangles[1] = 1;
		rectangles[2] = 3;
		for (int i = 3; i <= N; i++) {
			rectangles[i] = (rectangles[i-1]+rectangles[i-2]*2)%10_007;
		}
		
		System.out.println(rectangles[N]);
	}
}
