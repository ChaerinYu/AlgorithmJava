package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1263. 시간관리
 * @author ChaerinYu
 * greedy algorithm
 * 이 명단은 i번째 일은 일을 처리하는데 정확히 Ti 시간이 걸리고 Si 시 내에 이 일을 처리하여야 한다는 것을 담고 있다. 진영이는 0시부터 활동을 시작할 수 있고, 두 개 이상의 일을 같은 시간에 처리할 수 없다.
 * 진영이가 바라는 점은 최대한 늦잠을 자는 것이다. 문제는 이러한 진영이를 도와 일들은 모두 마감시간 내에 처리할 수 있는 범위 내에서 최대한 늦게 일을 시작할 수 있는 시간이 몇 시인지 알아내는 것이다.
 * 
 * 첫째 줄에 일의 수 N이 입력되고 다음 N(1≤N≤1,000)개의 줄에 대해 i+1번째 줄에는 i번째 일에 대한 Ti(1≤Ti≤1,000)와 Si(1≤Si≤1,000,000)가 입력된다.
 * 진영이가 일을 모두 끝마칠 수 있는 가장 늦은 시간을 출력한다. 만약 0시부터 시작하여도 일을 끝마칠 수 없다면 -1을 출력한다.
 */
public class BOJ_1263 {

	static int N; // 일 수
	static Work[] works; // 일
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		works = new Work[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			int deadline = Integer.parseInt(st.nextToken());
			works[i] = new Work(time, deadline);
		}
		
		// 마감시간 오름차순
		Arrays.sort(works);
		
		int time = works[N-1].S-works[N-1].T; // 제일 마지막 일의 제일 늦게까지 가능한 시작 시간
		for (int i = N-2; i >= 0; i--) {
			// 이전 일(n-1)의 마감시간(S)이 그 다음(n) 일의 시작 시간(time)보다 늦을 경우, 
			// 이전 일의 마감시간을 땡긴다. (마감까지 모든 일을 끝내기 위해!)
			if(works[i].S > time) {
				works[i].S = time;
			}
			time = works[i].S-works[i].T;
			/**
			 * 이렇게 풀면 메모리/시간 더 먹는다.
			 * 그냥 for문 끝까지 돌리는 게 나은가 보다..
			// time 음수이면 시간 부족하므로 끝내버린다.
			if(time<0) {
				System.out.println(-1);
				return;
			}
			*/
		}
		
		if(time<0) System.out.println(-1);
		else System.out.println(time);
	}
}

class Work implements Comparable<Work> {
	int T; // 걸리는 시간
	int S; // 마감 시간
	
	public Work(int t, int s) {
		T = t;
		S = s;
	}

	// 마감시간 오름차순, 마감시간 같은 경우엔 걸리는 시간 짧은 애 부터
	@Override
	public int compareTo(Work o) {
		if(this.S==o.S) return this.T-o.T;
		return this.S-o.S;
	}
}