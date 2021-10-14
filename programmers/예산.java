package programmers;

import java.util.Arrays;

/**
 * 예산
 * 2021.10.14
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 * 조합
 */
public class 예산 {

	static int answer;
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,3,2,5,4}, 9));
	}
	
	public static int solution(int[] d, int budget) {
        answer = 0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
            budget -= d[i];
            answer++;
            if(budget<0) answer--;
            else if(budget==0) break;
        }
        
        return answer;
    }
}
