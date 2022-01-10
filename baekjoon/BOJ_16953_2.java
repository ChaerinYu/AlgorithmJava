package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 2022.01.10
 * Study 17week
 * @author Chaerin Yu
 * 16953. A → B
 * set말고 배열 사용하니 메모리초과..!
 */
public class BOJ_16953_2 {

	static class Node {
		long number;
		int count;
		
		public Node(long number, int count) {
			this.number = number;
			this.count = count;
		}
	}
	
	final static int MAX = 2_000_000_001;
	static int A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[] visited = new boolean[MAX];
		
		queue.add(new Node(A, 1));
		visited[A] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			// B와 같으면 멈춘다.
			if(now.number == B) {
				System.out.println(now.count);
				return;
			}
			
			// 현재 숫자가 B의 2배이상인 경우 -> 절대 답을 구할 수 없는 경우
			if(now.number > 2*B) {
				continue;
			}

			// 2배
			if(!visited[(int) (now.number*2)]) {
				visited[(int) (now.number*2)] = true;
				queue.offer(new Node(now.number*2, now.count+1));
			}
			// 뒤에 +1하기
			long temp = Long.parseLong(String.valueOf(now.number) + "1");
			if(visited[(int) temp]) {
				visited[(int) temp] = true;
				queue.offer(new Node(temp, now.count+1));
			}
		}
		System.out.println(-1);
	}

}
