package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2448. 별 찍기 - 11
 * @author Chaerin Yu
 * 첫째 줄부터 N번째 줄까지 별을 출력
 * Study 14week
 */
public class BOJ_2448 {

	static String[] STAR = {"  *  ", " * * ", "*****"};
	
	static StringBuilder sb;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-(i/3+1)*3; j++) { 
				sb.append(" ");
			}
			sb.append(STAR[i%3]);
			for (int j = 0; j < N-(i/3+1)*3; j++) {
				sb.append(" ");
			}
			sb.append("\n");
			STAR[i%3] = STAR[i%3] + " " + STAR[i%3];
		}
		
		System.out.println(sb.toString());
	}
}
