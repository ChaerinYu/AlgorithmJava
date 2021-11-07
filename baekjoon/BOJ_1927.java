package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 2021.11.06
 * 1927. 최소 힙
 * @author Chaerin Yu
 *
 */
public class BOJ_1927 {

	static int N; // 연산 개수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				if(queue.size() != 0)
					sb.append(queue.poll()).append("\n");
				else
					sb.append(0).append("\n");
			} else {
				queue.offer(num);
			}
		}
		
		System.out.println(sb.toString());
	}
	
}
