package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 9091. DSLR
 * @author ChaerinYu
 * BFS -> 299944 KB, 3948 ms
 * D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
 * S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
 * L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
 * R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
 */
public class BOJ_9019 {

	final static int Len = 4;
	static int T; // 테스트 케이스 수 
	static int[][] register; // 레지스터
	
	static String res = "";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		T = Integer.parseInt(br.readLine());
		register = new int[T][2];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			register[i][0] = Integer.parseInt(st.nextToken());
			register[i][1] = Integer.parseInt(st.nextToken());
			
			res = "";
			bfs(register[i][0], register[i][1]);
			System.out.println(res);
		}
		
		
	}
	
	static void bfs(int origin, int change) {
		boolean[] visited = new boolean[10000];
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<String> strQ = new LinkedList<String>();

		queue.offer(origin);
		strQ.offer("");
		
		visited[origin] = true;
		
		int dnum = 0, snum = 0, lnum = 0, rnum = 0;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			String s = strQ.poll();
			
			if(num==change) {
				res = s;
				return;
			}
			
			dnum = exchangeD(num);
			snum = exchangeS(num);
			lnum = exchangeL(num);
			rnum = exchangeR(num);
			
			// D
			if(!visited[dnum]) {
				visited[dnum] = true;
				queue.offer(dnum);
				strQ.offer(s+"D");
			}
			// S
			if(!visited[snum]) {
				visited[snum] = true;
				queue.offer(snum);
				strQ.offer(s+"S");
			}
			// L
			if(!visited[lnum]) {
				visited[lnum] = true;
				queue.offer(lnum);
				strQ.offer(s+"L");
			}
			// R
			if(!visited[rnum]) {
				visited[rnum] = true;
				queue.offer(rnum);
				strQ.offer(s+"R");
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
