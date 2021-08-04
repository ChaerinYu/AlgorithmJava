package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [D3] 6781. 삼삼 트리플 게임
 * 이 게임에는 카드를 이용하는데, 카드에는 1에서 9까지의 숫자가 카드에 적혀 있고
 * 적힌 숫자의 색이 빨강(R), 초록(G), 파랑(B)중의 하나로 총 27종류의 카드를 사용한다.
 * 각 종류의 카드는 모두 4장씩 존재하여 총 108장의 카드로 게임을 진행한다.
 * 각 세트는 동일한 색의 카드 세 장으로 이루어져야 하며, 세 숫자가 모두 같거나, 세 숫자가 모두 연속된 숫자여야 한다.
 * (동일한 색이며 세 숫자가 같거나 세 숫자가 연속)
 */
public class SWEA_6781 {

	private static int cardNum = 9;
	private static int[] numbers; // 숫자 
	private static char[] rgb; // 색 
	
	private static int[] R; // 빨강
	private static int[] G; // 초록
	private static int[] B; // 파랑
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 수 입력
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=test_case; tc++) {
			R = new int[cardNum+1];
			G = new int[cardNum+1];
			B = new int[cardNum+1];
			
			numbers = new int[cardNum];
			rgb = new char[cardNum];
			
			// 테스트 케이스의 숫자 입력
			String numStr = br.readLine();
			for(int i=0; i<cardNum; i++) {
				numbers[i] = Integer.parseInt(String.valueOf(numStr.charAt(i)));
			}
			// 테스트 케이스의 색상 입력
			String rgbStr = br.readLine();
			for(int i=0; i<cardNum; i++) {
				rgb[i] = rgbStr.charAt(i);
			}
			
			for(int i=0; i<cardNum; i++) {
				if(rgb[i]=='R') {
					R[numbers[i]]++;
				} else if(rgb[i]=='G' ) {
					G[numbers[i]]++;
				} else if(rgb[i]=='B' ) {
					B[numbers[i]]++;
				}
			}
			
			// 1. 색깔 별 합 %3 !=0 일 경우 continue
			boolean flag = true; // false: Continue, true: Win
			int rSum = 0, gSum = 0, bSum = 0;
			for(int i=0; i<cardNum && flag; i++) {
				rSum += R[i];
				gSum += G[i];
				bSum += B[i];
			}
			if(rSum%3 != 0 || gSum%3 != 0 || bSum%3 != 0) {
//				System.out.println("#"+tc+" "+"Continue");
				flag = false;
//				continue;
			}
			
			// 2. 색 별로 사용된 숫자가 3배수 만큼 사용되었는지 체크
			// 3. 색 별로 세 숫자가 연속으로 사용되었는지 체크
			for(int i=0; i<cardNum-2 && flag; i++) {
				// 없거나 3배수로 존재하면 확인안한다.
				if(R[i]%3 != 0) {
					if(R[i]%3 == 1) {
						if((R[i]+R[i+1]+R[i+2])%3 != 0) flag = false;
					}
				}
				if(G[i]%3 != 0) {
					if(G[i]%3 == 1) {
						if((G[i]+G[i+1]+G[i+2])%3 != 0) flag = false;
					}
				}
				if(B[i]%3 != 0) {
					if(B[i]%3 == 1) {
						if((B[i]+B[i+1]+B[i+2])%3 != 0) flag = false;
					}
				}
			}
			
			if(flag)
				System.out.println("#"+tc+" "+"Win");
			else
				System.out.println("#"+tc+" "+"Continue");
			
		}
		*/
	}

}
