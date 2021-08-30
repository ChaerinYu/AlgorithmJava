package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [D4] 5432. 쇠막대기 자르기
 * @author ChaerinYu
 *
 */
public class SWEA_5432 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String ironPoll = br.readLine();
			ironPoll = ironPoll.replace("()", "A");
			
			char[] ironArr = ironPoll.toCharArray();
			int res = 0; int iron = 0;
			for (int i = 0; i < ironArr.length; i++) {
				if(ironArr[i] == 'A') {
					res += iron;
				}
				else if(ironArr[i] == '(') {
					iron++;
				}
				else if(ironArr[i] == ')') {
					res += 1;
					iron--;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}
}
