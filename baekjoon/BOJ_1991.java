package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* TODO 다시 코드 짜야 함
 * 1991. 트리 순회
 */
public class BOJ_1991 {

	private static int N; // 이진트리 노드 개수
	private static Stack<Character> aStack;
	private static Stack<Character> stack;
	private static Stack<Node> children;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		aStack = new Stack<Character>();
		stack = new Stack<Character>();
		children = new Stack<Node>();
		
		stack.push('0');

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char child1 = st.nextToken().charAt(0);
			char child2 = st.nextToken().charAt(0);
			
			stack.push(parent);
			children.push(new Node(parent, child1, child2));
//			System.out.println(parent);
//			System.out.println(stack.search(parent));
//			if(stack.isEmpty() || stack.search(parent) == -1)
//				stack.push(parent);
//			if(children.search(parent-'0') != -1) {
//				children.remove(parent-'0');
//			}
//			if(child1 != '.') 
//				children.push(child1);
//			if(child2 != '.')
//				children.push(child2);
			
		}
		
		for (int i = 0; i < N; i++) {
			
		}
		
		preOrderDFS(1);
		System.out.println();
		inOrderDFS(1);
		System.out.println();
		postOrderDFS(1);
		System.out.println();
	}
	
	private static void preOrderDFS(int current) {
		System.out.print(stack.get(current)+" ");
		if(current*2 <= N) preOrderDFS(current*2);
		if(current*2+1 <= N) preOrderDFS(current*2+1);
	}
	private static void inOrderDFS(int current) {
		if(current*2 <= N) inOrderDFS(current*2);
		System.out.print(stack.get(current)+" ");
		if(current*2+1 <= N) inOrderDFS(current*2+1);
	}
	private static void postOrderDFS(int current) {
		if(current*2 <= N) postOrderDFS(current*2);
		if(current*2+1 <= N) postOrderDFS(current*2+1);
		System.out.print(stack.get(current)+" ");
	}
}

class Node {
	char parent;
	char child1;
	char child2;
	
	Node(char parent, char child1, char child2) {
		this.parent = parent;
		this.child1 = child1;
		this.child2 = child2;
	}
}
