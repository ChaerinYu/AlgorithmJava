package etc.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2021.08.23 그래프 인접 행렬
 * @author user
 * Graph BFS, DFS -> 둘 다 중복되지 않게 반복체크를 해야 한다.
 */
public class AdjMatrixTest {

	static int N; // 정점 개수
	static boolean[][] adjMatrix; // 인접행렬 (가중치 없음)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		adjMatrix = new boolean[N][N];
		
		int C = Integer.parseInt(in.readLine()); // 간선 개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		System.out.println("=========================bfs=========================");
		bfs();
		System.out.println("=========================dfs=========================");
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(0, visited);
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char) (current+65)); // 탐색하는 정점
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] // 미방문 
						&& adjMatrix[current][i]) { // 인접정점
					queue.offer(i);
					visited[i] = true;
				}
			}
			
		}
	}
	
	private static void dfs(int current, boolean[] visited) { // 현재 탐색하는 정점

		visited[current] = true;
		System.out.println((char) (current+65)); // 탐색하는 정점

		for (int i = 0; i < N; i++) {
			if(!visited[i] // 미방문 
					&& adjMatrix[current][i]) { // 인접정점
				dfs(i, visited);
			}
		}
	}

}

/**
 * 
입력
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6
출력	
=========================bfs=========================
A
B
C
D
E
F
G
=========================dfs=========================
A
B
D
F
E
C
G
 */
