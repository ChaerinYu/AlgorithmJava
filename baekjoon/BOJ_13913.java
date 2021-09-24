package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * Study week 4
 * 13913. 숨바꼭질 4
 * @author ChaerinYu
 * 
 */
public class BOJ_13913 {

	static int N, K; // 수빈이 위치, 동생 위치
	static int max; // 수빈 vs 동생 위치 중 더 큰 값 저장
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석 처리
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈
		K = Integer.parseInt(st.nextToken()); // 동생
		
		max = 2*Integer.max(N, K); // 수빈 vs 동생 위치 중 더 큰 값 저장
		bfs();
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>(); // bfs
		int[] trace = new int[2*max+1]; // 수빈이 현재 위치의 전 위치 
		// trace[현재 수빈이 위치] = 수빈이 이전 위치
		boolean[] visited = new boolean[2*max+1]; // bfs 방문 여부 체크
		
		queue.offer(new int[] {N, 0}); // 0: 현재 수빈 위치, 1: 현재 위치까지 오는 데 걸린 시간
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			// current[0]: 현재 수빈이 위치, current[1]: 현재 위치까지 오는 데 걸린 시간(초)
			
			// 동생 위치 도착
			if(current[0] == K) {
				sb.append(current[1]).append("\n"); // 걸린 시간 출력
				
				// stack에 담기 (LIFO)
				Stack<Integer> stack = new Stack<Integer>();
				int temp = current[0];
				while(temp != N) {
					stack.push(temp);
					temp = trace[temp];
				}
				stack.push(N);
				// pop
				while(!stack.isEmpty()) {
					sb.append(stack.pop()).append(" ");
				}
//				sb.setLength(sb.length()-1);
				sb.append("\n");
				return;
			}
			
			// x2
			if(current[0]*2<=max && !visited[current[0]*2]) {
				queue.offer(new int[] {current[0]*2, current[1]+1});
				trace[current[0]*2] = current[0];
				visited[current[0]*2] = true;
			}
			// +1
			if(current[0]+1<=max && !visited[current[0]+1]) {
				queue.offer(new int[] {current[0]+1, current[1]+1});
				trace[current[0]+1] = current[0];
				visited[current[0]+1] = true;
			}
			
			// -1
			if(current[0]-1>=0 && !visited[current[0]-1]) {
				queue.offer(new int[] {current[0]-1, current[1]+1});
				trace[current[0]-1] = current[0];
				visited[current[0]-1] = true;
			}
		}
	}
	
	private static String src = "4 7";
}
