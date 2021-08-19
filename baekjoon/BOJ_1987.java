package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1987. 알파벳
 * @author user
 * 백트래킹
 */
public class BOJ_1987 {

	static int R;
	static int C;
	
	static char[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
	static int cnt = 1; // 세기
	static int res = 1; // 정답
	static boolean[] checked; // 알파벳 중복 체크
	
//	static HashSet<Character> alpha = new HashSet<Character>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			char[] lineArr = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = lineArr[c];
			}
		}
		
		checked = new boolean[26];
//		alpha.add(map[0][0]);
//		checked[0][0] = true;
		backtracking(0, 0) ;
		
		System.out.println(res);
	}

	static void backtracking(int sr, int sc) {
		
		checked[map[sr][sc]-'A'] = true;
		
		for (int i = 0; i < dir.length; i++) {
			int nr = sr+dir[i][0];
			int nc = sc+dir[i][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C && !checked[map[nr][nc]-'A']) {
//				알파벳 중복 체크
//				int prevAlphaNum = alpha.size();
//				alpha.add(map[nr][nc]);
//				int nowAlphaNum = alpha.size();
//				
//				if(prevAlphaNum==nowAlphaNum) continue;
				
				cnt++;
				res = Math.max(cnt, res);
				backtracking(nr, nc);
			} else {
				continue;
			}
		}
		// 초기화 안해주면 안됨
		-- cnt;
		checked[map[sr][sc]-'A'] = false;
	}
}
