package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1198. 삼각형으로 자르기
 * 2022.01.06
 * @author Chaerin Yu
 * 볼록 다각형 점의 수 N (3 ≤ N ≤ 35)
 */
public class BOJ_1198 {

	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 다각형
		
		Point[] points = new Point[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
//		int minX = 0, minY = 0, maxX = 0, maxY = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(i==j) continue;
				for (int k = j+1; k < N; k++) {
					if(i==k || j==k) continue;
					res = Math.max(res, Math.abs((points[i].y-points[j].y)*(points[k].x-points[j].x)-(points[i].x-points[j].x)*(points[k].y-points[j].y)));
//					minX = Math.min(points[k].x, Math.min(points[i].x, points[j].x));
//					maxX = Math.max(points[k].x, Math.max(points[i].x, points[j].x));
//					minY = Math.min(points[k].y, Math.min(points[i].y, points[j].y));
//					maxY = Math.max(points[k].y, Math.max(points[i].y, points[j].y));
					
//					res = Math.max(res, (double)((maxX-minX)*(maxY-minY)
//							-Math.abs((double)((points[i].x-points[j].x)*(points[i].y-points[j].y))/2)
//							-Math.abs((double)((points[j].x-points[k].x)*(points[j].y-points[k].y))/2)
//							-Math.abs((double)((points[k].x-points[i].x)*(points[k].y-points[i].y))/2)
//							));
				}
			}
		}
		
		System.out.printf("%.9f%n", (double)res/2);
	}

}
