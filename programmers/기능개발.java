package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * @author ChaerinYu
 *
 */
public class 기능개발 {
	public static void main(String[] args) {
		int[] progresses = {2, 2, 1, 2};
		int[] speeds = {1, 1, 1, 1};
		
		int[] answer = solution(progresses, speeds);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 각 프로세스마다 걸리는 일 수
        int[] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            
            int progress = progresses[i];
            // 100%될 때 까지 days ++
            while(progress<100) {
                progress += speeds[i];
                days[i]++;
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = days[0];
        int ans = 1;
        for(int i=1; i<progresses.length; i++) {
            // 이전 최대 일 수보다 오래 걸리는 경우
        	if(max>=days[i]) {
                ans++;
            } else {
                list.add(ans);
                max = days[i];
                ans = 1;
            }
        }
        list.add(ans); // 마지막 배열 입력
        
        // array에 입력
        answer = new int[list.size()];
        int idx = 0;
        for(Integer num : list) {
            answer[idx++] = num;
        }
        return answer;
    }
}
/** 
public int[] solution(int[] progresses, int[] speeds) {
int[] dayOfend = new int[100];
int day = -1;
for(int i=0; i<progresses.length; i++) {
    while(progresses[i] + (day*speeds[i]) < 100) {
        day++;
    }
    dayOfend[day]++;
}
return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
}
**/