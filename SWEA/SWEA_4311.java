package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4311. [연습문제] 오래된 스마트폰
 * A형 대비
 * @author Chaerin Yu
 *
 */
public class SWEA_4311 {

	static int N, O, M, W; // N: 터치 가능 숫자 수, O: 터치 가능 연산자 수, M: 최대 터치 가능 횟수, W: 원하는 숫자
	static boolean[] touchNums;// 터치 가능한 숫자
	static boolean[] touchOper;// 터치 가능한 연산자
	static final char[] operator = {' ', '+', '-', '*', '/'}; // 연산자
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 터치 가능 숫자 수
			O = Integer.parseInt(st.nextToken()); // 터치 가능 연산자 수
			M = Integer.parseInt(st.nextToken()); // 최대 터치 가능 횟수
			
			// 입력 가능 숫자
			touchNums = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				touchNums[num] = true;
			}
			// 입력 가능 연산자
			touchOper = new boolean[5];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < O; i++) {
				int num = Integer.parseInt(st.nextToken());
				touchOper[num] = true;
			}
			
			W = Integer.parseInt(br.readLine()); // 원하는 숫자
			
			int res = -1;
			calc();
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void calc() {
		
	}
	
}

/**
[입력]
5
6 4 5
0 1 2 3 4 7
1 2 3 4
5
3 1 4
1 6 5
1
0
7 3 6
1 8 0 2 6 7 9
2 1 4
91
5 2 10
4 0 5 3 9
3 4
28
5 3 10 
8 7 1 2 6
2 4 3
981
[출력]
#1 4
#2 -1
#3 2
#4 7
#5 9
*/