package programmers;

/**
 * 2021.10.17
 * @author Chaerin Yu
 * Bit masking
 * 백준 1182와 유사
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟_넘버 {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        // 0 ~ 2^(numbers.length-1)
        for (int i = 0; i < (1 << numbers.length); i++) {
        	int sum = 0;
        	// 0이면(원소 미포함) -, 0 이 아니면(원소 포함) +
        	for (int j = 0; j < numbers.length; j++) {
        		if((i & (1<<j)) != 0) {
        			sum += numbers[j];
        		} else {
        			sum -= numbers[j];
        		}
			}
        	// 타겟 넘버인 경우 answer++
        	if(sum==target) answer++;
		}
        
        return answer;
    }
}
