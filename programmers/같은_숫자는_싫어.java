package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 21.10.23
 * 같은 숫자는 싫어
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class 같은_숫자는_싫어 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
	}
	
	public static int[] solution(int []arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        int prev = -1;
        for(int a : arr) {
            if(prev != a) {
                nums.add(a);
            }
            prev = a;
        }
        int[] answer = new int[nums.size()];
        int idx = 0;
        for(int a : nums) {
            answer[idx++] = a;
        }
        return answer;
    }
}
