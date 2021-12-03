package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 연산 수
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// Math.abs 함수 말고 삼항연산 사용
				int abs1 = o1<0 ? -o1 : o1;
				int abs2 = o2<0 ? -o2 : o2;
				
				// 절댓값이 가장 작은 값이 여러개일 때
				if(abs1==abs2) {
					if(o1 < 0) return -1;
					if(o2 < 0) return 1;
				}
				
				// 절댓값 오름차순 정렬
				return abs1-abs2;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) {
				queue.offer(x);
			} else {
				if(!queue.isEmpty()) {
					sb.append(queue.poll());
				} else {
					sb.append(0);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}

}
