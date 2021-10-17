package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2021.10.17
 * 두 개 뽑아서 더하기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * HashSet이 아닌 TreeSet을 사용하면 add하면서 정렬도 같이 됩니다.
 * return set.stream().sorted().mapToInt(Integer::intValue).toArray();
 */
public class 두_개_뽑아서_더하기 {

	static Set<Integer> set;
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2,1,3,4,1})));
	}

    public static int[] solution(int[] numbers) {
    	
    	set = new HashSet<Integer>();
    	
    	// numbers 길이가 0~100이므로 2중 for문해줘도 속도 문제 없음
    	for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
    	
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
			answer[idx++] = num;
		}
        
        Arrays.sort(answer); // 정렬
        return answer;
    }
}
