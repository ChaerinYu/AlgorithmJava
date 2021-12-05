package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2475. 검증수
 * @author Chaerin Yu
 * 2021.12.05
 */
public class BOJ_2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int squareSum = 0;
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(st.nextToken());
			squareSum += num*num;
		}
		System.out.println(squareSum%10);
	}

}
