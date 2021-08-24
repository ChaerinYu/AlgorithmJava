package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8958. OX퀴즈
 * @author user
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 */
public class BOJ_8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case 수
		
		for (int tc = 1; tc <= T; tc++) {
			char[] quiz = br.readLine().toCharArray(); // 입력과 동시에 char array로
			
			int oCnt = 0, score = 0;
			for (int i = 0; i < quiz.length; i++) {
				if(quiz[i] == 'O') {
					oCnt++; // 누적
					score += oCnt; // 총점
				} else {
					oCnt = 0; // 누적 초기화
				}
			}
			System.out.println(score);
		}
	}
}
