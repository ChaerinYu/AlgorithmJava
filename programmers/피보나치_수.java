package programmers;

public class 피보나치_수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	long[] dp = new long[100_001];
    
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }
        return (int) dp[n];
    }
}
