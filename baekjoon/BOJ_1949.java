package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 시간초과로 fail TODO 다시해보기
 * 1949. 우수 마을
 * @author Chaerin Yu
 * 
 * '우수 마을'로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
 * '우수 마을'끼리는 서로 인접해 있을 수 없다.
 * '우수 마을'로 선정되지 못한 마을은 적어도 하나의 '우수 마을'과는 인접해 있어야 한다.
 * 
 * 첫째 줄에 정수 N이 주어진다. (1≤N≤10,000) 둘째 줄에는 마을 주민 수를 나타내는 N개의 자연수가 빈칸을 사이에 두고 주어진다. 
 * 1번 마을부터 N번 마을까지 순서대로 주어지며, 주민 수는 10,000 이하이다. 셋째 줄부터 N-1개 줄에 걸쳐서 인접한 두 마을의 번호가 빈칸을 사이에 두고 주어진다.
 * 
 * 첫째 줄에 '우수 마을'의 주민 수의 총 합을 출력한다.
 * 
 * BFS
 */
public class BOJ_1949 {
	
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
//			System.out.println("from, to:"+ from+", "+to);
			
			town.get(from).add(to);
			town.get(to).add(from);
		}
		
//		System.out.println("abc");
//		int res = Integer.MIN_VALUE;
//		int total = 0;
		for (int i = 1; i <= N; i++) {
			boolean[] checked = new boolean[N+1];
//			bfs(1, checked);
			bfs(i, checked, 0);
		}
		System.out.println(res);
		
	}
	static void bfs(int index, boolean[] checked, int total) {
//		System.out.println("bfs");
//		int total = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		checked[index] = true;
		queue.offer(index);
		
//		total += residents[index];
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			while(queueSize-- > 0) {
				int current = queue.poll();
				
				// 인접된 마을 방문 안하도록 체크
				ArrayList<Integer> temp = town.get(current);
				for (int i = 0; i < temp.size(); i++) {
					checked[temp.get(i)] = true;
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
//		return total;
	}
}

/**
7
1000 3000 4000 1000 2000 2000 7000
1 2
2 3
4 3
4 5
6 2
6 7
=============
14000

*/