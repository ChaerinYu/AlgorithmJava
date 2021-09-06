package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 17831. 대기업 승범이네
 * @author Chaerin Yu
 * DP, DFS
 */
public class BOJ_17831 {

	static int N; // 판매원 수
	static int[] boss; // 각 판매원의 사수 (1은 무조건 승범이)
	static int[] performance; // 각 판매원의 실적
	
	static ArrayList<ArrayList<Integer>> adjNodes; // 각 판매원 별 가능한 멘티 판매원 
	
	static int[][] dp; // memoization
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 입력
		N = Integer.parseInt(br.readLine()); // 판매원 수

		// 멘토의 멘티들 저장
		adjNodes = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			adjNodes.add(new ArrayList<Integer>());
		}
		
		// 2번 판매원부터 N번 판매원의 사수
		boss = new int[N+1];
		boss[1] = 1; // boss 1은 root이므로 자기자신이 사수
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 2; i <= N; i++) {
			int b = Integer.parseInt(st.nextToken());
			boss[i] = b;
			
			adjNodes.get(b).add(i); // 멘티 입력
		}

		// i번 판매원의 실력을 나타내는 정수 A1, A2, …, AN (0 ≤ Ai ≤ 100)
		performance = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			performance[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		
		dp = new int[N+1][2];
		int res = Math.max(dfs(1, false), dfs(1, true)); // dfs(1, false);
		
		System.out.println(res);
	}
	
	// dp[n][1]: 내가 멘토일 때- 자식이 본인이랑 짝 (멘토링) 이거나, performance[n]+Math.max(performance[n의자식들]) 
	// dp[n][0]: 내가 멘토가 아닐 때- 자식이 자식의 자식이랑 짝 이거나 자식이 아무랑도 짝이 아니거나
	static int dfs(int current, boolean mento) {
		int flag = mento?1:0;
		
		if(dp[current][flag] != 0) return dp[current][flag];

		// 현재 노드가 멘토일 때
		if(mento) {
			// 자식 중 하나는 무조건 멘티
			// 남은 자식들은 최대로 만들어줘야 한다.
			/*
			 * 시간초과 ㅠㅠ
			if(adjNodes.get(current).size() == 0) return dp[current][flag];
			
			int currentMin = Integer.MAX_VALUE;
			int currentMentee = 0;

			for (Integer mentee : adjNodes.get(current)) {
				
				// mentee 선택했을 때와 안했을 때의 차이점
				int diff = Math.max(dfs(mentee, true), dfs(mentee, false))
						- (performance[current]*performance[mentee] + dfs(mentee, false));
				dp[current][flag] += Math.max(dfs(mentee, true), dfs(mentee, false)); // mentee 안 된 경우 고려
				
				if(diff < currentMin) {
					currentMentee = mentee;
					currentMin = diff;
				}
			}
			dp[current][flag] -= Math.max(dfs(currentMentee, true), dfs(currentMentee, false)); // mentee 안 된 경우 고려한 거 빼기
			dp[current][flag] += performance[current]*performance[currentMentee]+dfs(currentMentee, false);
			*/
			
			// 자식노드 모두 멘토 일 때 (나와 멘토링 x)
			int sum1 = 0;
			for (Integer mentee : adjNodes.get(current)) {
				sum1 += dfs(mentee, true);
			}
			
			// 자식노드 중 멘티 있을 때
			int sum2 = 0;
			for (Integer mentee : adjNodes.get(current)) {
				// 자식노드가 모두 나랑 멘토링 하지 않은 경우(자식은 모두 멘토)에서,
				// 현재 자식노드가 멘토인 경우 빼주고, 멘토가 아닌 경우는 더해준다. (나랑 이미 멘토링 하고 있으므로)
				// 그리고 멘토링 관계에서의 시너지를 더해준다.
				sum2 = sum1 - dfs(mentee, true) + dfs(mentee, false) + performance[current] * performance[mentee];
				// 자식 중 누구를 멘티를 뽑을지 선정
				dp[current][flag] = Math.max(dp[current][flag], sum2);
			}
			
			// sum2에서의 max값과 sum1 중 최대값 찾기
			dp[current][flag] = Math.max(dp[current][flag], sum1);
		}
		// 현재 노드가 멘토가 아닐 때 (자식들이 멘토가 되든 안되든 최대값만 가져오면 상관 없다.)
		else {
			int sum = 0;
			for (Integer mentee : adjNodes.get(current)) {
				sum += Math.max(dfs(mentee, false), dfs(mentee, true));
			}
			dp[current][flag] = Math.max(dp[current][flag], sum);
		}
		
		return dp[current][flag];
	}

}
