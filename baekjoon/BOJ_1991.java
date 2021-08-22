package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 1991. 트리 순회
 */
public class BOJ_1991 {

	public static int N; // 이진트리 노드 개수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char child1 = st.nextToken().charAt(0);
			char child2 = st.nextToken().charAt(0);
			
			tree.add(parent, child1, child2);
		}
		
		tree.preOrderDFS(tree.curNode);
		System.out.println();
		tree.inOrderDFS(tree.curNode);
		System.out.println();
		tree.postOrderDFS(tree.curNode);
	}
}

class Tree {
	Node curNode;
	
	public void add(char data, char leftChild, char rightChild) {
		// tree에 데이터 있는 경우 탐색 시작
		if(curNode != null) {
			search(curNode, data, leftChild, rightChild);
		} else {
			// data가 .이 아니라면 data를 갖는 노드 생성
			if(data != '.') curNode = new Node(data);
			
			if(leftChild != '.') curNode.leftChild = new Node(leftChild);
			if(rightChild != '.') curNode.rightChild = new Node(rightChild);
		}
	}
	
	public void search(Node parent, char data, char leftChild, char rightChild) {
		// 만약 부모노드가 null 이면 종료
		if(parent == null) return;
		
		// 부모노드의 데이터가 (parameter) data라면
		if(parent.data == data) {
			if(leftChild != '.') parent.leftChild = new Node(leftChild);
			if(rightChild != '.') parent.rightChild = new Node(rightChild);
		}
		// 못찾았으면 부모노드의 왼쪽자식, 오른쪽자식으로 다시 검색
		else {
			search(parent.leftChild, data, leftChild, rightChild);
			search(parent.rightChild, data, leftChild, rightChild);
		}
	}
	// 전위 순회
	public void preOrderDFS(Node curNode) {
		System.out.print(curNode.data);
		if(curNode.leftChild != null) preOrderDFS(curNode.leftChild);
		if(curNode.rightChild != null) preOrderDFS(curNode.rightChild);
	}
	// 중위 순회
	public void inOrderDFS(Node curNode) {
		if(curNode.leftChild != null) inOrderDFS(curNode.leftChild);
		System.out.print(curNode.data);
		if(curNode.rightChild != null) inOrderDFS(curNode.rightChild);
	}
	// 후위 순회
	public void postOrderDFS(Node curNode) {
		if(curNode.leftChild != null) postOrderDFS(curNode.leftChild);
		if(curNode.rightChild != null) postOrderDFS(curNode.rightChild);
		System.out.print(curNode.data);
	}
}

// 노드
class Node {
	char data;
	Node leftChild;
	Node rightChild;
	
	Node(char data, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	Node(char data) {
		this.data = data;
	}
}
