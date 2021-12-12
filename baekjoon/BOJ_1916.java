package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 1916. 최소비용 구하기
 * @author Chaerin Yu
 * 2021.12.10
 * 1504와 유사
 * Study 14week
 */
public class BOJ_1916 {

	static final int INF = Integer.MAX_VALUE;
	static int N, M; // 도시 수, 버스 수
	static ArrayList<Bus>[] busList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 도시 수
		M = Integer.parseInt(br.readLine()); // 버스 수
		
		busList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			busList[i] = new ArrayList<Bus>();
		}
		
		StringTokenizer st = null;
		// 버스정보 입력 -> 양방향아님
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 출발지
			int dest = Integer.parseInt(st.nextToken()); // 도착지
			int cost = Integer.parseInt(st.nextToken()); // 비용
			
			busList[start].add(new Bus(dest, cost));
//			busList[dest].add(new Bus(start, cost));
		}
		
		// 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호
		st = new StringTokenizer(br.readLine());
		int sCity = Integer.parseInt(st.nextToken());
		int dCity = Integer.parseInt(st.nextToken());
		
		int res = dijkstra(sCity, dCity); // 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
		
		System.out.println(res);
	}

	private static int dijkstra(int sCity, int dCity) {
		PriorityQueue<Bus> pq = new PriorityQueue<Bus>();
		int[] sum = new int[N+1];
		Arrays.fill(sum, INF);
		
		pq.add(new Bus(sCity, 0)); // 출발지
		sum[sCity] = 0;
		
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			int nextCity = now.dest;
			
			if(sum[nextCity] < now.cost) continue; // 다음 정류소보다 현재 정류소보다 저렴한 경우 continue
			
			for (Bus bus : busList[nextCity]) {
				if (sum[bus.dest] > sum[nextCity] + bus.cost) {
					sum[bus.dest] = sum[nextCity] + bus.cost;
					pq.add(new Bus(bus.dest, sum[bus.dest]));
				}
			}
		}
		
		return sum[dCity];
	}

	// Comparable<Bus>
	public static class Bus implements Comparable<Bus>{
		int dest; // 도착지
		int cost; // 비용
		
		public Bus(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		public int compareTo(Bus b) {
			return Integer.compare(this.cost, b.cost);
//			return this.cost-b.cost;
		}
	}
}
