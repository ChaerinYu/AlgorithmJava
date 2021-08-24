package etc.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int start = 0;
		int end = V-1; // 도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V]; // 간선의 정보 받을 배열
		int[] distance = new int[V]; // 시작점에서 index까지의 최소 비용 저장
		boolean[] visited = new boolean[V]; // 방문 여부 확인하는 배열
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()); // 간선의 정보 받아옴
			}
		}
		
		Arrays.fill(distance, INFINITY); // 배열 초기화 -> 각 정점부터 최소비용저장 배열 초기화
		
		distance[start] = 0; // 시작점-시작점 거리는 0이니까
		
		int min = 0, current = 0;
		for (int i = 0; i < V; i++) {
			// 전체 정점 탐색
			// 1단계: 방문하지 않는 정점들 중, 최소가중치의 정점 선택
			min = INFINITY;
			for (int j = 0; j < V; j++) {
				// 방문하지 않은 정점이면서 최소 가중치보다 작으면 업데이트
				if(!visited[j] && min>distance[j]) {
					// 최소 가중치 업데이트
					min = distance[j];
					// 정점 선택
					current = j;
				}
			}
			
			visited[current] = true; // 선택 정점 방문 처리
			
			// 선택 정점이 도착 정점이면 탈출
			if(current == end) break;
			
			// 2단계 current 정점을 경유지로 해서 갈 수 있는 다른 방문하지 않은 정점들을 처리
			for (int j = 0; j < V; j++) {
				// 방문하지 않은 정점이면서, 간선이 이어져 있고, 경유지+가중치 값이 distance에 저장된 최소 가중치보다 작다면 업데이트
				if(!visited[j] && matrix[current][j] != 0 && distance[j]>min+matrix[current][j]) {
					distance[j] = min+matrix[current][j];
				}
			}
		}
		
		System.out.println(distance[end]);
	}
}
/**
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8

4
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
output==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

output==> 14
*/