package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021.10.21
 * 게임 맵 최단거리
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 */
public class 게임_맵_최단거리 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
	}

	static int n, m, res;
	static final int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int solution(int[][] maps) {
    	n = maps.length;
    	m = maps[0].length;
        
    	res = -1;
    	bfs(0, 0, maps);
    	
        return res;
    }
    
	private static void bfs(int sr, int sc, int[][] maps) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		
		queue.offer(new int[] {sr, sc, 1});
		visited[sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
//			System.out.println(now[0]+", "+now[1]);
			if(now[0] == n-1 && now[1] == m-1) {
				if(res == -1 || res > now[2])
				res = now[2];
//				return;
			}
			for (int i = 0; i < deltas.length; i++) {
				int nr = now[0]+deltas[i][0];
				int nc = now[1]+deltas[i][1];
				
				if(nr>=n || nr<0 || nc>=m || nc<0) continue;
				if(visited[nr][nc]) continue;
				if(maps[nr][nc]!=1) continue;
//				System.out.println(nr+", "+nc+": "+maps[nr][nc]);
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc, now[2]+1});
			}
		}
	}
    
}
