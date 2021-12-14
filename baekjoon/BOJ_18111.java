package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 18111. 마인크래프트
 * 2021.12.14
 * @author user
 *
 */
public class BOJ_18111 {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 블록
		
		int min = INF, max = -1;
		int[][] map = new int[N][M]; // 땅 높이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] < min) min = map[i][j];
				if(map[i][j] > max) max = map[i][j];
			}
		}
		// 제거 2초, 블록 놓기 1초
		// 걸리는 시간과 땅 높이
		int time = 0, height = min;
		if(B == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					time += (map[i][j]-min)*2;
				}
			}
		} else {
			// 최소 ~ 최대
			time = INF;
			int temp = 0;
			int cnt = B;
//			blocks:
			for(int k=min; k<=max; k++) {
				temp = 0;
				cnt = B;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
//						if(cnt < 0) continue blocks;
						if(map[i][j] == k) continue;
						// 제거
						if(map[i][j] > k) {
							temp += (map[i][j]-k)*2;
							cnt += (map[i][j]-k);
						}
						// 놓기
						else {
							temp += (k-map[i][j]);
							cnt -= (k-map[i][j]);
						}
					}
				}
				// 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하시오.
				if(cnt>=0 && time >= temp) {
					time = temp;
					height = k;
				}
			}
		}
		
		System.out.println(time+" "+height);
		
	}
}
