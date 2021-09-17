package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 17472. 다리 만들기 2
 * @author ChaerinYu
 * 
 */
public class BOJ_17472 {

	static final int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int N, M; // 세로 가로
	static int[][] map;
	static List<Bridge> bridges; // = new ArrayList<Bridge>();
	
	static int island;
	static int[] parents;
	static int res = Integer.MAX_VALUE;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		
		
		map = new int[N][M]; // 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 섬에 번호를 주기 위해 -1로 일단 변경한다.
				if(map[r][c] == 1) {
					map[r][c] = -1;
				}
			}
		}
		
		// DFS를 이용하여 각 섬에 번호를 매겨준다.
		island = 0; // 섬 개수 counting
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] == -1) {
					dfs(r, c, ++island);
				}
			}
		}
		
		// BFS를 이용하여 다리 건설 비용구하기
		// 우선 섬끼리의 건설 가능한 다리 모두 생성해준다.
		bridges = new ArrayList<Bridge>();
		bfs();
		
		
		// MST Kruskal
		parents = new int[island+1];
		make();
		
		Collections.sort(bridges); // 오름차순 정렬
		
		res = 0;
		int bridgeCnt = 0;
		for (Bridge current : bridges) {
			int from = find(current.fromIsland);
			int to = find(current.toIsland);
			if(union(from, to)) {
				res += current.cost;
				if(++bridgeCnt==island-1) break; // 다리의 수는 섬의 수 -1
			}
		}
		
		// 부모(대표)가 다른 경우 => 연결이 안되었다는 의미
		int p = find(parents[1]);
		for (int i = 2; i <= island; i++) {
			if(find(parents[i]) != p) {
				res = -1;
				break;
			}
		}
		
		sb.append(res);
		System.out.println(sb);
	}

	/**
	 * 지도 돌면서, 육지 만났을 때 사방탐색 시작하기
	 * 사방탐색시, 한 방향으로만 계속 진행되어야 하므로 안에서 while문 돌린다.
	 */
	static void bfs() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] == 0) continue;
				
				for (int i = 0; i < delta.length; i++) {
					int cnt = 0; int nr = r, nc = c;
					// 한 방향으로만 직진
					while(true) {
//							System.out.println("bfs");
						nr += delta[i][0];
						nc += delta[i][1];
						// 범위 체크
						// 출발 섬인 경우 다리건설 불가
						if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc] == map[r][c]) {
							break;
						}
						// 바다(0)인 경우
						else if(map[nr][nc] == 0){
							cnt++;
						}
						// 도착 섬 만남 -> 도착! 길이가 2이상인 다리만 건설 가능
						else {
							if(cnt>1)
								bridges.add(new Bridge(map[r][c], map[nr][nc], cnt));
							break;
						}
					}
				}
			}
		}
	}
	/**
	 * 섬에 번호 매기기 (라벨링)
	 * @param sr
	 * @param sc
	 * @param num
	 */
	static void dfs(int sr, int sc, int num) {
		map[sr][sc] = num;
		for (int i = 0; i < delta.length; i++) {
			int nr = sr+delta[i][0];
			int nc = sc+delta[i][1];
			
			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
			if(map[nr][nc]==-1) {
				dfs(nr, nc, num);
			}
		}
	}

	/*
	 * kruskal algorithm
	 * make, find, union
	 */
	private static void make() {
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i <= island; i++) {
			parents[i] = i;
		}
	}
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a; // 자신이 대표자
		// 자신이 속한 집합의 대표자를 자신의 부모로 바꾼다. path compression
		return parents[a] = find(parents[a]);
	}
	
	// 두 원소를 하나의 집합으로 합치기 (대표자를 이용해서 합침)
	// return값을 가질 필요는 없지만 
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않음
		
		// 오른쪽(b) 대표를 왼쪽(a) 대표로
		parents[bRoot] = aRoot;
		return true;
	}
	
	// 다리 클래스
	static class Bridge implements Comparable<Bridge>{
		int fromIsland;
		int toIsland;
		int cost;
		
		public Bridge(int fromIsland, int toIsland, int cost) {
			this.fromIsland = fromIsland;
			this.toIsland = toIsland;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge o) {
			// 건설비용으로 오름차순
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	private static String src = "10 8\r\n" + 
			"0 0 1 1 1 1 1 0\r\n" + 
			"1 1 1 1 1 1 0 1\r\n" + 
			"0 0 0 1 0 1 0 0\r\n" + 
			"1 1 0 1 1 0 1 1\r\n" + 
			"0 0 1 1 0 1 1 0\r\n" + 
			"0 1 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 0 0 1 0\r\n" + 
			"1 0 0 1 1 1 0 0\r\n" + 
			"1 1 0 0 0 1 1 1\r\n" + 
			"1 1 1 0 0 1 0 1";
}
