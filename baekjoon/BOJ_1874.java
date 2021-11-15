package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 1874. 스택수열
 * @author Chaerin Yu
 * 2021.11.15
 */
public class BOJ_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~n
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int num = 1;
		StringBuilder sb = new StringBuilder();
		// N 크기만큼 for문 돌리기
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(br.readLine());
			
			for (int j = num; j <= now; j++) {
				stack.push(j);
				sb.append("+").append("\n");
				num++;
			}
			while(!stack.isEmpty() && stack.peek() == now) {
				stack.pop();
				sb.append("-").append("\n");
			}
			
		}
		
		// stack 비어있지 않은 경우 => 수열 만들 수 없는 경우
		if(stack.size()>0) {
			System.out.println("NO");
		} else {
			System.out.print(sb.toString());
		}
	}
}
