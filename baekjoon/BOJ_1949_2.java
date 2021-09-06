package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
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
 * TREE DP, DFS
 * dp[n][0]: n번 마을이 우수 마을이 아닐 때, n번 마을을 루트노드로 하는 하위트리의 마을 주민 수의 총 합
 * n번 마을이 우수 마을이 아닐 경우, n번 자식 마을들 중 우수 마을이 1개 일 때, ..., 자식 마을들이 전체 다 우수 마을 일 때 최대값
 * dp[n][1]: n번 마을이 우수 마을일 때, n번 마을을 루트노드로 하는 하위트리의 마을 주민 수의 총 합
 * n번 마을이 우수 마을 일 경우, n번 자식 마을들이 우수 마을이 아닐 때의 총 합
 * 
 * 참고: https://lotuslee.tistory.com/96
 * https://private-space.tistory.com/39
 */
public class BOJ_1949_2 {
	
	static int N; // 마을 수
	static int[] residents; // 각 마을 주민 수
	static ArrayList<ArrayList<Integer>> town; // 마을
	
	static int[][] dp;
	
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
		
		dp = new int[N+1][2];
		dfs(1, 0);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	static void dfs(int current, int parent) {
		
		for (Integer child : town.get(current)) {
			if (child != parent) {
				// 자식 노드가 부모 노드가 아니라면, 본인마을은 부모 노드로 세팅하여 dfs 진행
				dfs(child, current);
				// 본인 마을이 우수마을이 아니면 인접마을은 우수마을 일 수도 아닐 수도 있다.
				dp[current][0] += Math.max(dp[child][0], dp[child][1]);
				// 본인 마을이 우수마을인 경우 인접 마을은 우수 마을이 아님
				dp[current][1] += dp[child][0];
			}
		}
		
		dp[current][1] += residents[current]; // 현재 본인 마을 주민 수 더하기
		
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