package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1004. 어린 왕자
 * 2021.12.28
 * @author Chaerin Yu
 *
 */
public class BOJ_1004 {

	static int sx, sy, dx, dy;
	static int n; // 행성 수
	static int[] planets; // 행성
	static int cx, cy, r;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case 수
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken()); // 출발지x
			sy = Integer.parseInt(st.nextToken()); // 출발지y
			dx = Integer.parseInt(st.nextToken()); // 도착지x
			dy = Integer.parseInt(st.nextToken()); // 도착지y
			
			int res = 0;
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				cx = Integer.parseInt(st.nextToken()); // 행성 x
				cy = Integer.parseInt(st.nextToken()); // 행성 y
				r = Integer.parseInt(st.nextToken());  // 반지름
				
				boolean con1 = (cx-sx)*(cx-sx)+(cy-sy)*(cy-sy) < r*r;
				boolean con2 = (cx-dx)*(cx-dx)+(cy-dy)*(cy-dy) < r*r;
				// 출발점 및 도착점 둘다 원안에있을 경우
				if(con1 && con2) continue;
				else if(con1 || con2) {
					res++;
				}
			}
			sb.append(res).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
