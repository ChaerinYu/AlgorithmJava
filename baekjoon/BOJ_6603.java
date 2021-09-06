package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Study week 2
 * 6603. 로또 
 * @author ChaerinYu
 * 
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다. 
 * 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
 * 입력의 마지막 줄에는 0이 하나 주어진다. 
 * 
 * 조합 n개중 6개 고르기
 */
public class BOJ_6603 {
	
	static int n;
	static int[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			list = new int[n];
			
			// 입력
			for (int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			// 조합 돌리기
			combination(0, 0, new int[6]);
			System.out.println();
		}
		
	}
	
	/**
	 * 조합
	 * @param index list 시작 index
	 * @param lottoCnt 로또 번호 선택 수
	 * @param lotto 선택된 로또 배열
	 */
	static void combination(int index, int lottoCnt, int[] lotto) {
		// 로또 6개 골랐을 경우
		if(lottoCnt == 6) {
			// 출력
			for (int i = 0; i < lotto.length-1; i++) {
				System.out.print(lotto[i]+" ");
			}
			System.out.println(lotto[lotto.length-1]);
			return;
		}
		
		
		for (int i = index; i < n; i++) {
			lotto[lottoCnt] = list[i];
			
			combination(i+1, lottoCnt+1, lotto);
		}
	}
}
