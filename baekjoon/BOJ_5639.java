package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 5639. 이진 검색 트리
 * Study 15week
 * @author Chaerin Yu
 *
 */
public class BOJ_5639 {

	static StringBuilder sb;
	
	private static class Node {
		int data;
		Node left;
		Node right;
		
		public Node (int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 전위 순회 결과 입력 (root-left-right)으로 후위 순회 결과 출력(left-right-root)
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String input = "";
		while(true) {
			input = br.readLine();
			if(input == null || input.equals("")) {
				break;
			}
			insert(root, Integer.parseInt(input));
		}
		
		
		sb = new StringBuilder();
//		sb.append(root.data).append("\n");
		postOrder(root);
		
		System.out.println(sb.toString());
	}

	private static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		sb.append(root.data).append("\n");
	}

	private static void insert(Node root, int data) {
		if(data < root.data) {
			if(root.left == null) root.left = new Node(data);
			else insert(root.left, data);
		} else {
			if(root.right == null) root.right = new Node(data);
			else insert(root.right, data);
		}
	}
}
