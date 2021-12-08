package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2908. 상수
 * @author Chaerin Yu
 * 2021.12.08
 */
public class BOJ_2908 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		int ten = 1;
		int numA = 0, numB = 0;
		for (int i = 0; i < a.length() ; i++) {
			numA += (a.charAt(i)-'0') * ten;
			numB += (b.charAt(i)-'0') * ten;
			ten = ten*10;
		}
		System.out.println(numA > numB ? numA : numB);
	}
}
