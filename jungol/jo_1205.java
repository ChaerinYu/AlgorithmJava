package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** TODO
 * 1205. 조커
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
 * @author ChaerinYu
 * 조커 카드와 일반 카드가 주어졌을 때 가장 긴 길이의 스트레이트를 만드는 프로그램을 작성하라.
 */
public class jo_1205 {
	static PriorityQueue<Integer> cards = new PriorityQueue<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 카드 개수
		
		if(N>1000) return; // 입력제한
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int[] cards = new int[N];
//		LinkedList<Integer> cards = new LinkedList<Integer>();
		int jokerNum = 0;
		int minNum = Integer.MAX_VALUE; // 조커를 제외한 가장 작은 숫자
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cards.offer(num); // 카드 값 입력
			if(num == 0)
				jokerNum++;
			
			if(minNum>num) {
				minNum = num;
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
//		Collections.sort(cards); // 오름차순 정렬
		
//		boolean hasJoker = cards[0]==0?true:false;
		
		int res = 0;
//		int maxNum = cards[N-1]; // 가장 큰 숫자
		int maxNum = cards.peek(); // 가장 큰 숫자
		
		// 조커 없는 경우
		if(jokerNum == 0) {
			int maxLen = 1;
			int firstMax = cards.poll();
			while(!cards.isEmpty()) {
				int secondMax = cards.poll();
				// queue poll 하고 난 뒤 또 poll 해서 비교
				if(firstMax+1==secondMax) maxLen++;
				else maxLen = 1;
				res = Math.max(res, maxLen);
				
				firstMax = secondMax;
			}
			System.out.println(res);
			return;
		}

		int maxLen = 1;
		int tempNum = jokerNum;
		int i = 1;
		while(!cards.isEmpty() && cards.peek() == 0) {
			cards.poll();
		}
		
		int firstMax = cards.poll();
		while(!cards.isEmpty()) {
			int secondMax = cards.poll();
			System.out.println("ff"+firstMax);
			System.out.println("ss"+secondMax);
			if(firstMax+1 == secondMax) maxLen++;
			else {
				System.out.println("Aa");
				if(firstMax+1+tempNum>=secondMax) {
					while(tempNum>=0 && firstMax+1+tempNum>secondMax) {
						System.out.println("while:"+tempNum);
						tempNum--;
						maxLen++;
						firstMax = secondMax;
					}
					maxLen+=tempNum+1;
					System.out.println("remain: "+tempNum);
					continue;
//					continue;
				} else {
					tempNum = jokerNum;
					maxLen = 1;
				}
			}
			res = Math.max(res, maxLen);
			firstMax = secondMax;
		}
		System.out.println(res);
		return;
		
	}
}
