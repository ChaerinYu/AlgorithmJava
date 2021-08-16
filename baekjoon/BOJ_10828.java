package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 10828. 스택
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 */
public class BOJ_10828 {

	private static int N; // 명령어 수
	private static Stack<Integer> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			if(command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(new Integer(num));
			}
			else if(command.equals("pop")) {
				System.out.println(stack.size()==0?-1:stack.pop());
			}
			else if(command.equals("size")) {
				System.out.println(stack.size());
			}
			else if(command.equals("empty")) {
				System.out.println(stack.size()==0?1:0);
			}
			else if(command.equals("top")) {
				if(stack.size()==0) System.out.println(-1);
				else System.out.println(stack.peek());
			}
		}
	}

}
