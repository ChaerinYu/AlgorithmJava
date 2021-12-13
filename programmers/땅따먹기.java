package programmers;
/**
 * 2021.12.13
 * 땅따먹기
 * @author user
 * DP
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */
public class 땅따먹기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    int solution(int[][] land) {
        int answer = 0;
        
        int len = land.length;
        int[][] dp = new int[len][4];
        for(int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        for(int i=1; i<len; i++) {
            for(int j=0; j<4; j++) {
                int max = 0;
                for(int k=0; k<4; k++) {
                    if(j==k) continue;
                    if(max < dp[i-1][k]) {
                        max = dp[i-1][k];
                    }
                }
                dp[i][j] = land[i][j]+max;
            }
        }
        
        answer = 0;
        for(int i=0; i<4; i++) {
            if(answer < dp[len-1][i])
                answer = dp[len-1][i];
        }
        return answer;
    }
}
