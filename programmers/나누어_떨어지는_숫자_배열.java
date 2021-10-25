package programmers;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 나누어 떨어지는 숫자 배열
 * 21.10.24
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class 나누어_떨어지는_숫자_배열 {

	public static void main(String[] args) {
		int [] arr = new int[] {5, 9, 7, 10};
		int divisor = 5;
		System.out.println(Arrays.toString(solution(arr, divisor)));
	}

    public static int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
			if(num % divisor == 0) {
				list.add(num);
			}
		}
        
        if(list.size() == 0) return new int[] {-1};
        else {
        	int[] answer = new int[list.size()];
        	for (int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}
        	Arrays.sort(answer);
        	return answer;
        }
//        return Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
    }
}
