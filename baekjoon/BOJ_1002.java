package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1002. 터렛
 * 2021.12.29
 * @author Chaerin Yu
 */
public class BOJ_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int x1, y1, r1, x2, y2, r2;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			int dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); // 중점간 거리
			int plus_pow = (r1 + r2)*(r1 + r2);
			int minus_pow = (r1-r2)*(r1-r2);
			
			// 중점 같고 반지름 같은 경우 -> 무한
			if(x1==x2 && y1==y2 && r1==r2) sb.append(-1).append("\n");
			// 중점 거리 > 반지름 합 -> 0
			else if(dist > plus_pow) sb.append(0).append("\n");
			// 원 안에 원 있지만 내접하지 않는 경우 -> 0
			else if(dist < minus_pow) sb.append(0).append("\n");
			// 내접 -> 1
			else if(dist == minus_pow) sb.append(1).append("\n");
			// 외접 -> 1
			else if(dist == plus_pow) sb.append(1).append("\n");
			// 그 외 -> 2
			else sb.append(2).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
