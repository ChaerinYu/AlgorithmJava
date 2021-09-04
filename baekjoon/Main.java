package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 1949. 우수 마을
 * BFS
 */
public class Main {
	
	static int N; // 마을 수
	static int[] residents; // 각 마을 주민 수
	static ArrayList<ArrayList<Integer>> town; // 마을
	
	static int res = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 마을 수 입력
		N = Integer.parseInt(br.readLine());
		residents = new int[N+1];
		
		// 주민 수 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			residents[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인접마을 arraylist 초기화
		town = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			town.add(new ArrayList<Integer>());
		}
		// 인접 마을 입력
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			town.get(from).add(to);
			town.get(to).add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			boolean[] checked = new boolean[N+1];
			bfs(i, checked, 0);
		}
		System.out.println(res);
		
	}
	static void bfs(int index, boolean[] checked, int total) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		checked[index] = true;
		queue.offer(index);
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			while(queueSize-- > 0) {
				int current = queue.poll();
				
				// 인접된 마을 방문 안하도록 체크
//				ArrayList<Integer> temp = town.get(current);
				for (int i = 0; i < town.get(current).size(); i++) {
					checked[town.get(current).get(i)] = true;
				}
				
				// 남은 마을 중 방문
				for (int i = 1; i <= N; i++) {
					if(!checked[i]) {
						queue.offer(i);
						checked[i] = true;
						break;
					}
				}
				
				total += residents[current];
			}
		}
		res = Math.max(res, total);
	}
}

