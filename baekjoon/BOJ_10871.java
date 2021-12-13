package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 10871. X보다 작은 수
 * @author Chaerin Yu
 * 2021.12.13
 */
public class BOJ_10871 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 정수 N개 입력
		int x = Integer.parseInt(st.nextToken()); // x보다 작은 수
		
		st = new StringTokenizer(br.readLine());
		
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num < x) sb.append(num).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
