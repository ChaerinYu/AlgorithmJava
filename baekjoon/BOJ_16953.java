package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 2022.01.10
 * Study 17week
 * @author Chaerin Yu
 * 16953. A → B
 */
public class BOJ_16953 {

	static class Node {
		long number;
		int count;
		
		public Node(long number, int count) {
			this.number = number;
			this.count = count;
		}
	}
	
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
		Set<Long> visited = new HashSet<Long>();
		
		queue.add(new Node(A, 1));
		visited.add((long) A);
		
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

			// SET은 중복이 안되므로 이미 존재하는 숫자라면 SET 크기가 그대로이다.
			int prevSize = visited.size();
			// 2배
			visited.add(now.number*2);
			if(visited.size() != prevSize) {
				queue.offer(new Node(now.number*2, now.count+1));
				prevSize = visited.size();
			}
			// 뒤에 +1하기
			long temp = Long.parseLong(String.valueOf(now.number) + "1");
			visited.add(temp);
			if(visited.size() != prevSize) {
				queue.offer(new Node(temp, now.count+1));
			}
		}
		System.out.println(-1);
	}

}
