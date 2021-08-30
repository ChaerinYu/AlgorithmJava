package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * [D3] 6958. 동철이의 프로그래밍 대회
 * @author ChaerinYu
 * @date 210830
 *
 */
public class SWEA_6958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int M = Integer.parseInt(st.nextToken()); // 문제 수
			
			int[][] problems = new int[N+1][M+1];
			
			int firstNum = 0, correctNum = 0; // 1등한 사람 수, 1등한 사람이 맞은 문제 수
			int temp = 0;
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				temp = 0;
				for (int c = 1; c <= M; c++) {
					problems[r][c] = Integer.parseInt(st.nextToken());
					if(problems[r][c] == 1) temp++;
				}
				if(temp >= correctNum) {
					if(temp>correctNum) firstNum = 1;
					else firstNum++;
					
					correctNum = temp;
				}
			}
			
			System.out.println("#"+tc+" "+firstNum+" "+correctNum);
		}
	}
}
