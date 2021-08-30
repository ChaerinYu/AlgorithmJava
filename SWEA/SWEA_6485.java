package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * [D3] 6485. 삼성시의 버스 노선
 * @author ChaerinYu
 * 삼성시에 있는 5,000개의 버스 정류장은 관리의 편의를 위해 1에서 5,000까지 번호가 붙어 있다.
 * 그리고 버스 노선은 N개가 있는데, i번째 버스 노선은 번호가 Ai이상이고, Bi이하인 모든 정류장만을 다니는 버스 노선이다.
 * P개의 버스 정류장에 대해 각 정류장에 몇 개의 버스 노선이 다니는지 구하는 프로그램을 작성하라.
 */
public class SWEA_6485 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 버스 수
			
			int[][] bus = new int[N][2]; // a, b
			// 버스 범위 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bus[i][0] = Integer.parseInt(st.nextToken()); // from
				bus[i][1] = Integer.parseInt(st.nextToken()); // to
			}
			
			int P = Integer.parseInt(br.readLine()); // 정류장 개수
			int[] busStop = new int[P];
			// 정류장 번호 입력
			for (int i = 0; i < P; i++) {
				busStop[i] = Integer.parseInt(br.readLine());
			}
			
			int[] visitNum = new int[P];
			for (int i = 0; i < N; i++) {
				// from to
				int bMin = bus[i][0], bMax = bus[i][1];
				for (int j = 0; j < P; j++) {
					// 버스 범위안에 들어서면 visit
					if(busStop[j]>=bMin && busStop[j]<=bMax) {
						visitNum[j]++;
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < P-1; i++) {
				System.out.print(visitNum[i]+" ");
			}
			System.out.println(visitNum[P-1]);
			
		}
	}
}
