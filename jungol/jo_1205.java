package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/** TODO
 * 1205. 조커
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
 * @author ChaerinYu
 * 조커 카드와 일반 카드가 주어졌을 때 가장 긴 길이의 스트레이트를 만드는 프로그램을 작성하라.
 */
public class jo_1205 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 카드 개수
		
		if(N>1000) return; // 입력제한
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int[] cards = new int[N];
		LinkedList<Integer> cards = new LinkedList<Integer>();
		int jokerNum = 0;
		int minNum = Integer.MAX_VALUE; // 조커를 제외한 가장 작은 숫자
		for (int i = 0; i < N; i++) {
			cards.add(Integer.parseInt(st.nextToken())); // 카드 값 입력
			if(cards.get(i) == 0)
				jokerNum++;
			
			if(minNum>cards.get(i)) {
				minNum = cards.get(i);
			}
//			cards[i] = Integer.parseInt(st.nextToken()); // 카드 값 입력
//			if(cards[i] == 0)
//				jokerNum++;
//			
//			if(minNum>cards[i]) {
//				minNum = cards[i];
//			}
		}
		
//		Arrays.sort(cards); // 오름차순 정렬
		Collections.sort(cards); // 오름차순 정렬
		
//		boolean hasJoker = cards[0]==0?true:false;
		
		int res = 0;
//		int maxNum = cards[N-1]; // 가장 큰 숫자
		int maxNum = cards.get(N-1); // 가장 큰 숫자
		
		// 조커 없는 경우
		if(jokerNum == 0) {
			int maxLen = 1;
			for (int i = 1; i < N; i++) {
				if(cards.get(i-1)+1==cards.get(i)) maxLen++;
				else maxLen = 1;
				res = Math.max(res, maxLen);
			}
			System.out.println(res);
			return;
		}

		int maxLen = 1;
		int tempNum = jokerNum;
		int i = 1;
		while(i<N) {
//		for (int i = jokerNum; i < N; i++) {
			if(cards.get(i-1)+1==cards.get(i)) {
				maxLen++;
				i++;
			}
			else {
				if(tempNum>0 && cards.get(i-1)+tempNum+1>=cards.get(i)) {
					int temp = 0;
					while(temp<=tempNum && cards.get(i-1)+temp+1<cards.get(i)) {
						maxLen++;
//						tempNum--;
						temp++;
					}
					tempNum-=temp;
				} else {
					maxLen = 1;
					tempNum=jokerNum;
				}
			}
			res = Math.max(res, maxLen);
		}
		System.out.println(res);
		return;
			
//			if(cards[i-1]!=0 && cards[i-1]+1==cards[i])
			
//			if(cards[i-1]==0 || cards[i-1]+1==cards[i]) {
//				res++;
//			} else {
//				if(tempJokerNum>0 && i+1<N && cards[i-1]+2==cards[i+1]) {
//					// 조커 발동
////					res++;
//					tempJokerNum--;
//					continue;
//				} else {
//					tempJokerNum = jokerNum;
//					res = 0;
//				}
//			}
		
		
//		System.out.println(res);
		
	}
}
