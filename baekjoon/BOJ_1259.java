package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팰린드롬수
 * @author Chaerin Yu
 * 2021.11.14
 */
public class BOJ_1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			StringBuilder reverseStr = new StringBuilder(str).reverse();
			if(str.equals(reverseStr.toString()))
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		System.out.print(sb.toString());
	}

}
