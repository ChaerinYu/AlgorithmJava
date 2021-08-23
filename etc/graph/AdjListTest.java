package etc.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2021.08.23 그래프 인접리스트
 * @author user
 * Graph BFS, DFS -> 둘 다 중복되지 않게 반복체크를 해야 한다.
 * 출력이 인접행렬과 다르게 나온다.
 * Node(LinkedList)가 아닌 ArrayList써도 되지만, 링크드리스트가 더 빠름
 */
public class AdjListTest {
	
	
	static class Node {
		int vertex; // 인접정점 인덱스
		Node link; // 다음 node
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}

	static int N; // 정점 개수
	static Node[] adjList; // 인접리스트 (가중치 없음)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		adjList = new Node[N];
		
		int C = Integer.parseInt(in.readLine()); // 간선 개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
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
			
			for (Node temp = adjList[current]; temp != null ; temp = temp.link) {
				if(!visited[temp.vertex]) { // 이미 인접한 애들로만 되어 있으므로 방문여부만 체크
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			
		}
	}
	
	private static void dfs(int current, boolean[] visited) { // 현재 탐색하는 정점

		visited[current] = true;
		System.out.println((char) (current+65)); // 탐색하는 정점

		for (Node temp = adjList[current]; temp != null ; temp = temp.link) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex, visited);
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
C
B
E
D
F
G
=========================dfs=========================
A
C
E
F
G
D
B
 */
