package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2793. 전자레인지
 * @author ChaerinYu
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2053
 */
public class jo_2793 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 최소 단위인 10초 나눴을 때 나머지가 0이 아닌 경우 초를 맞출 수 없음
		if(T%10 != 0) {
			System.out.println("-1");
			return;
		}
		
		int cnt5m = 0, cnt1m = 0, cnt10s = 0;
		cnt5m += T/300;
		T = T%300;
		cnt1m += T/60;
		T = T % 60;
		cnt10s += T/10;
		
		System.out.println(cnt5m+" "+cnt1m+" "+cnt10s);
	}
}
