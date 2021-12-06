package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2562. 최댓값
 * 2021.12.06
 * @author user
 *
 */
public class BOJ_2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0, idx = 0;
		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if(max < num) {
				max = num;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}

}
