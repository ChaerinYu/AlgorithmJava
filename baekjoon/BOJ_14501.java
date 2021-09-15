package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Study week 1
 * 14501. 퇴사
 * @author ChaerinYu
 * DFS
 */
public class BOJ_14501 {
	
	static class Counseling {
		int time;
		int pay;
		
		public Counseling(int time, int pay) {
			this.time = time;
			this.pay = pay;
		}

		public int getTime() {
			return time;
		}

		public int getPay() {
			return pay;
		}
		
	}
	
	static int N; // 퇴사 d-day
	static int res = 0; // 답
	
	static Counseling[] counsel;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 퇴사 d-day
		
		counsel = new Counseling[N+1];
		
		StringTokenizer st = null;
		// 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			
			counsel[i] = new Counseling(time, pay);
		}
		
		for (int i = 1; i <= N; i++) {
			// i번째 날 수익
			makeProfit(i, 0);
		}
		
		System.out.println(res);
	}
	
	// DFS
	static void makeProfit(int day, int totalPay) {
		// 퇴사일(최대수익 받는 날)
		if(day == N+1) {
			// 최대 수익 최대값 갱신
			res = Math.max(res, totalPay);
			return;
		}
		
		// 상담 가능할 때는 무조건 상담 진행한다.
		int time = counsel[day].getTime();
		int pay = counsel[day].getPay();
		if(day+time <= N+1) {
			makeProfit(day+time, totalPay+pay);
		}
		
		// 상담 안 할 때 (해당 날짜 상담 안하는 경우도 고려해줘야 한다.)
		makeProfit(day+1, totalPay);
	}
	
}
