package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 11729. 하노이 탑 이동 순서
 * @author user
 * 2021.12.27
 */
public class BOJ_11729 {

	static int K; // 옮긴 횟수
	static StringBuilder sb;
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine()); // 옮긴 횟수 1 ≤ N ≤ 20
		
		sb = new StringBuilder();
		res = 0;
		hanoi(K, 1, 2, 3);
		
		sb.insert(0, "\n").insert(0, res);
		System.out.println(sb.toString());
	}

	private static void hanoi(int n, int start, int temp, int dest) {
		if(n==0) return;

		res++;
		// 자신의 위쪽의 n-1개 원판 들어내기: 임시기둥으로 옮기기
		hanoi(n-1, start, dest, temp);
		// 자신의 원판 옮기기: 목적기둥
		sb.append(start).append(" ").append(dest).append("\n");
		// 들어냈던 임시기둥의 n-1개 원판 자신위에 쌓기: 목적기둥으로 옮기기
		hanoi(n-1, temp, start, dest);
	}
	
	
}
