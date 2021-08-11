package etc;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 완전 이진 트리
 */
public class CompleteBinaryTree {
	
	private char[] nodes;
	private final int SIZE; // 가변적으로 받아오기 위해서 생성자에서 선언해준다.
	private int lastIndex; // 마지막에 추가된 node의 인덱스
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1]; // index 1부터 시작하므로 1을 더해준다.
	}
	
	public void add(char c) {
		if(lastIndex == SIZE) return;
		nodes[++lastIndex] = c;
	}
	
	public void bfs() {
		// 탐색을 기다리는 노드들이 저장된다.
		// 배열로 관리하므로 탐색할 노드를 관리하는 인덱스를 저장한다.
		Queue<Integer> queue = new LinkedList<Integer>(); // index
		queue.offer(1); // root node의 인덱스 저장
		
		int current = 0; // 탐색할 노드의 인덱스
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			// 왼쪽 자식 인덱스 계산했는데 lastIndex보다 작으면 자식이 있는 거.
			// 자식 노드를 넣어준다.
			if(current*2 <= lastIndex) {
				queue.offer(current*2);
			}
			// 오른쪽 자식 인덱스 도 똑같이 확인해준다.
			if(current*2+1<=lastIndex) {
				queue.offer(current*2+1);
			}
		}
	}
	
	public void bfs2() {
		// 탐색을 기다리는 노드들이 저장된다.
		// 배열로 관리하므로 탐색할 노드를 관리하는 인덱스를 저장한다.
		Queue<Integer> queue = new LinkedList<Integer>(); // index
		queue.offer(1); // root node의 인덱스 저장
		
		int current = 0; // 탐색할 노드의 인덱스
		int level = 0, size = 0; // level: 너비
		while (!queue.isEmpty()) {
			size = queue.size();
			
			System.out.print("level"+level+": ");
			while(--size>=0) {

				current = queue.poll();
				System.out.print(nodes[current]+ " ");
				// 왼쪽 자식 인덱스 계산했는데 lastIndex보다 작으면 자식이 있는 거.
				// 자식 노드를 넣어준다.
				if(current*2 <= lastIndex) {
					queue.offer(current*2);
				}
				// 오른쪽 자식 인덱스 도 똑같이 확인해준다.
				if(current*2+1<=lastIndex) {
					queue.offer(current*2+1);
				}
			}
			System.out.println();
			++level;
		}
	}
	
	// 알아서 루트부터 출력
	public void dfsByPreOrder() {
		System.out.print("Preorder: ");
		dfsByPreOrder(1); // 시작인 root node 호출하여 재귀 시작한다.
		System.out.println();
	}
	
	// 재귀
	private void dfsByPreOrder(int current) {
		// 현재 노드 처리
		System.out.print(nodes[current]+ " ");
		// 왼쪽 자식 노드 방문
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		// 오른쪽 자식 노드 방문
		if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);
	}
	
	// 알아서 루트부터 출력
	public void dfsByInOrder() {
		System.out.print("InOrder: ");
		dfsByInOrder(1); // 시작인 root node 호출하여 재귀 시작한다.
		System.out.println();
	}
	
	// 재귀
	private void dfsByInOrder(int current) {
		// 왼쪽 자식 노드 방문
		if(current*2 <= lastIndex) dfsByInOrder(current*2);
		// 현재 노드 처리
		System.out.print(nodes[current]+ " ");
		// 오른쪽 자식 노드 방문
		if(current*2+1 <= lastIndex) dfsByInOrder(current*2+1);
	}
	
}
