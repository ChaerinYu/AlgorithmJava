package SWEA;

import java.util.Scanner;
/**
 * [D4] 4796. 의석이의 우뚝 선 산
 * @author ChaerinYu
 * 
 */
public class SWEA_4796 {

	static int N; // mountain number
	static int[] h; // mountain height
	static int res; // answer
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // test case
//		sc.nextLine();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
//			sc.nextLine();
			
			h = new int[N];
			for (int i = 0; i < N; i++) {
				h[i] = sc.nextInt();
			}
//			sc.nextLine();
			
			res = 0;
			boolean isMountain = false;
			int mLen = 1, cnt = 0;
			for (int i = 1; i < N; i++) {
				mLen++;
				// 오름차순일 때
				if(h[i-1]<h[i]) {
					// 산 true? : 내림차순으로 오고있던 상황
					if(isMountain) {
						cnt = 1; // cnt 초기화 (현재 위치부터 다시 시작 가능하므로 1로 초기화)
						isMountain = false;
					} else {
						cnt++; // 오름차순 원소 늘어날때마다 그만큼 가능한 우뚝 선 산 수도 늘어남
					}
				}
				// 내림차순일 때
				else if(h[i-1]>h[i]) {
					// 산 길이 3 안 될 때
					if(mLen < 3) {
						continue;
					}
					res += cnt;
					isMountain = true;
				}
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
	
}
