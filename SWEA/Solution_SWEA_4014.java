package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4014. [모의 SW 역량테스트] 활주로 건설
 * @author user
 * 시뮬레이션 구현
 */
public class Solution_SWEA_4014 {

	static int N, X; // 한 변의 길이, 경사로의 길이 (경사로 높이는 항상 1)
	static int[][] map; // 절벽지대. 지형의 높이는 1 이상 6 이하의 정수이다.
	static int[][] reverseMap;
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 한 변의 길이 6 ≤ N ≤ 20 
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이  2 ≤ X ≤ 4 
			
			// 절벽지대 입력
			map = new int[N][N];
			reverseMap = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					reverseMap[c][r] = map[r][c];
				}
			}
			
			res = 0;
			
			for (int i = 0; i < N; i++) {
				// 행
				if(build(map, i)) {
					res++;
				}
				// 열
				if(build(reverseMap, i)) {
					res++;
				}
//				if(build(map, i, false)) {
//					res++;
//				}
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb);
	}

	/**
	 * 활주로 건설 가능 row 또는 col 세기
	 * 1. 이전높이 == 현재높이: 연속 동일 높이 카운팅 관리
	 * 2. 이전높이+1 == 현재높이: 연속 동일 높이 카운팅 관리 -> 현재높이 도착시 연속동일높이 다시 체크 필요
	 * 3. 이전높이-1 == 현재높이: 체크해오던 연속동일높이 활용 안 함 -> 현재높이부터 다시 연속 동일구간 체크 필요
	 * @param index 
	 * @param isRow 
	 */
	private static boolean build(int[][] m, int index) {
		int beforeHeight = m[index][0];
		int cnt = 1; // 연속 동일 높이 수
		// 한 행씩 보기
		for (int c = 1; c < N; c++) {
			if(beforeHeight == m[index][c]) {
				// 이전 높이와 같은 경우
				cnt++;
			} 
			// 이전 높이와 다른 경우
			// 내리막
			else if(beforeHeight==m[index][c]+1) {
				cnt = 0; // 경사로 설치하든 안하든 다시 연속 길이 체크
				// 현재 위치부터 다음을 계속 보면서 x길이만큼 가능한지 확인
				int tempcnt = 0;
				for (int k = c; k < N; k++) {
					if(m[index][k] != beforeHeight-1) break; // 이전높이와 다른 경우 멈춤
					if(++tempcnt==X) break; // 경사로 길이 만족하면 탈출
				}
				
				if(tempcnt<X) return false;
				c += X-1;
				beforeHeight--; // 내리막으로 내려왔기 때문에 내리막 높이 줄이기
			}
			// 오르막
			else if(beforeHeight==m[index][c]-1) {
				if(cnt < X) {
					return false;
				}
				beforeHeight++; //높아진 높이가 이전의 높이가 됨
				cnt = 1; //새로운 높이이므로 연속 길이도 다시 카운팅해줘야 한다.
			}
			// 높이 2 이상 차이
			else {
				return false;
			}
		}
		return true;
	}

}
