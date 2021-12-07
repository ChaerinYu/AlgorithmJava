package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2753. 윤년
 * @author Chaerin Yu
 * 2021.12.07
 */
public class BOJ_2753 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine()); // 연도 (1~4000)
		
		if(year%4==0 && (year%100 != 0 || year%400 == 0)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
