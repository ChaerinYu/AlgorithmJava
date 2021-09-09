package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 13549. 숨바꼭질 3
 * @author ChaerinYu
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
 * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 * 
 * 1697. 숨바꼭질
 */
public class BOJ_13549 {

	static int N, K; // 수빈이, 동생
	static int max; // 수빈이 위치/동생 위치 둘 중 어느 위치가 더 큰지
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		max = Math.max(N, K);
		bfs(N);
	}
	
	static void bfs(int subin) {
		Queue<Integer> queue = new LinkedList<Integer>(); // 수빈이 위치
		Queue<String> teleport = new LinkedList<String>(); // 수빈이가 텔레포트 이용한 횟수 (X 개수)
		boolean[] visited = new boolean[2*max+1]; // 위치 수빈이의 방문 여부
		
		queue.offer(subin);
		teleport.offer("");
		visited[subin] = true; // 방문 체크
		
		int move = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			// 각 단계마다 -1, +1, *2 이동
			while(size-->0) {
				int current = queue.poll(); // 현재 수빈이 위치
				String tp = teleport.poll(); // 현재 수빈이 위치까지 텔레포트 한 횟수 (X 개수)
				
				// 동생만나면 멈춤
				if(current == K) {
					System.out.println(move-tp.length());
					break;
				}

				// x2: 반례 1 2 --> x2부터 실행되도록.ㅠㅠ
				if(current>=0 && current*2<2*max+1 && !visited[current*2]) {
					queue.offer(current*2);
					teleport.offer(tp+"X"); // 텔레포트한 경우 X 넣기
					visited[current*2] = true;
				}
				// -1
				if(current>0 && current-1<2*max+1 && !visited[current-1]) {
					queue.offer(current-1);
					teleport.offer(tp);
					visited[current-1] = true;
				}
				// +1
				if(current+1>=0 && current+1<2*max+1 && !visited[current+1]) {
					queue.offer(current+1);
					teleport.offer(tp);
					visited[current+1] = true;
				}
				
			}
			move++; // 수빈이 위치 업데이트 횟수
		}
		
	}
}
