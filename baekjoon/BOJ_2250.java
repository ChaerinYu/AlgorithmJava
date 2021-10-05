package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Study week 5
 * 2250. 트리의 높이와 너비
 * @author Chaerin Yu
 * 어려워ㅠ
 */
public class BOJ_2250 {

	static int N; // 노드 개수 (1 ≤ N ≤ 10,000)
	static Node[] tree;
	
	static int[] leftIdx, rightIdx;
	static int nodeIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 노드 개수
		// 트리 초기화
		tree = new Node[N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			tree[i] = new Node(node, left, right);
		}
		
		// 항상 1이 root가 아님
		int root = 0;
		for (int i = 1; i <= N; i++) {
			if(tree[i].vertex==1) {
				root = i;
				break;
			}
		}

		leftIdx = new int[N+1];
		Arrays.fill(leftIdx, Integer.MAX_VALUE);
		rightIdx = new int[N+1];
		nodeIdx = 1; // 현재 좌표, 방문할 때마다 1 증가
		dfs(root, 1);
		
		// 가장 큰 너비 구하기
		int res = rightIdx[1]-leftIdx[1]+1;
		int level = 1;
		for (int i = 2; i <= N; i++) {
			int temp = rightIdx[i]-leftIdx[i]+1;
			if(temp>res) {
				res = temp;
				level = i;
			}
		}
		
		sb.append(level).append(" ").append(res);
		System.out.println(sb);
	}
	
	/**
	 * inorder 순회
	 * --> 왼쪽-부모-오른쪽 순서로 방문한다.
	 * --> 열 번호 작은 거부터 순차대로 방문
	 * @param index
	 * @param cnt
	 */
	private static void dfs(int index, int cnt) {
		int left = tree[index].left;
		int right = tree[index].right;
		
		if(left != -1) dfs(left, cnt+1);
		// 현재 내 노드가 (해당 레벨에서) 가장 왼쪽인 경우 갱신
		leftIdx[cnt] = Integer.min(leftIdx[cnt], nodeIdx);
		// 현재 내 노드가 (해당 레벨에서) 가장 오른쪽인 경우 갱신
		rightIdx[cnt] = Integer.max(rightIdx[cnt], nodeIdx++);
//		nodeIdx++;
		if(right != -1) dfs(right, cnt+1);
	}

	static class Node {
		int vertex;
		int left;
		int right;
		
		public Node(int vertex, int left, int right) {
			this.vertex = vertex;
			this.left = left;
			this.right = right;
		}
		
	}
}
