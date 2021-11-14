package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1436. 영화감독 숌
 * @author Chaerin Yu
 * 2021.11.14
 */
public class BOJ_1436 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 666; int idx = 1;
		int[] arr = new int[N+1];
		while(true) {
			if(String.valueOf(num).contains("666")) {
				arr[idx] = num;
				if(idx == N) break;
				idx++;
//				System.out.println(num);
			}
			num++;
		}
		
		System.out.println(arr[N]);
	}
}
 	