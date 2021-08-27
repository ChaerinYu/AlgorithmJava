package jungol;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1205. 조커
 * @author user
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
 * 조커 카드와 일반 카드가 주어졌을 때 가장 긴 길이의 스트레이트를 만드는 프로그램을 작성하라.
 * greedy
 */
public class Solution_0827_jo_1205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int zero = 0;
		Integer[] map = new Integer[N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
			if(map[i]==0) zero++;
		}
		// 모두가 0 일 때
		if(zero==N) {
			System.out.println(zero);
			return;
		}
		
		
		int res = 0; // 최대값 구하기
		
		// 정렬하고 앞에서 부터 검사하기
		Arrays.sort(map);
		for (int i = zero; i < N; i++) {
			
			// 스트레이트 개수
			int cnt = 1;
			int prev = map[i]; // 이전 수
			int joker = zero;
			
			for (int j = i+1; j < N; j++) {
				// 이전 값 같은 경우 ex) 0 0 7 7 7 7 7 9
				if(prev == map[j]) continue;
				
				// prev와 j번째 값이 1의 차이가 있나 없나 판단
				if(prev +1 == map[j]) {
					prev = map[j]; // => prev++;와 동일
					cnt++;
					continue;
				}
				// 연속되지 못함
				// 조커 남았는지 판단
				if(joker == 0) {
					break;
				}
				prev++; // 숫자가 커짐
				cnt++; // 스트레이트 길이가 길어짐
				
				j--; // 다음 이동 금지
				joker--; // 조커 사용
			}
			// 남은 조커 사용하기
			if(joker>0) cnt+=joker;
			
			joker = zero;
			// 스트레이트 최대 길이 구하기
			res = Math.max(res, cnt);
		}
		
		
		System.out.println(res);
	}
}
