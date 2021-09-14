package etc.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 아파트 색칠하기 
 * @author ChaerinYu
 * 2021.09.03 DP를 이용
 * 아파트를 각 층별로 파란색 또는 노란색 페인트로 칠하되 다음과 같은 규칙으로 칠하려고 한다.
 * 노란색은 인접한 두 층에 연속하여 사용할 수 있다.
 파란색은 인접한 두 층에 연속하여 사용할 수 없다.
 */
public class DP_210914 {

	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 3;
		
		go(N);
		
		System.out.println(dp[N]);
	}
	
	static int go (int n) {
		for (int i = 3; i <= n; i++) {
			if(i>2 && dp[i]==0) {
				dp[i] = dp[i-1]+dp[i-2];
			}
		}
		return dp[n];
	}

}
/*
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc  = new Scanner(System.in);
	int N = sc.nextInt(); // 몇층까지 아파트를 칠한건지 받아오기
	int[][] memo = new int[N+1][2];
	
	//memo[n][0] = 노란색으로 칠할때
	//memo[n][1] = 파란색으로 칠할때
	memo[1][0] = 1;
	memo[1][1] = 1;
	for(int i=2; i<=N; i++) {
		memo[i][0] = memo[i-1][0]+memo[i-1][1];
		memo[i][1] = memo[i-1][0];
	}
	
	System.out.println(memo[N][0]+memo[N][1]);
	
}
*/
