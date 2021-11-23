package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 4153. 직각삼각형 
 * @author Chaerin Yu
 * 2021.11.23
 */
public class BOJ_4153 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int[] num = new int[3];
		while(true) {
			st = new StringTokenizer(br.readLine());
			num[0] = Integer.parseInt(st.nextToken());
			num[1] = Integer.parseInt(st.nextToken());
			num[2] = Integer.parseInt(st.nextToken());
			
			if(num[0]== 0 && num[1]==0 && num[2]==0) break;
			
			Arrays.sort(num);
			if((num[0]*num[0]+num[1]*num[1])==num[2]*num[2]) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
		System.out.print(sb.toString());
	}

}
