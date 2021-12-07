package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2675. 문자열 반복
 * @author Chaerin Yu
 * 2021.12.07
 */
public class BOJ_2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int recur = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();
			
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < recur; j++) {
					sb.append(arr[i]);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
