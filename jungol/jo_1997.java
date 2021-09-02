package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1997. 떡 먹는 호랑이
 * @author ChaerinYu
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1270
 * 첫째 줄에는 할머니가 넘어온 날 D (3≤D≤30)와 그 날 호랑이에게 준 떡의 개수 K (10≤K≤100,000)가 하나의 빈칸을 사이에 두고 주어진다.
 * 첫줄에 첫 날에 준 떡의 개수 A를 출력하고 그 다음 둘째 줄에는 둘째 날에 준 떡의 개수 B를 출력한다.
 */
public class jo_1997 {
	
	static int D, K; // 할머니가 넘어온 날, 그 날 호랑이에게 준 떡 개수
	static int A, B; // 첫 날 떡 개수, 둘째 날 떡 개수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		D = Integer.parseInt(st.nextToken()); // 넘어온 날
		K = Integer.parseInt(st.nextToken()); // 그 날 호랑이에게 준 떡 개수
		
		// 범위 체크
		if(D < 3 || D > 30 || K < 10 || K > 100000) return;
		
		A = 0; B = 0;
		// 규칙 발견
		int varA = 1, varB = 0, temp = 0;
		for (int i = 2; i <= D; i++) {
			temp = varA;
			varA = varB;
			varB = temp+varB;
		}
		
		// 경우의 수 찾기 (답은 여러가지 가능하므로 발견시 바로 break)
		loop:
		for (int i = 1; i <= K; i++) {
			for (int j = i; j <= K; j++) {
				if((varA*i + varB*j )== K) {
					A = i;
					B = j;
					break loop;
				}
				
			}
		}
		
		System.out.println(A); // 첫 날
		System.out.println(B); // 둘 째 날
	}
}
