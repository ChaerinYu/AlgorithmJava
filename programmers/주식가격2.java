package programmers;

import java.util.Arrays;
import java.util.Stack;
/**
 * 주식가격
 * @author user
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * 
 * https://girawhale.tistory.com/7
 */
public class 주식가격2 {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(prices)));
	}

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < prices.length; i++) {
			while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				int top = stack.pop();
				answer[top] = i-top;
			}
			stack.push(i);
		}
        
        // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
        while(!stack.isEmpty()) {
        	int top = stack.pop();
        	answer[top] = prices.length - top - 1;
        }
        
        return answer;
    }
}
