package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [월간 코드 챌린지 시즌3] 빛의 경로 사이클
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/86052
 */
public class 빛의_경로_사이클 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"SL","LR"})));
	}

	static final int[][] delta = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // 하, 좌, 상, 우
	static int ROW, COL;
	static boolean[][][] visited;
	
    public static int[] solution(String[] grid) {
    	ROW = grid.length;
    	COL = grid[0].length();
    	visited = new boolean[ROW][COL][4]; // 네 방향
    	
    	
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				
				for (int k = 0; k < delta.length; k++) {
					if(visited[i][j][k]) continue;
					
					list.add(getCycleLen(i, j, k, grid));
				}
				
			}
		}
        int[] answer = new int[list.size()];
        int idx = 0;
        for (int len : list) {
			answer[idx++] = len;
		}
        Arrays.sort(answer);
        return answer;
    }

	private static Integer getCycleLen(int r, int c, int dir, String[] grid) {
		int len = 0;
		
		while(true) {
			if(visited[r][c][dir]) break;
			visited[r][c][dir] = true;
			len++;
			
			if(grid[r].charAt(c) == 'L') {
				dir = dir != 0 ? dir-1 : 3;
			} else if(grid[r].charAt(c) == 'R') {
				dir = dir != 3 ? dir+1 : 0;
			}
			
			// 좌표는 0이상이므로 모듈러 연산을 통해 다음 좌표를 지정한다.
			r = (r+delta[dir][0] + ROW) % ROW;
			c = (c+delta[dir][1] + COL) % COL;
		}
		
		return len;
	}
    
    
}
