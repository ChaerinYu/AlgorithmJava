package programmers;

import java.util.Stack;

/**
 * 2021.10.20 
 * 다트 게임
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class 다트_게임 {

	public static void main(String[] args) {
		System.out.println(solution("1D2S#10S"));
	}
	
	public static int solution(String dartResult) {
		int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
		char[] arr = dartResult.toCharArray();
		int num = 0;
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]-'0'>=0 && arr[i]-'0'<=10) {
				// 10일 때 고려
				if(arr[i]=='1') {
					if(i+1<arr.length && arr[i+1]=='0') {
						i++;
						stack.push(10);
					} else {
						stack.push(1);
					}
				} else {
					stack.push(arr[i]-'0');
				}
			} else {
				switch(arr[i]) {
					case 'S':
						break;
					case 'D':
						num = stack.pop();
						num = (int) Math.pow(num, 2);
						stack.push(num);
						break;
					case 'T':
						num = stack.pop();
						num = (int) Math.pow(num, 3);
						stack.push(num);
						break;
					case '*': // 중첩가능, 바로 전 점수까지 2배로
						int start = stack.size() > 2 ? stack.size()-2 : 0;
						for (int j = start; j < stack.size(); j++) {
							stack.set(j, stack.get(j)*2);
						}
						break;
					case '#':
						num = stack.pop();
						num = -num;
						stack.push(num);
						break;
					default:
						break;
				}
			}
		}
        
        for (int number : stack) {
        	System.out.println(number);
			answer += number;
		}
        
        return answer;
    }

}
