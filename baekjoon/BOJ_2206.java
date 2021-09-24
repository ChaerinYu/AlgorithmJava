package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 2206. 벽 부수고 이동하기
 * @author ChaerinYu
 * 반례 모음: https://www.acmicpc.net/board/view/66299
 * 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
 * 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
 * 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 
 * 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
 * 만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
 * 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 
 * 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.
 * 첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.
 * 
 * 말이 되고픈 원숭이와 유사
 */
public class BOJ_2206 {

	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static int N, M; // 세로, 가로
	static int[][] map;
	
	static int res; // 답
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M]; // 지도
		for (int r = 0; r < N; r++) {
			String[] tempArr = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				// 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳
				map[r][c] = Integer.parseInt(tempArr[c]);
			}
		}
		
		res = -1;
		bfs(0, 0, 1); // 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
		
		sb.append(res);
		System.out.println(sb);
	}
	
	static void bfs(int sr, int sc, int cnt) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][][] visited = new boolean[N][M][2]; // 0: 그냥 방문, 1: 벽 부수고 방문
		
		int crash = 1; // 벽 부술 수 있는 회수
		queue.offer(new int[] {sr, sc, cnt, 0}); // 0, 1: 좌표, cnt: 이동 수, crash: 벽 부신 수
		visited[sr][sc][crash] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			// N, M 도착 시 멈춤
			if(current[0]==N-1&&current[1]==M-1) {
				res = current[2];
                return;
			}
			crash = current[3];
			
			// 사방 탐색 (인접한 칸)
			for (int d = 0; d < 4; d++) {
				int nr = current[0]+delta[d][0];
				int nc = current[1]+delta[d][1];
				
				if(nr<0||nr>=N||nc<0||nc>=M) continue;

				// 벽 부수기 가능 - 최대 1번 가능
				if(crash<1) {
					if(nr<0||nr>=N||nc<0||nc>=M) continue;
					// 벽
					if(!visited[nr][nc][crash+1]) {
						queue.offer(new int[] {nr, nc, current[2]+1, crash+1});
						visited[nr][nc][crash+1] = true;
					}
				}
				// 빈 공간
				if(map[nr][nc] == 0 && !visited[nr][nc][crash]) {
					queue.offer(new int[] {nr, nc, current[2]+1, crash});
					visited[nr][nc][crash] = true;
				}
			}

		}
		
	}

	private static String src = "8 8\r\n" + 
			"01000100\r\n" + 
			"01010100\r\n" + 
			"01010100\r\n" + 
			"01010100\r\n" + 
			"01010100\r\n" + 
			"01010100\r\n" + 
			"01010100\r\n" + 
			"00010100";
}
