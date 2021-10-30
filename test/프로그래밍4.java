package test;

import java.util.Arrays;

public class 프로그래밍4 {
	
	public static void main(String[] args) {
		int[][] logs = {
				 {1, -7, -2, 1, -1}
				,{2, 3, 0, -1, -2}
				,{1, -1, 6, -1, -2}
				,{-1, 1, -2, 0, 4}
				,{-10, 5, -3, -1, 1}
		};
		System.out.println(solution(logs));
	}

	private static final int[][] delta = {{1, 0}, {0, 1}}; // 오른쪽 혹은 아래쪽 칸으로만 이동할 수 있습니다.
	// dijkstra
    private static int[][] dp; // 각 배열 최소 값 저장
	private static int answer ;
	
	public static int solution(int[][] board) {
        
        dp = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
			Arrays.fill(dp[i], -100_000_000); // 최소값 저장
		}
        dp[0][0] = 0; // 출발점
        answer = Integer.MIN_VALUE;
        dfs(0, 0, board[0][0], board);
        
        return answer;
    }

	static void dfs(int sr, int sc, int num, int[][] board) {
		// 도착
		if(sr == board.length-1 && sc == board.length-1) {
			answer = Math.max(answer, num);
			return;
		}
		
		// 오른쪽/아래로 이동
		for (int d = 0; d < delta.length; d++) {
			int nr = sr+delta[d][0];
			int nc = sc+delta[d][1];

			if(nr<0 || nc<0 || nr>=board.length || nc>= board.length) continue; // 범위
			
			int temp = dp[sr][sc];
			
			if(board[nr][nc] == 0) {
				// 이동할 칸이 0일때에는 부호 바꿀 수 있음
				if(temp < 0) temp = -temp;
				// 기존 값보다 최대값인 경우 dfs 재귀
				if(dp[nr][nc] < temp) {
					dp[nr][nc] = temp;
					dfs(nr, nc, temp, board);
				}
			} else {
				// 기존 값보다 최대값인 경우 dfs 재귀
				if(dp[nr][nc] < temp+board[nr][nc]) {
					dp[nr][nc] = temp+board[nr][nc];
					System.out.println("nr,nc: " +nr+", "+nc+": "+dp[nr][nc]);
					dfs(nr, nc, temp+board[nr][nc], board);
				}
			}
		}
	}
}
