package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 2021.10.16
 * 2019 KAKAO BLIND RECRUITMENT
 * 실패율
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class 실패율 {

	public static void main(String[] args) {
		int N = 8;
		int[] stages = {1,2,3,4,5,6,7};
		
		int[] answers = solution(N, stages);
		System.out.println(Arrays.toString(answers));
	}
	
	public static int[] solution(int N, int[] stages) {
        
        int users = stages.length; // 사용자 수
        int[] remains = new int[N+1]; // 스테이지에 남아있는 사용자 수
        
        for(int n: stages) {
        	// n이 N보다 큰 경우-> 모든 스테이지 클리어
        	if(n <= N) {
        		remains[n]++;
        	}
        }
        
        ArrayList<Stage> queue = new ArrayList<Stage>();
        // 1~N 스테이지
        for(int i=1; i<=N; i++) {
//        	System.out.println(remains[i]/ (double) (users));
        	// 마지막 스테이지 아무도 못간 경우 등.. 이런 케이스 고려해줘야 됨 
        	// 안 그럼 0으로 나누는 경우 발생하여 INF
        	if(users != 0)
        		queue.add(new Stage(i, remains[i]/ (double) (users)));
        	else 
        		queue.add(new Stage(i, 0));
        	// 남은 유저 수 계산
        	users -= remains[i];
        }

        Collections.sort(queue, new Comparator<Stage>() {

			@Override
			public int compare(Stage o1, Stage o2) {
				// 실패율 같은 경우, 스테이지 번호 내림차순으로 출력
				if(Double.compare(o1.rate, o2.rate) == 0) {
					return Integer.compare(o1.stage, o2.stage);
				}
				// 실패율 높은 순서로 출력
				return -Double.compare(o1.rate, o2.rate);
			}
		});
        
        int[] answer = new int[N];
        int idx = 0;
        for (Stage stage : queue) {
			answer[idx++] = stage.stage;
		}
        
        return answer;
    }
	
	static class Stage {
		int stage; // 스테이지 번호
		double rate; // 실패율
		
		public Stage(int stage, double rate) {
			super();
			this.stage = stage;
			this.rate = rate;
		}
		
	}
}
