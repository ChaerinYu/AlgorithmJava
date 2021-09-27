package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1707. 이분 그래프
 * @author 유채린
 * bfs
 * 시작 노드 색상을 지정하고(1) 시작노드와 연결된 노드들은 반대색상(2)로 지정한다.
 * DFS도 가능
 */
public class BOJ_1707 {

	static final int COLOR1 = 1, COLOR2 = 2;
	static int T; // 테스트 케이스 수
	static int V, E; // 정점 개수, 간선 개수
	
	static ArrayList<ArrayList<Integer>> tree; // 정점 연결 정보
	
	static int[] visited; // 방문여부 0(방문안함), 1, 2(방문 구분 컬러)
	static String res;
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석처리
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			res = "";
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점 개수
			E = Integer.parseInt(st.nextToken()); // 간선 개수
			
			// tree 초기화
			tree = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				tree.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				tree.get(from).add(to); // 양방향이므로 from, to 서로 입력
				tree.get(to).add(from);
			}
			
			visited = new int[V+1];
			for (int i = 1; i <= V; i++) {
				if(visited[i] == 0) {
					bfs(i, COLOR1);
				}
			}
			
			// 이분 그래프인지 아닌지 확인
			if(isBipartite()) res = "YES";
			else res = "NO";
			
			sb.append(res).append("\n");
		}
		
		System.out.print(sb);
	}
	
	/**
	 * 서로 연결된 노드끼리 같은 색이면 이분 그래프 아님
	 * @return
	 */
	static boolean isBipartite() {
		for (int i = 1; i <= V; i++) {
			for (Integer node : tree.get(i)) {
				if(visited[i] == visited[node]) return false;
			}
		}
		return true;
	}
	
	/**
	 * @param start
	 * @param color
	 * 0: 아직 방문 안 한 경우
	 * 1: 방문 컬러 1, 2: 방문컬러 2
	 */
	static void bfs(int start, int color) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		visited[start] = color;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 나랑 연결된 노드는 다른 색상을 가져야 한다.
			if(visited[current] == COLOR1) {
				color = COLOR2;
			}
			else if(visited[current] == COLOR2) {
				color = COLOR1;
			}
			
			for (Integer neighbor : tree.get(current)) {
				if(visited[neighbor] == 0) {
					queue.offer(neighbor);
					visited[neighbor] = color;
				}
			}
		}
	}
	
	private static String src = "2\r\n" + 
			"3 2\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n" + 
			"4 4\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"4 2";
}
