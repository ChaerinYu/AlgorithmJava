package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_PRIM {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			long answer = 0;
			
			st = new StringTokenizer(in.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
			for(int i=0;i<v;i++) {
				adjList.add(new ArrayList<>());
			}
			
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				
				adjList.get(a).add(new int[] {b, c});
				adjList.get(b).add(new int[] {a, c});
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
			pq.offer(new int[] {0, 0});
			
			boolean[] visited = new boolean[v];
			
			int cnt = 0;
			
			while(!pq.isEmpty()) {
				int node = pq.peek()[0];
				int w = pq.peek()[1];
				pq.poll();
				
				if(visited[node]) continue;
				visited[node] = true;
				
				answer += w;
				
				for(int[] ab: adjList.get(node)) {
					if(!visited[ab[0]]) {
						pq.offer(ab);
					}
				}
				
				if(++cnt == v) {
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
