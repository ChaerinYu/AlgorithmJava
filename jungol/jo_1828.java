package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 정보올림피아드 1828. 냉장고
 * 첫줄에 화학물질의 수 N이 입력된다. N의 범위는 1이상 100 이하이다. 
 * 두 번째 줄부터 N+1줄까지 최저보관온도와 최고보관온도가 입력된다. 
 * 보관온도는 -270° ~ 10000°
 * 최소로 필요한 냉장고의 대수를 출력한다.
 * @author user
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
 */
public class jo_1828 {

	private static int N; // 화학물질 수
	private static Temperature[] t;
	private static int answer = 1;
	
	// 각 화학물질의 최저/최고온도 저장하는 객체
	static class Temperature implements Comparable<Temperature> {

		int low, high;
		
		public Temperature(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}


		// 최고온도만 비교해도 괜찮음..
		@Override
		public int compareTo(Temperature o) {
//			int value = this.low - o.low; // 필요없음..
//			if(value != 0) return value;
			return this.high-o.high;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N<1 || N>100) {
			return;
		}
		
		t = new Temperature[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			
			if(low<-270 || low>10000 || high<-270 || high>10000) {
				return;
			}
			
			t[i] = new Temperature(low, high);
			
		}
		Arrays.sort(t);
		// comparable말고 comparator 쓸 때
//		Arrays.sort(t, new Comparator<Temperature>() {
//			@Override
//			public int compare(Temperature o1, Temperature o2) {
////				int value = o1.low - o2.low;
////				if(value != 0) return value;
//				return o1.high-o2.high;
//			}
//		});

		answer = putRefrigerator(t);
		
		System.out.println(answer);
	}
	
	// 냉장고 얼마나 둘지 count
	private static int putRefrigerator(Temperature[] temp) {
		
		int max = temp[0].high;
		
		for (int i = 1; i < N; i++) {
			// 겹치는 부분 없는 경우
			if(max < temp[i].low) {
				max = temp[i].high;
				answer++;
			}
		}
		return answer;
	}
	
}
