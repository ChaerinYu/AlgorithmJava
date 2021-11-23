package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 10250. ACM 호텔
 * @author Chaerin Yu
 * 2021.11.23
 */
public class BOJ_10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // test case 수
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken()); // 호텔 층 수
			int W = Integer.parseInt(st.nextToken()); // 각 층 방 수
			int N = Integer.parseInt(st.nextToken()); // n 번째 손님
			
			int floor = N%H;
			int num = N/H+1;
			if(N%H==0) {
				floor = H;
				num = N/H;
			}
			
			sb.append(floor);
			if(num/10 == 0) sb.append(0);
			sb.append(num);
			
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}
}
