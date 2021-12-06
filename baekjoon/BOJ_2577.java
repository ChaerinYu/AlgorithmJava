package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2577. 숫자의 개수
 * 2021.12.06
 * @author user
 *
 */
public class BOJ_2577 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
		
		int[] freq = new int[10];
		while(temp != 0) {
//			System.out.println(temp);
			freq[temp%10]++;
			temp = temp/10;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < freq.length; i++) {
			sb.append(freq[i]).append("\n");
		}
		System.out.print(sb.toString());
	}

}
