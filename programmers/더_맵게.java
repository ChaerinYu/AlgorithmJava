package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * @author ChaerinYu
 * 2021.10.13
 */
public class 더_맵게 {

	public static void main(String[] args) {
		int[] scoville = {};
		int k = 0;
		int answer = solution(scoville, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();
        Arrays.sort(scoville);
        
        int cnt = 0, totalSpicy = 0; // cnt: 스코빌 지수 체크한 음식 수, totalSpicy: cnt까지의 스코빌 총합
        for(int spicy:scoville) {
            list.add(spicy);
            cnt++;
            totalSpicy += spicy;
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1 return
            if(cnt>=2 && totalSpicy==0) return -1;
        }
        
        // peek()가 K보다 작은 경우에만 진행한다.
        while(list.peek()<K) {
            if(list.size()<2) return -1; // priorityQueue 크기가 1인 경우 return
            
            int first = list.poll();
            int second = list.poll();
            
            list.add(first+second*2); // 섞은 음식의 스코빌 지수
            
            answer++;
        }
        
        return answer;
    }
}
