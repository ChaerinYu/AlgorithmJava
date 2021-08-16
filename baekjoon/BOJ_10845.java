package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 10845. 큐
 */
public class BOJ_10845 {

	private static int N; // 명령어 수
	private static Deque<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			if(command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
			}
			else if(command.equals("pop")) {
				System.out.println(queue.size()==0?-1:queue.poll());
			}
			else if(command.equals("size")) {
				System.out.println(queue.size());
			}
			else if(command.equals("empty")) {
				System.out.println(queue.size()==0?1:0);
			}
			else if(command.equals("front")) {
				System.out.println(queue.size()==0?-1:queue.peek());
			}
			else if(command.equals("back")) {
				System.out.println(queue.size()==0?-1:queue.peekLast());
			}
		}
	}

}
