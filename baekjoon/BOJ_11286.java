package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1 = o1<0 ? -o1 : o1;
				int abs2 = o2<0 ? -o2 : o2;
				// 가장 작은 값 여러 개 인 경우, 가장 작은 수 출력
				if(abs1==abs2) {
					if(o1 < 0) return -1;
					if(o2 < 0) return 1;
				}
				return abs1-abs2;
			}
		});
		
		int N = Integer.parseInt(br.readLine()); // 연산 수
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			
			if(command == 0) {
				if(queue.size() == 0) sb.append(0);
				else sb.append(queue.poll());
				sb.append("\n");
			} else {
				queue.offer(command);
			}
		}
		
		System.out.print(sb.toString());
	}
}
