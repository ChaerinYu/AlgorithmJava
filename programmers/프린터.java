package programmers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 프린터
 * 21.10.25
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class 프린터 {

	static int[] freq = new int[10];
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
	}

    public static int solution(int[] priorities, int location) {
    	Deque<int[]> queue = new LinkedList<int[]>();
    	
    	int max = 0;
    	for (int i = 0; i < priorities.length; i++) {
			queue.offer(new int[] {i, priorities[i]});
			freq[priorities[i]]++; // 각 중요도 등장횟수 저장
			if(priorities[i] > max) max = priorities[i];
		}

//    	System.out.println(max);
    	int answer = 0;
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		// 최대 중요도 아닌 경우 다시 넣기 (맨 위로)
    		if(now[1] != max) {
    			queue.offer(now);
    		} else {
    			// 최대 중요도 만난 경우
    			answer++; // pop
    			
    			// 등장횟수 빼기
    			freq[max]--;
    			// 최대 중요도 등장횟수 다 쓴 경우 다음 중요도로 넘어간다.
    			if(freq[max]==0) {
    				while(max>0 && freq[max] == 0)
    					max--;
    			}
        		if(now[0]==location) {
        			break;
        		}
    		}
    	}
        return answer;
    }
}
