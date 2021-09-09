package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 9091. DSLR
 * @author ChaerinYu
 * BFS, HashSet 사용, 기존 이중배열 삭제 -> 301432 KB, 9736 ms
 * D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
 * S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
 * L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
 * R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
 */
public class BOJ_9019_2 {

	final static int Len = 4;
	static int T; // 테스트 케이스 수 
	
	static String res = "";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		T = Integer.parseInt(br.readLine());
		int origin = 0, change = 0;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			origin = Integer.parseInt(st.nextToken());
			change = Integer.parseInt(st.nextToken());
			
			res = "";
			bfs(origin, change);
			System.out.println(res);
		}
		
		
	}
	
	static void bfs(int origin, int change) {
		Set<Integer> visited = new HashSet<Integer>(); // 레지스터 방문 체크
		Queue<Integer> queue = new LinkedList<Integer>(); // D, S, L, R 1 turn 후 레지스터 숫자값
		Queue<String> strQ = new LinkedList<String>(); // 명령어

		queue.offer(origin);
		strQ.offer("");
		
		visited.add(origin); // 방문체크
		
		int dnum = 0, snum = 0, lnum = 0, rnum = 0;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			String s = strQ.poll();
			
			// 최종 값 나오면 return
			if(num==change) {
				res = s;
				return;
			}
			
			dnum = exchangeD(num);
			snum = exchangeS(num);
			lnum = exchangeL(num);
			rnum = exchangeR(num);
			
			int size = visited.size();
			
			// D
			visited.add(dnum);
			if(size+1 == visited.size()) { // 기존 사이즈+1했을 때와 사이즈 같을 경우 -> 처음 만난 숫자
				queue.offer(dnum);
				strQ.offer(s+"D");
				size++; // 1 더해준다.
			}
			// S
			visited.add(snum);
			if(size+1 == visited.size()) {
				queue.offer(snum);
				strQ.offer(s+"S");
				size++; // 1 더해준다.
			}
			// L
			visited.add(lnum);
			if(size+1 == visited.size()) {
				queue.offer(lnum);
				strQ.offer(s+"L");
				size++; // 1 더해준다.
			}
			// R
			visited.add(rnum);
			if(size+1 == visited.size()) {
				queue.offer(rnum);
				strQ.offer(s+"R");
				size++; // 1 더해준다.
			}
			
		}
	}

	// D
	static int exchangeD(int num) {
		num = num*2;
		if(num>9999) num = num % 10000;
		
		return num;
	}
	
	// S
	static int exchangeS(int num) {
		num = num-1;
		if(num==-1) num = 9999;
		
		return num;
	}
	
	// L
	static int exchangeL(int num) {
		num = (num*10)%10000+num/1000;
		return num;
	}
	
	// R
	static int exchangeR(int num) {
		num = (num%10)*1000+num/10;
		return num;
	}
}
