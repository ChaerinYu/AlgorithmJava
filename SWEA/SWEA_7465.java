package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/**
 * [D4] 7465. 창용 마을 무리의 개수
 * @author user
 * 창용 마을에는 N명의 사람이 살고 있다. 사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.
 * 두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다. 
 * 두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면, 이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.
 * 창용 마을에 몇 개의 무리가 존재하는지 계산하는 프로그램을 작성하라.
 * 
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 * 각 테스트 케이스의 첫 번째 줄에는 각각 창용 마을에 사는 사람의 수와 서로를 알고 있는 사람의 관계 수를 나타내는
 * 두 정수 N, M(1 ≤ N ≤ 100, 0 ≤ M ≤ N(N-1)/2) 이 공백 하나로 구분되어 주어진다.
 * 이후 M개의 줄에 걸쳐서 서로를 알고 있는 두 사람의 번호가 주어진다.
 * 
 * kruskal
 */
public class SWEA_7465 {
	
	static int[] parents; // 누가 대표(부모)인지 저장하는 배열
	
	// 부모 배열 생성하기
	private static void make() {
		parents = new int[N+1]; // 배열 생성
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// 부모 찾기
	private static int find(int a) {
		if(a==parents[a]) return a;
		// 자신이 속한 집합의 대표자(root)를 자신의 부모(인접)로 바꾼다.
		return parents[a] = find(parents[a]);
	}
	
	// 합치기
	private static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if(aParent == bParent) return;
		parents[bParent] = aParent;
	}
	
	static int N, M; // 사람 수(정점 vertex), 간선 (edge)
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new int[M][2];
			int from = 0, to = -1;
			String[] input = null;
			for (int i = 0; i < M; i++) {
//				st = new StringTokenizer(br.readLine(), " ");
				input = br.readLine().split(" ");
				
				from = Integer.parseInt(input[0]);
				// from만 값이 들어오는 경우가 있음..
				to = -1; // from만 값이 입력될 때 to값 -1로 해준다.
				if(input.length != 1)
					to = Integer.parseInt(input[1]);
				
				graph[i][0] = from;
				graph[i][1] = to;
			}
			
			// 오름차순 정렬
			Arrays.sort(graph, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
				
			});
			
			make(); // 부모(대표자) 생성
			
			// 간선 for문
			int a, b;
			for (int i = 0; i < M; i++) {
				a = graph[i][0];
				b = graph[i][1];
				if(b != -1)
					union(a, b); // 같은 무리로 묶기
			}
			
			// 내 자신이 대표인 경우 res++
			int res = 0;
			for (int i = 1; i <= N ; i++) {
				if(parents[i] == i) res++;
			}
			System.out.println("#"+tc+" "+res);
		}
	}
}
/**
1
7 3
1 3
3 4
6
#1 5
*/