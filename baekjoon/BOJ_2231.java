package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2021.11.18
 * 분해합
 * @author Chaerin Yu
 */
public class BOJ_2231 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for (int i = 1; i < N; i++) {
			int num = i;
			int temp = 0; // 각 자릿수 합
			
			while(num != 0) {
				temp += num % 10;
				num /= 10;
			}
			
			if(temp + i == N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
