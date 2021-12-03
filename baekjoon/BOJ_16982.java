package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * Study 13week
 * 2021.12.03
 * 16928. 뱀과 사다리 게임
 * 방향 존재
 * 1번부터 시작해서 100번에 도착해야 한다.
 * 뱀과 사다리가 존재하는 경우 무조건 올라타야 한다.
 * @author Chaerin Yu
 */
public class BOJ_16982 {

	static int N, M; // 사다리, 뱀 수
	static Move[] moves;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사다리
		M = Integer.parseInt(st.nextToken()); // 뱀
		
		moves = new Move[N+M];
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
//			moves[i].from = Integer.parseInt(st.nextToken());
//			moves[i].to = Integer.parseInt(st.nextToken());
			moves[i] = new Move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int ans = bfs(1);
		
		System.out.println(ans);
	}
	
	private static int bfs(int position) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101]; // 위치 방문 체크
		
		queue.offer(position);
		visited[position] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int q = 0; q < size; q++) {
				int now = queue.poll(); // 현재 위치

				if(now == 100) {
					return cnt;
				}
				// 주사위 1~6
				dice: 
					for (int i = 1; i <= 6; i++) {
						
						int nextPos = now + i;
						
						if(nextPos > 100) break; // 100 넘으면 break
						if(visited[nextPos]) continue; // 방문했으면 다음 주사위
						
						for (int j = 0; j < moves.length; j++) {
							if(nextPos == moves[j].from) {
								nextPos = moves[j].to;
								if(visited[nextPos]) continue dice; // 이미 방문한 위치인 경우
								break; // 모든 칸은 최대 하나의 사다리 또는 뱀을 가지고 있으므로 더이상 안봐도 된다.
							}
						}
						queue.offer(nextPos);
						visited[nextPos] = true;
					}
			}
			cnt++;
		}
		return cnt;
	}

	public static class Move {
		int from;
		int to;
		
		public Move() {
			this.from = 0;
			this.to = 0;
		}

		public Move(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

}
/**

2 1
2 60
30 98
65 25

뱀을 타는게 이득일 때도 있다.
*/