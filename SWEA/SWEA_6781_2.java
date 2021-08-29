package SWEA;

import java.io.BufferedReader;
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
public class SWEA_6781_2 {

	private static int cardNum = 9;
	private static int[][] cards;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 수 입력
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=test_case; tc++) {
			cards = new int[3][cardNum+1];
			
			int res = 0;
			// 테스트 케이스의 숫자/색상 입력
			String numStr = br.readLine();
			String rgbStr = br.readLine();
			int num = 0; char rgb = ' ';
			for(int i=0; i<cardNum; i++) {
				num = numStr.charAt(i)-'0';
				rgb = rgbStr.charAt(i);
				
				if(rgb=='R') {
					cards[0][num]++;
				} else if(rgb =='G') {
					cards[1][num]++;
				} else {
					cards[2][num]++;
				}
				
			}
			res = Math.max(f1(), f2());

			if(res == 3)
				System.out.println("#"+tc+" "+"Win");
			else
				System.out.println("#"+tc+" "+"Continue");
		}
	}
	// 연속된 숫자 먼저 체크
	private static int f1() {
		int setCnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 7; j++) {
				if(cards[i][j]>=1 && cards[i][j+1]>=1 && cards[i][j+2]>=1) {
					setCnt++;
					cards[i][j]--; cards[i][j+1]--; cards[i][j+2]--;
					j--; // cards[i][j]가 0일때까지 확인한다.
				}
			}
			for (int j = 1; j < cardNum+1; j++) {
				if(cards[i][j]>=3) {
					setCnt++;
					cards[i][j] -=3;
					j--;
				}
			}
		}
		return setCnt;
	}
	// 똑같은 숫자 먼저 체크
	private static int f2() {
		int setCnt = 0;
		for (int i = 0; i < 3; i++) {

			for (int j = 1; j < cardNum+1; j++) {
				if(cards[i][j]>=3) {
					setCnt++;
					cards[i][j] -=3;
					j--;
				}
			}
			for (int j = 1; j <= 7; j++) {
				if(cards[i][j]>=1 && cards[i][j+1]>=1 && cards[i][j+2]>=1) {
					setCnt++;
					cards[i][j]--; cards[i][j+1]--; cards[i][j+2]--;
					j--; //cards[i][j]가 0일때까지 확인한다.
				}
			}
		}
		return setCnt;
	}

}
