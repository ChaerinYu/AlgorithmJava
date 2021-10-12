package programmers;

import java.util.Arrays;

/**
 * 2021.10.12
 * 로또의 최고 순위와 최저 순위
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/77484#fn1
 */
public class 로또의_최고_순위와_최저_순위 {

	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] answers = solution(lottos, win_nums);
		System.out.println(Arrays.toString(answers));
	}
	
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int[] nums = new int[46]; // 0~45 정수
        
        int matches = 0, zeroNum = 0; // matches: 로또랑 맞는 경우 zeroNum: 지워진 수 갯수
        for (int i = 0; i < win_nums.length; i++) {
        	nums[win_nums[i]]++; // 이번주 로또 번호 더하기
		}
        // 내 로또 번호랑 비교하기
        for (int i = 0; i < lottos.length; i++) {
        	// 0보다 큰 경우 -> 겹치는 수
			if(nums[lottos[i]]>0) {
				matches++;
				continue;
			}
			// 0 = 지워진 수
			if(lottos[i]==0) {
				zeroNum++;
			}
		}
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 맞춘 번호 수에 따른 등수
        answer[0] = rank[matches+zeroNum];
        answer[1] = rank[matches];
        return answer;
    }
	
}
/**
class Solution {
public int[] solution(int[] lottos, int[] winNums) {
    return LongStream.of(
            (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
            (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
    )
            .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
            .toArray();
}
}
**/