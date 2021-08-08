package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2839. 설탕 배달
 * 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 
 * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 최대한 적은 봉지를 들고 가려고 한다. 
 * 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 */
public class BOJ_2839 {

	private static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 배달 설탕 kg
		
		int share5 = N/5, share3 = N/3;
		for (int i = 0; i <= share5; i++) {
			for (int j = 0; j <= share3; j++) {
				if(5*i + 3*j == N) {
					MIN = Math.min(MIN, i+j);
				}
			}
		}
		if(MIN == Integer.MAX_VALUE) sb.append(-1);
		else sb.append(MIN);
		System.out.println(sb);
		
	}

}
