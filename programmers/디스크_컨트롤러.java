package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2021.11.07
 * @author Chaerin Yu
 * 디스크 컨트롤러
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class 디스크_컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = {
			{0, 3}, {1, 9}, {2, 6}
		};
		System.out.println(solution(jobs));
	}
	
    public static int solution(int[][] jobs) {
        
    	// 작업수행 없을 때, 요청시간 빠른 작업부터
        // 요청시간+소요시간 작은 순서
        // 같은 경우, 대기시간 빠른 게 먼저
    	
    	// 요청시간 오름차순 정렬 
    	Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
    	
    	// 소요시간 오름차순 정렬
    	PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
    		
		});
    	
    	int answer = 0, end = 0, count = 0; // 수행되고 난 직후의 시간, 수행된 요청 수
    	int jobsIdx = 0; // jobs 배열 인덱스
    	
    	while(count < jobs.length) {
    		
    		// 하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣는다.
    		while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
    			queue.offer(jobs[jobsIdx++]);
    		}
    		
    		// queue 비어있으면 요청시간 빠른 애 부터 시작
    		if(queue.isEmpty()) {
    			end = jobs[jobsIdx][0];
    		}
    		// 작업 끝나기 전, 들어온 요청 중 가장 소요시간이 짧은 요청부터 한다.
    		else {
    			int[] now = queue.poll();
    			answer += end + now[1] - now[0];
    			end += now[1];
    			count++;
    		}
    	}
    	
    	return (answer / jobs.length);
    	
    	/*
        Arrays.sort(jobs, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[1] == o2[1]) {
        			return Integer.compare(o1[0], o2[0]);
        		}
        		return Integer.compare(o1[1], o2[1]);
//        		if((o1[0]+o1[1])==(o2[0]+o2[1])) {
//        			return Integer.compare(o1[0], o2[0]);
//        		}
//        		return Integer.compare((o1[0]+o1[1]), (o2[0]+o2[1]));
        	}
		});
    	int answer = 0;
    	for (int i = 0; i < jobs.length; i++) {
    		answer += answer + jobs[i][1] - jobs[i][0];
    	}
        */
        
//    	int answer = 0;
//    	while(!queue.isEmpty()) {
//    		int[] now = queue.poll();
//    		answer += answer + now[1] - now[0];
//    	}
//    	
//        
//        return answer/3;
    }
}
