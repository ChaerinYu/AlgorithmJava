package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2527. 직사각형 
 * @author user
 * 모든 직사각형은 두 꼭짓점의 좌표를 나타내는 4개의 정수 x y p q 로 표현된다. 단 항상 x<p, y<q 이다.
 * 공통부분의 특성      코드 문자
	 직사각형                  a
	    선분                     b
	     점                       c
	공통부분이 없음         d
 */
public class BOJ_2527 {

	static int[][] rectangle; // 직사각형
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = null;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rectangle = new int[1][8]; // 2개의 직사각형, x, y, p, q, x, y, p, q

			rectangle[0][0] = Integer.parseInt(st.nextToken()); // x
			rectangle[0][1] = Integer.parseInt(st.nextToken()); // y
			rectangle[0][2] = Integer.parseInt(st.nextToken()); // p
			rectangle[0][3] = Integer.parseInt(st.nextToken()); // q
			rectangle[0][4] = Integer.parseInt(st.nextToken()); // x
			rectangle[0][5] = Integer.parseInt(st.nextToken()); // y
			rectangle[0][6] = Integer.parseInt(st.nextToken()); // p
			rectangle[0][7] = Integer.parseInt(st.nextToken()); // q
				
			checkOverlap(rectangle[0][0], rectangle[0][1], rectangle[0][2], rectangle[0][3]
					, rectangle[0][4], rectangle[0][5], rectangle[0][6], rectangle[0][7]);
		}
		
	}
	
	
	static void checkOverlap(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
		// 면 a 선 b 점 c 겹치는 거 없을 때 d
		// 안겹침
		if(p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
			System.out.println("d");
		}
		// 점
		else {
			// 사각형1의 p과 사각형2의 x 비교
			if(p1==x2) {
				if(q1==y2 || q2==y1) System.out.println("c"); // y까지 같으면 점
				else System.out.println("b"); // 아니면 선
			}
			// 사각형2의 p와 사각형1의 x 비교
			else if(p2==x1) {
				if(q2==y1 || q1==y2) System.out.println("c");
				else System.out.println("b");
			}
			// 사각형1의 q와 사각형2의 y 비교
			else if(q1==y2) {
				if(p1==x2 || p2==x1) System.out.println("c"); // x까지 같으면 점
				else System.out.println("b");
			}
			// 사각형2의 q와 사각형1의 y 비교
			else if(q2==y1) {
				if(p1==x2 || p2==x1) System.out.println("c");
				else System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	}
}
