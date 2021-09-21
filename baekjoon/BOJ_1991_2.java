package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Study week 3
 * 1991. 트리 순회
 */
public class BOJ_1991_2 {

	public static int N; // 이진트리 노드 개수
	static char[][] tree; // 트리
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		tree = new char[26][2]; // 알파벳별 왼쪽 오른쪽 자식 저장
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char child1 = st.nextToken().charAt(0);
			char child2 = st.nextToken().charAt(0);
			
			tree[parent-'A'][0] = child1; // 왼
			tree[parent-'A'][1] = child2; // 오
		}
		
		// 항상 A가 루트 노드가 된다.
		preOrderDFS('A'); // 전위
		System.out.println();
		inOrderDFS('A'); // 중위
		System.out.println();
		postOrderDFS('A'); // 후위
	}
	
	// 전위 순회
	static void preOrderDFS(char node) {
		if(node == '.') return;
		System.out.print(node);
		preOrderDFS(tree[node-'A'][0]);
		preOrderDFS(tree[node-'A'][1]);
	}
	// 중위 순회
	static void inOrderDFS(char node) {
		if(node == '.') return;
		inOrderDFS(tree[node-'A'][0]);
		System.out.print(node);
		inOrderDFS(tree[node-'A'][1]);
	}
	// 후위 순회
	static void postOrderDFS(char node) {
		if(node == '.') return;
		postOrderDFS(tree[node-'A'][0]);
		postOrderDFS(tree[node-'A'][1]);
		System.out.print(node);
	}
}

