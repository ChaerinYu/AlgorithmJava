package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2021.10.17
 * 두 개 뽑아서 더하기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * 조합 이용
 */
public class 두_개_뽑아서_더하기2 {

	static Set<Integer> set;
	static boolean[] visited;
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2,1,3,4,1})));
	}

    public static int[] solution(int[] numbers) {
    	
    	set = new HashSet<Integer>();
    	visited = new boolean[numbers.length];
    	combination(0, 0, 0, numbers);
    	
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
			answer[idx++] = num;
		}
        
        Arrays.sort(answer); // 정렬
        return answer;
    }
    
    private static void combination(int index, int cnt, int sum, int[] numbers) {
    	if(cnt == 2) {
    		set.add(sum);
    		return;
    	}
    	for (int i = index; i < numbers.length; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			combination(i+1, cnt+1, sum+numbers[i], numbers);
    			visited[i] = false;
    		}
		}
    }
}
