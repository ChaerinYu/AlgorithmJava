package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 프린터 큐
 * @author user
 * 2021.11.16
 * 프로그래머스 프린터 문제와 동일
 */
public class BOJ_1966 {

	static int N, M;
	static int[] freq; // 각 중요도 등장횟수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			// 문서 개수
			N = Integer.parseInt(st.nextToken());
			// 현재 문서 위치
			M = Integer.parseInt(st.nextToken());
			
			Deque<int[]> queue = new LinkedList<int[]>();
			freq = new int[10];
			st = new StringTokenizer(br.readLine());
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				int importance = Integer.parseInt(st.nextToken());
				queue.add(new int[] {importance, i});
				freq[importance]++;
				
				if(max < importance) max = importance;
			}
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				int[] now = queue.peek();
				if(now[0] == max) {
					queue.poll();
					cnt++;
					
					freq[max]--; // 등장횟수 빼기
					
					// 다음 중요도
					if(freq[max]==0) {
						while(max>0 && freq[max] == 0) max--;
					}
					
					if(now[1] == M) {
						break;
					}
				} else {
					queue.offer(queue.poll());
				}
			}
			System.out.println(cnt);
		}

	}

}
