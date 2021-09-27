package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 6987. 월드컵
 * @author Chaerin Yu
 * 네 가지 결과에 대하여 가능한 결과는 1, 불가능한 결과는 0을 빈칸을 하나 사이에 두고 출력한다.
 * 조합?
 */
public class BOJ_6987 {

	static int[][] games; // 4개조 6개국 승,무,패 경기
	static int[][] matches; // 팀 경기
	
	static boolean isAvailable; // 게임 시작 가능한지
	static boolean isEnd; // 게임 결과가 가능한지 (끝까지)
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
		// index로 팀 경기 나눈다.
		matches = new int[15][2]; // 6팀 경기 수 총 15번
		int index = 0;
		for(int i = 0; i < 6-1; i++) {
			for(int j = i + 1; j < 6; j++) {
				matches[index][0] = i;
				matches[index][1] = j;
				index++;
			}
		}
		
		// 4개조
		for (int t = 0; t < 4; t++) {
			games = new int[6][3]; // 6개국 승, 무, 패
			
			isAvailable = true; // 가능한 게임인지
			isEnd = false; // 끝까지 게임 가능한지
			st = new StringTokenizer(br.readLine());
			int win, draw, lose;
			int w=0, d=0, l=0;
			for (int i = 0; i < 6; i++) {
				win = Integer.parseInt(st.nextToken()); // 승
				draw = Integer.parseInt(st.nextToken()); // 무
				lose = Integer.parseInt(st.nextToken()); // 패
				
				games[i][0] = win;
				games[i][1] = draw;
				games[i][2] = lose;
				
				w+=win; d+=draw; l+=lose;
				if(win+draw+lose != 5) { // 한 팀이 진행한 경기가 5경기가 안되는 경우
					isAvailable = false;
					break;
				}
			}
			
			if(isAvailable) {
				// 총 경기 수가 30경기가 안되는 경우
				if(w+d+l != 30) isEnd = false;
				else {
					dfs(0);
				}
			} else {
				isEnd = false;
			}
			
			if(!isEnd) sb.append(0);
			else sb.append(1);
			sb.append(" ");
			
			isEnd = false; // 초기화
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if(isEnd) {
			return;
		}
		// 15경기까지 다 한 경우,
		if(idx==15) {
			isEnd = true;
			return;
		}
		
		int mine = matches[idx][0];
		int yours = matches[idx][1];
		
		// 우리팀 승 : 상대팀 패
		if(games[mine][0] > 0 && games[yours][2] > 0) {
			games[mine][0]--;
			games[yours][2]--;
			dfs(idx+1);
			games[mine][0]++;
			games[yours][2]++;
		}
		// 우리팀 무 : 상대팀 무
		if(games[mine][1] > 0 && games[yours][1] > 0) {
			games[mine][1]--;
			games[yours][1]--;
			dfs(idx+1);
			games[mine][1]++;
			games[yours][1]++;
		}
		// 우리팀 패 : 상대팀 승
		if(games[mine][2] > 0 && games[yours][0] > 0) {
			games[mine][2]--;
			games[yours][0]--;
			dfs(idx+1);
			games[mine][2]++;
			games[yours][0]++;
		}
	}
}
