package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 동식님 코드..
 * @author 동식 박..
 * 16812kb	220ms
 * sysout과 전역 stringBuilder랑 성능차이 큼
 */
class BOJ_5639_2 {

	// 전위 순회한 결과, 노드 수
	static int[] preorder;
	static int N;
	static StringBuilder sb;

	public static void main(String args[]) throws IOException {

		sb = new StringBuilder();
		// 일단 노드 수의 최대 크기로 잡음
		preorder = new int[10000];

		
		// 입력...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			preorder[N++] = Integer.parseInt(input);
		}

		// 재귀
		preToPost(0, N);
		System.out.println(sb);

	}

	static void preToPost(int from, int to) {
		//루트 노드
		int root = preorder[from];
		
		// 전위순회 (root-left-right)이므로 루트를 제외하고 자식탐색해야 하므로 right이 아니라 right+1부터!!
		
		//자신보다 크면서 제일 앞에 있는 오른쪽 자식 노드 찾기
		int rightChild = to;
		for (int i = from + 1; i < to; i++) {
			if (preorder[i] > root) {
				rightChild = i;
				break;
			}
		}

		//왼쪽 자식이 있다면 왼쪽 탐색
		if (from + 1 < rightChild) {
			preToPost(from + 1, rightChild);
		}
		//오른쪽 자식이 있다면 오른쪽 탐색
		if (rightChild < to) {
			preToPost(rightChild, to);
		}

		//후위 순회이므로 루트 노드를 마지막으로 출력
		sb.append(root).append('\n');
	}

}