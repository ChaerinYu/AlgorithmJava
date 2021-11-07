package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 11279. 최대 힙
 * @author Chaerin Yu
 * 2021.11.07
 */
public class BOJ_11279 {

	static int N; // 연산 개수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 연산 개수
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
			
		});
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(queue.isEmpty()) 
					sb.append(0).append("\n");
				else 
					sb.append(queue.poll()).append("\n");
			} else {
				queue.offer(input);
			}
		}
		
		System.out.println(sb.toString());
	}
}
