package programmers;

/**
 * 2021.10.17
 * @author Chaerin Yu
 * Bit masking
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟_넘버2 {

	static int answer;
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

    public static int solution(int[] numbers, int target) {
        answer = 0;

    	dfs(numbers, target, numbers[0], 0);
    	dfs(numbers, target, -numbers[0], 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int sum, int idx) {
    	if(idx == numbers.length-1) {
    		if(sum == target) answer++;
    		return;
    	}
    	
    	dfs(numbers, target, sum+numbers[idx+1], idx+1);
    	dfs(numbers, target, sum-numbers[idx+1], idx+1);
    }
}
