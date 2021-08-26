package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [D3] 7964. 부먹왕국의 차원 관문
 */
public class SWEA_7964 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 왕국 도시의 수
			int dist = Integer.parseInt(st.nextToken()); // 제한 거리
			
			int[] cities = new int[n]; // 도시 지도 정보
			// 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				cities[i] = Integer.parseInt(st.nextToken());
			}
			
			int buildingIdx = 0, limit = 0;
			int res = 0;
			for (int i = 0; i < n; i++) {
				if(cities[i] == 1) {
					buildingIdx = i; // 최신으로 남아있는 인덱스 업데이트
					limit = 0;
				} else {
					limit++;
					// 제한거리 꽉 차면 도시 새로 세워준다.
					if(limit == dist) {
						limit = 0; // 제한 초기화
						buildingIdx = i; // 빌딩 세우기
						res++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
}
