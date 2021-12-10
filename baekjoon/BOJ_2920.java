package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2920. 음계
 * @author Chaerin Yu
 * 2021.12.09
 */
public class BOJ_2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int asc = 0, desc = 0;
		for (int i = 1; i <= 8; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(i == num) asc++;
			if(9-i == num) desc++;
		}
		
		if(asc == 8) System.out.println("ascending");
		else if(desc==8) System.out.println("descending");
		else System.out.println("mixed");
	}

}
