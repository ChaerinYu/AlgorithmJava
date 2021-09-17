package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2021.09.17 과제
 * 1767. [SW Test 샘플문제] 프로세서 연결하기
 * @author ChaerinYu
 * dfs
 */
public class SWEA_1767 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int T, N; // 테스트케이스 수, 가로(세로) 길이
	static int[][] processor; // 프로세서
	static ArrayList<int[]> coreList; // 코어 리스트 (가장자리 제외)
	static int coreMaxCnt; // 전선 연결된 코어 수
	static int res; // 정답 (전선 수)
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new StringReader(src)); // 제출 시 주석처리 필요
		
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			coreList = new ArrayList<>();
			res = Integer.MAX_VALUE;
			coreMaxCnt = 0;
			
			N = Integer.parseInt(br.readLine()); // 가로세로 길이
			// 프로세서 입력
			processor = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					processor[r][c] = Integer.parseInt(st.nextToken());
					// 전선 위치 입력 (가장자리 제외)
					if (processor[r][c] == 1 
							&& r != 0 && r != N - 1 && c != 0 && c != N - 1) {
						coreList.add(new int[] {r, c});
					}
						
				}
			}
			
//			bfs(); // bfs로 풀려고 했으나 배열복사 등 시간, 메모리 소모 크다?
			dfs(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth, int coreCnt, int len) {
		// 코어 수 만큼 도달했을 때 멈춘다.
		if(depth == coreList.size()) {
			// 전선이 연결된 코어 수보다 지금 파라미터로 넘어온 값이 더 큰 경우 값 바꿔준다.
			if(coreCnt > coreMaxCnt) {
				coreMaxCnt = coreCnt;
				res = len;
			} else if(coreCnt == coreMaxCnt) {
				// 코어 수 같은 경우에는 전선 길이만 보고 짧은 애 선택
				res = Integer.min(res, len);
			}
			return;
		}
		
		// coreList에 있던 r, c 좌표 꺼내기
		int r = coreList.get(depth)[0];
		int c = coreList.get(depth)[1];
		
		// 사방탐색 시작
		for (int i = 0; i < delta.length; i++) {
			int nr = r, nc = c;
			int cnt = 0;
			// 한 방향으로만 생성 가능
			while(true) {
				nr += delta[i][0];
				nc += delta[i][1];
				// 범위 체크
				if(nr<0||nc<0||nr>=N||nc>=N) {
					break;
				}
				// core나 전선 있는 경우 멈춰야 함
				// !=0 이 아닌 == 1 쓴 경우 이전 dfs에서 2로 적용한거 고려 못 함
				if(processor[nr][nc] != 0) {
					cnt = 0;
					break;
				}
				// 그 외 (0 일 때) 전선 길이 증가
				else {
					cnt++;
				}
			} // while end
			
			// 전선 있는 경우
			if(cnt!=0) {
				// 전선 표시 (여기서 전선을 2라고 한다.)
				int originR = r, originC = c;
				for (int j = 0; j < cnt; j++) {
					originR += delta[i][0];
					originC += delta[i][1];
					
					processor[originR][originC] = 2; // 전선 2
				}
				
				// 코어 선택 후 연결
				dfs(depth+1, coreCnt+1, len+cnt);
				
				// 전선 표시 지우기
				originR = r; originC = c;
				for (int j = 0; j < cnt; j++) {
					originR += delta[i][0];
					originC += delta[i][1];
					
					processor[originR][originC] = 0; // 전선 제거
				}
			}
		} // delta end
		dfs(depth+1, coreCnt, len); // 아무 전선도 연결 못하는 경우 고려
	}
	
	private static String src = "3\r\n" + 
			"7\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"1 1 0 1 0 0 0\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"9\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 1\r\n" + 
			"11\r\n" + 
			"0 0 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 1 0 0\r\n" + 
			"0 1 0 1 1 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"";
}
