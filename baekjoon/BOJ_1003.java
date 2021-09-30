package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ_1003 {

	static final int NUM = 40;
	
	static int N; // N은 40보다 작거나 같은 자연수 또는 0
	static int[] fibo; // 피보나치 수 저장
	static int[][] fiboCall; // 각 피보나치 수 0, 1 호출 횟수 저장
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 돌리기 전에 미리 피보나치 배열을 채워놓는다.
		getFibo();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			sb.append(fiboCall[N][0]).append(" ").append(fiboCall[N][1]).append("\n");
		}
		System.out.println(sb);
	}

	// 피보나치 구하기
	private static void getFibo() {
		fiboCall = new int[NUM+1][2];
		fibo = new int[NUM+1];
		
		fibo[0] = 0; fibo[1] = 1;
		fiboCall[0][0] = 1;
		fiboCall[1][1] = 1;
		
		for (int i = 2; i <= NUM; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
			fiboCall[i][0] = fiboCall[i-1][0]+fiboCall[i-2][0];
			fiboCall[i][1] = fiboCall[i-1][1]+fiboCall[i-2][1];
		}
	}

	private static String src = "3\r\n" + 
			"0\r\n" + 
			"1\r\n" + 
			"3";
}
