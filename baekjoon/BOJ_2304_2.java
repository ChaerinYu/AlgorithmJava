package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
/** 
 * 2304. 창고 다각형
 * @author user
 * 창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다.
 * 기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 프로그램을 작성하시오.
 * 
 * 첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. N은 1 이상 1,000 이하이다. 
 * 그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. 
 * L과 H는 둘 다 1 이상 1,000 이하이다.
 */
public class BOJ_2304_2 {

	static int N; // 기둥 개수
	static Poll[] poll;
	
	static Stack<Poll> stack1;
	static Stack<Poll> stack2;
	static int maxH = 0, maxHIdx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		N = Integer.parseInt(br.readLine());
		
		poll = new Poll[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			poll[i] = new Poll(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// L sort
		Arrays.sort(poll, new PollComparator());
		
		// H 최대값을 찾아서 그 전까지는 오름차순, 그 뒤로는 뒤에서 제일 큰 기둥 1개를 찾아서 지붕을 내린다. 그 뒤로는 내림차순
		for (int i = 0; i < N; i++) {
			if(maxH < poll[i].H) {
				maxH = poll[i].H;
				maxHIdx = i;
			}
		}
		
		// 지붕을 올리자
		stack1 = new Stack<Poll>();
		stack1.push(poll[0]); // 첫 번째 기둥은 넣어준다.
		for (int i = 1; i <= maxHIdx; i++) {
			// H 최대값 전 까지는 오름차순
			if(stack1.peek().H <= poll[i].H) {
				stack1.push(poll[i]);
			}
		}
		
		// H 최대값 이후로는 내림차순 -> for문 반대로 돌려서 오름차순으로 바꿔줌
		stack2 = new Stack<Poll>();
		stack2.push(poll[N-1]); // 마지막 기둥은 넣어준다.
		for (int i = N-2; i > maxHIdx; i--) {
			if(stack2.peek().H <= poll[i].H) {
				stack2.push(poll[i]);
			}
		}
		stack2.push(poll[maxHIdx]); // 최대 기둥 넣기
		
		System.out.println(calc());
		
	}
	
	private static int calc() {
		int res = 0;
		Poll prevS1 = stack1.pop();
		while(!stack1.isEmpty()) {
			Poll curS1 = stack1.pop();
			
			res += Math.abs(curS1.L-prevS1.L)*Math.abs(curS1.H);
			prevS1 = curS1;
		}
		Poll prevS2 = stack2.pop();
		while(!stack2.isEmpty()) {
			Poll curS2 = stack2.pop();
			
			res += Math.abs(curS2.L-prevS2.L)*Math.abs(curS2.H);
			prevS2 = curS2;
		}
		res += maxH;
//		System.out.println(res);
		return res;
	}
	
	private static class PollComparator implements Comparator<Poll> {
		@Override
		public int compare(Poll o1, Poll o2) {
			return o1.L-o2.L;
		}
	}
	
	static class Poll {
		int L;
		int H;
		
		public Poll(int l, int h) {
			super();
			L = l;
			H = h;
		}
	}
}

