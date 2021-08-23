package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
/** TODO
 * 2304. 창고 다각형
 * @author user
 * 창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다.
 * 기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 프로그램을 작성하시오.
 * 
 * 첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. N은 1 이상 1,000 이하이다. 
 * 그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. 
 * L과 H는 둘 다 1 이상 1,000 이하이다.
 */
public class BOJ_2304 {

	static int N; // 기둥 개수
	static Poll[] poll;
	
	static Stack<Poll> stack;
	static int maxH = 0, maxHIdx = 0;
	static int secondMaxH = 0, secondMaxHIdx = 0;

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
		// maxHIdx 다음으로 제일 큰 기둥 1개를 찾아서 지붕을 내린다. (maxHIdx 이후 제일 큰 기둥 찾기)
		for (int i = maxHIdx+1; i < N; i++) {
			if(secondMaxH < poll[i].H) {
				secondMaxH = poll[i].H;
				secondMaxHIdx = i;
			}
		}
		
		// 지붕을 올리자
		stack = new Stack<Poll>();
		stack.push(poll[0]); // 첫 번째 기둥은 넣어준다.
		for (int i = 1; i < N-1; i++) {
			// H 최대값 전 까지는 오름차순
			if(i <= maxHIdx) {
				
				if(stack.peek().H <= poll[i].H) {
					stack.push(poll[i]);
				}
				
			}
			// 그 이후 부터는 내림차순
			else {
				// maxHIdx 이후 제일 큰 기둥
				if(secondMaxHIdx == i) {
					stack.push(poll[i]);
				}
				// secondMaxHIdx 이후부터는 내림차순으로 지붕내리기
				else if (i>secondMaxHIdx) {
					
					// 내림차순 + 마지막 기둥보다 큰 경우에만 넣기
					if(stack.peek().H > poll[i].H && poll[i].H > poll[N-1].H) {
						stack.push(poll[i]);
					}
				}
				
			}
		}
		stack.push(poll[N-1]); // 마지막 기둥 넣어주기
		
		System.out.println(calc());
		
	}
	
	private static int calc() {
		int res = 0;
		for (int i = 0; i < stack.size()-1; i++) {
			int width = stack.get(i+1).L - stack.get(i).L;
			int currHeight = stack.get(i).H;
			int nextHeight = stack.get(i+1).H;
			
			// 현재 기둥 높이 <= 다음 기둥 높이
			if(currHeight <= nextHeight) {
				res += width*currHeight;
			} else {
				// 현재 기둥 높이가 max일 때, 1*현재높이 더해주기
				res += width*nextHeight;
			}
		}
		// (제일 높은 기둥 넓이 - 마지막 기둥 넓이) + 마지막 기둥 넓이
		res += (maxH-stack.get(stack.size()-1).H)+stack.get(stack.size()-1).H;
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

