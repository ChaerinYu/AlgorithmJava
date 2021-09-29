package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 1194. 달이 차오른다, 가자.
 * @author ChaerinYu
 * 0 -> 1 이동
 * # 벽
 * . 빈 곳
 * 소문자 알파벳: 키
 * 대문자 알파벳: 문
 */
public class BOJ_1194 {

	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M; // 세로, 가로  (1 ≤ N, M ≤ 50) 
	static char[][] maze; // 미로
	
	static int minsikR, minsikC; // 처음 민식이위치
	
	static int res; // 정답
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		minsikR = 0; minsikC = 0; // 민식이 위치
		boolean findMinsik = false;
		// 미로 입력
		maze = new char[N][M];
		for (int r = 0; r < N; r++) {
			maze[r] = br.readLine().toCharArray();
			
			if(findMinsik) continue;
			// 민식이 위치, 출구 위치 찾기
			for (int c = 0; c < M; c++) {
				// 민식이 현재 위치
				if(maze[r][c]-'0'==0) {
					minsikR = r; minsikC = c;
					maze[r][c] = '.'; // 민식이 위치를 빈 곳('.')으로 설정
					findMinsik = true;
				}
			}
		}
		
		res = -1;
		bfs(minsikR, minsikC, 0, 0);
		
		sb.append(res);
		
		System.out.println(res);
	}
	
	/**
	 * 
	 * @param minsikR 처음 민식이 세로 좌표
	 * @param minsikC 처음 민식이 가로 좌표
	 * @param move 민식이가 움직인 횟수(시작값)
	 * @param key 민식이가 갖고 있는 키 (시작값)
	 */
	private static void bfs(int minsikR, int minsikC, int move, int key) {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 비트마스킹으로 key(a~f)갖고 방문했는지 체크
		boolean[][][] visited = new boolean[N][M][1<<6]; // 1~6: a~f 각각 갖고 있는지 안갖고 있는지
		
		// queue에는 현재 민식이 위치, 이동횟수, 갖고 있는 키를 넣는다. (int형식 배열: 0 ~ (2^6)-1)
		queue.offer(new int[] {minsikR, minsikC, move, key});
		visited[minsikR][minsikC][key] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			int nMove = current[2], nKeys = current[3];
//			if(maze[current[0]][current[1]]-'0' == 1) {
//				res = nMove;
//				return;
//			}
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nr = current[0]+delta[i][0];
				int nc = current[1]+delta[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(visited[nr][nc][nKeys]) continue;
				
				// 벽: 절대 이동할 수 없다.
				if(maze[nr][nc]=='#') {
					continue;
				}
				// 빈 곳
				else if(maze[nr][nc]=='.') {
					visited[nr][nc][nKeys] = true;
					queue.offer(new int[] {nr, nc, nMove+1, nKeys});
				}
				// 열쇠 (소문자)
				else if(maze[nr][nc]>='a' && maze[nr][nc]<='f') {
					int k = 1 << (maze[nr][nc]-'a'); // 열쇠 줍줍
					int newKeys = nKeys | k; // 새로운 열쇠 list 갱신
					if(!visited[nr][nc][newKeys]) { // 방문체크
						visited[nr][nc][newKeys] = true;
						queue.offer(new int[] {nr, nc, nMove+1, newKeys});
					}
				}
				// 문 (대문자)
				else if(maze[nr][nc]>='A' && maze[nr][nc]<='F') {
					int k = 1 << (maze[nr][nc]-'A'); // 문 열기 위해 필요한 키
					
					// 0이 아니면 key를 갖고 있다는 의미
					if((nKeys & k) != 0) {
						visited[nr][nc][nKeys] = true;
						queue.offer(new int[] {nr, nc, nMove+1, nKeys});
					}
				}
				// 1 (도착)
				else if (maze[nr][nc] == '1'){
					res = nMove+1;
					return;
				}
			}
		}
	}


	private static String src = "8 7\r\n" + 
			"1FD...b\r\n" + 
			"AC....a\r\n" + 
			"#.....#\r\n" + 
			"#cd....\r\n" + 
			"1BD....\r\n" + 
			"AC.....\r\n" + 
			"#.....#\r\n" + 
			"......0\r\n" + 
			"";
}
