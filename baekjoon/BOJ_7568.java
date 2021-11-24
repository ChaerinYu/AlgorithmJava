package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 7568. 덩치
 * @author Chaerin Yu
 * 2021.11.24
 */
public class BOJ_7568 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사람 수
		int[][] men = new int[N][2]; // 사람 덩치
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			men[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			men[i][1] = Integer.parseInt(st.nextToken()); // 키
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = 1;
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(men[i][0] < men[j][0] && men[i][1] < men[j][1]) {
					num++;
				}
			}
			sb.append(num).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
