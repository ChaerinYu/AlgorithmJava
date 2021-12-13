package programmers;

import java.util.Stack;

public class 큰_수_만들기 {

	public static void main(String[] args) {
		System.out.println(solution("1231234", 3));
	}


    public static String solution(String number, int k) {
        char[] arr = number.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        
        int cnt = k;
        for (char c : arr) {
			while(!stack.isEmpty() && stack.peek() < c-'0' && cnt > 0) {
				stack.pop();
				cnt--;
			}
			stack.push(c-'0');
		}
        
        while(stack.size() > arr.length-k) {
        	stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
