package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2884. 알람 시계
 * @author Chaerin Yu
 * 2021.12.08
 */
public class BOJ_2884 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken()); // 시
		int min = Integer.parseInt(st.nextToken()); // 분
		
		if(min<45)
			hour = (hour-1+24) % 24;
		min = (min-45+60) % 60;
		
		StringBuilder sb = new StringBuilder();
		sb.append(hour).append(" ").append(min);
		
		System.out.println(sb.toString());
	}

}
