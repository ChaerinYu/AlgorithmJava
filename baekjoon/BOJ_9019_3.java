package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9019_3 {

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
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> number = new LinkedList<Integer>();
		Queue<String> command = new LinkedList<String>();
		
		number.offer(a);
		command.offer("");
		visited.add(a);
		
		while(!number.isEmpty()) {
			int nowNumber = number.poll();
			String nowComm = command.poll();
			
			// 찾는 숫자
			if(nowNumber == b) {
				System.out.println(nowComm);
				return;
			}
			
			int size = visited.size();
			// D
			int numD = (nowNumber*2)%10000;
			visited.add(numD);
			// 새로운 숫자인 경우
			if(size+1 == visited.size()) {
				number.offer(numD);
				command.offer(nowComm+"D");
				size++;
			}
			
			// S
			int numS = nowNumber != 0 ? nowNumber-1 : 9999;
			visited.add(numS);
			// 새로운 숫자인 경우
			if(size+1 == visited.size()) {
				number.offer(numS);
				command.offer(nowComm+"S");
				size++;
			}
			
			// L
			int numL = (nowNumber*10)%10000 + nowNumber/1000;
			visited.add(numL);
			// 새로운 숫자인 경우
			if(size+1 == visited.size()) {
				number.offer(numL);
				command.offer(nowComm+"L");
				size++;
			}
			
			// R
			int numR = (nowNumber%10)*1000 + nowNumber/10;
			visited.add(numR);
			// 새로운 숫자인 경우
			if(size+1 == visited.size()) {
				number.offer(numR);
				command.offer(nowComm+"R");
				size++;
			}
		}
	}

}
