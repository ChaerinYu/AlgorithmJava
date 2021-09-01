package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Study week 1
 * 1697. 숨바꼭질
 * @author ChaerinYu
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 * 
 * [D4] 1238. [S/W 문제해결 기본] 10일차 - Contact 와 유사
 */
public class BOJ_1697 {
	static int res; // 정답
	static boolean[] visited; // 방문 체크
	
	static int max; // 수빈이 위치/동생 위치 둘 중 어느 위치가 더 큰지
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 수빈이 위치
		int K = Integer.parseInt(input[1]); // 동생 위치
		
		max = Math.max(N, K);
		visited = new boolean[2*max+1]; 
		bfs(N, K, 0);
		
		System.out.println(res);
	}
	
	static void bfs(int subin, int sister, int move) {
		Queue<Integer> queue = new LinkedList<Integer>(); // queue선언
		queue.offer(subin); // 수빈이 현재 위치 push
		visited[subin] = true; // 수빈이 현재 위치 방문
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			// 각 단계마다 +1, -1, *2 세 가지 방식으로 이동 가능하다.
			while(queueSize-- > 0) {
				int current = queue.poll();
				
				// 수빈이 위치가 동생 위치일 경우 멈춘다.
				if(current == sister) {
					res = move;
					break;
				}
				
				// 곱하기 2
				if(current>=0 && current*2<2*max+1 && !visited[current*2]) {
					queue.offer(current*2);
					visited[current*2] = true;
				}
				// 더하기 1
				if(current+1>=0 && current+1<2*max+1 && !visited[current+1]) {
					queue.offer(current+1);
					visited[current+1] = true;
				}
				// 빼기 1
				if(current>0 && current-1<2*max+1 && !visited[current-1]) {
					queue.offer(current-1);
					visited[current-1] = true;
				}
				
			}
			move++;
		}
		
	}
}
