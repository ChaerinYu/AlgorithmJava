package programmers;

import java.util.HashSet;
import java.util.Set;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 * @author ChaerinYu
 */
public class 폰켓몬 {
	
    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> n = new HashSet<Integer>(); // set은 중복이 없음
        
        // nums 배열에 있는 숫자를 입력한다.
        for(int i=0; i<nums.length; i++) {
            n.add(nums[i]);
        }
        
        // set 크기가 nums.length/2보다 크면 nums.length/2로, (nums.length/2만 뽑으니까)
        // 아니면 set크기로 출력해준다.
        answer = nums.length/2 < n.size() ? nums.length/2 : n.size();
        
        return answer;
    }
}
