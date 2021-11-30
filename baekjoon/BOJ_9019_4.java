package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bfs(A, B);
		}
	}

	private static void bfs(int a, int b) {
		boolean[] visited = new boolean[10000];
		Queue<Integer> number = new LinkedList<Integer>();
		Queue<String> command = new LinkedList<String>();
		
		number.offer(a);
		command.offer("");
		visited[a] = true;
		
		while(!number.isEmpty()) {
			int nowNumber = number.poll();
			String nowComm = command.poll();
			
			// 찾는 숫자
			if(nowNumber == b) {
				System.out.println(nowComm);
				return;
			}
			
			// D
			int numD = (nowNumber*2)%10000;
			if(!visited[numD]) {
				number.offer(numD);
				command.offer(nowComm+"D");
				visited[numD] = true;
			}
			
			// S
			int numS = nowNumber != 0 ? nowNumber-1 : 9999;
			if(!visited[numS]) {
				number.offer(numS);
				command.offer(nowComm+"S");
				visited[numS] = true;
			}
			
			// L
			int numL = (nowNumber*10)%10000 + nowNumber/1000;
			if(!visited[numL]) {
				number.offer(numL);
				command.offer(nowComm+"L");
				visited[numL] = true;
			}
			
			// R
			int numR = (nowNumber%10)*1000 + nowNumber/10;
			if(!visited[numR]) {
				number.offer(numR);
				command.offer(nowComm+"R");
				visited[numR] = true;
			}
		}
	}

}
