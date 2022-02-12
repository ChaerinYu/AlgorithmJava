package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1629. 곱셈
 * 2022.02.12
 * @author user
 *
 */
public class BOJ_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(calc(a, b, c));
		
	}

	private static long calc(int a, int b, int c) {
		if(b == 0) {
			return 1;
		}
		
		long temp = calc(a, b/2, c);
		temp = ((temp % c) * (temp % c) % c);
		
		if(b % 2 == 0) return temp;
		else return ((temp % c) * (a % c) % c);
	}

}
