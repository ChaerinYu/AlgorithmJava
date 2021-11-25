package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 2021.11.25
 * 제로
 * @author Chaerin Yu
 */
public class BOJ_10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // 정수
		
		Stack<Long> stack = new Stack<Long>();
		for (int i = 0; i < K; i++) {
			long num = Long.parseLong(br.readLine());
			
			if(num == 0) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(num);
			}
		}
		
		long ans = 0;
		while(stack.size()>0) {
			ans += stack.pop();
		}
		
		System.out.println(ans);
	}

}
