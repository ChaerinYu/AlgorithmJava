package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 11779. 최소비용 구하기2
 * @author user
 * Study 15week
 */
public class BOJ_11779 {

	static final int INF = 1_000_000_001;
	
	static int n, m; // 도시 수, 버스 수
	static ArrayList<Bus>[] busList;
	
	static int resCost; // 최소 비용
//	static int resCityNum; // 경로에 포함된 도시 개수
	static ArrayList<Integer> resCityList; // 방문 도시 
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 도시 수 1≤n≤1,000
		m = Integer.parseInt(br.readLine()); // 버스 수 1≤m≤100,000
		
		// m 말고 n..
		busList = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			busList[i] = new ArrayList<Bus>();
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 출발지
			int end = Integer.parseInt(st.nextToken());   // 도착지
			int cost = Integer.parseInt(st.nextToken());  // 비용
			
			busList[start].add(new Bus(end, cost));
//			busList[end].add(new Bus(start, cost)); // 양방향아닌 단방향
		}
		
		st = new StringTokenizer(br.readLine());
		int sCity = Integer.parseInt(st.nextToken()); // 출발 도시
		int dCity = Integer.parseInt(st.nextToken()); // 도착 도시
		
		resCityList = new ArrayList<Integer>();
		resCost = dijkstra(sCity, dCity);
		
		StringBuilder sb = new StringBuilder();
		sb.append(resCost).append("\n").append(resCityList.size()).append("\n");
		for (int i = resCityList.size()-1; i >= 0; i--) {
			sb.append(resCityList.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static int dijkstra(int sCity, int dCity) {
		PriorityQueue<Bus> pq = new PriorityQueue<Bus>();
		
		int[] sum = new int[n+1];
		Arrays.fill(sum, INF);
		int[] routes = new int[n+1]; // 직전 방문 도시 저장
		
		// 출발지 입력
		pq.add(new Bus(sCity, 0));
		sum[sCity] = 0;
		routes[sCity] = 0; // 직전 방문 도시 없음 (0)

		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			int curPos = now.position;
			
			if(sum[curPos] < now.cost) continue; // sum 배열에 저장된 값보다 비용이 비싼 경우
//			resCityList.add(curPos);
			
			for (Bus bus : busList[curPos]) {
				if(sum[bus.position] > sum[curPos]+bus.cost) {
					sum[bus.position] = sum[curPos]+bus.cost;
					pq.add(new Bus(bus.position, sum[bus.position]));
					routes[bus.position] = curPos; // bus.position에 직전 방문 도시(curPos) 저장
				}
			}
		}

		int p = dCity;
		// 직전 노드가 0이 아닌 경우 -> 출발지
		while(p != 0) {
			resCityList.add(p);
			p = routes[p];
		}
//		System.out.println("size: "+resCityList.size());
//		resCityList.add(dCity);
//		resCityNum = resCityList.size();
		return sum[dCity];
	}

	public static class Bus implements Comparable<Bus>{
		int position;
		int cost;
		
		public Bus(int position, int cost) {
			this.position = position;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}

}
