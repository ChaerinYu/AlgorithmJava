package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 5430. AC
 * @author Chaerin Yu
 * 2021.11.07
 * 정규식 공부 하자...
 */
public class BOJ_5430 {

	static int T, N; // 테스트 케이스 수, 배열에 들어가는 수 개수
	static char[] p; // 수행할 함수 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			
			
			p = br.readLine().toCharArray(); // 수행할 함수 배열
			N = Integer.parseInt(br.readLine()); // 배열 숫자 수
//			char[] arr = br.readLine().replaceAll("[^0-9]", "").toCharArray(); // 와 ㅎㅎ이거때문에 계속 틀림..
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			Deque<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
//				queue.offer(arr[i]-'0');
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = false;
			boolean order = true;
			for (int i = 0; i < p.length; i++) {
				char oper = p[i];
				if(oper == 'D') {
					if(queue.size() != 0) {
						if(order)
							queue.pollFirst();
						else 
							queue.pollLast();
					} else {
						flag = true;
						break;
					}
				}
				else if(oper == 'R') {
					order = !order;
				}
			}
			
			if(!flag) {
				sb.append("[");
				if(!queue.isEmpty()) {
					if(order) {
						while(!queue.isEmpty())
							sb.append(queue.pollFirst()).append(",");
					} else {
						while(!queue.isEmpty())
							sb.append(queue.pollLast()).append(",");
					}
					sb.setLength(sb.length()-1);
				}
				sb.append("]");
			} else {
				sb.append("error");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
