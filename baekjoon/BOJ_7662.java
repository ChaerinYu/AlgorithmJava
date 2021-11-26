package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7662 {

	static HashMap<Integer, Integer> map ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			
			int k = Integer.parseInt(br.readLine()); // 연산 개수
			
			PriorityQueue<Integer> asc = new PriorityQueue<Integer>();
			PriorityQueue<Integer> desc = new PriorityQueue<Integer>(Collections.reverseOrder());
			map = new HashMap<Integer, Integer>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String oper = st.nextToken(); // 연산 (D or I)
				int n = Integer.parseInt(st.nextToken()); // 정수
				
				// D 1: Q에서 최대값 삭제, D -1: 최소값 삭제
				if("D".equals(oper)) {
					if(!map.isEmpty()) {
						if(n==1) {
							delete(desc);
						} else {
							delete(asc);
						}
					}
				} else if("I".equals(oper)) {
					asc.offer(n);
					desc.offer(n);
					map.put(n, map.getOrDefault(n, 0)+1);
				}
			}
			
			if(map.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(delete(desc)).append(" ");
				if(!map.isEmpty()) sb.append(delete(asc));
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}

	private static int delete(PriorityQueue<Integer> queue) {
		int res = 0;
		while(true) {
			res = queue.poll();
			
			int cnt = map.getOrDefault(res, 0);
			if(cnt == 0) continue;
			if(cnt > 1) map.put(res, cnt-1);
			else map.remove(res);
			break;
		}
		
		return res;
	}

}
