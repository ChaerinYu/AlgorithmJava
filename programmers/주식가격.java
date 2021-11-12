package programmers;

import java.util.Arrays;
/**
 * 주식가격
 * @author user
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(prices)));
	}

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < answer.length; i++) {
			for (int j = i+1; j < answer.length; j++) {
				answer[i] += 1;
				if(prices[i] > prices[j]) break;
			}
		}
        
        return answer;
    }
}
