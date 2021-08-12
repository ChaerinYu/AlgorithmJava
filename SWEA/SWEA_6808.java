package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [D3] 6808. 규영이와 인영이의 카드게임
 * 아홉 라운드에 걸쳐 게임을 진행한다.
 * 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
 * 낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
 * 이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
 * 두 사람의 총점이 같으면 무승부이다.
 */
public class SWEA_6808 {

	private static final int CARD_NUM = 9;
	private static int[] A; // 규영 카드
	private static int[] B; // 인영 카드
	private static int[] tempB; // 인영 카드
	
	private static boolean[] checked; // 규영/인영카드 나누는 용
	private static boolean[] isSelected; // 카드 순열만드는데 사용
	
	private static int win; // 규영 win
	private static int lose; // 규영 lose
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			String[] strNum = br.readLine().split(" ");
			A = new int[CARD_NUM]; B = new int[CARD_NUM];
			tempB = new int[CARD_NUM];
			checked = new boolean[2*CARD_NUM+1];
			isSelected = new boolean[CARD_NUM];
			win = 0; lose = 0;
			
			for (int i = 0; i < CARD_NUM; i++) {
				A[i]=Integer.parseInt(strNum[i]); // 규영 카드 입력
				checked[A[i]] = true;
			}
			
			// 인영이 카드 숫자들 입력 (오름차순)
			int tempCnt = 0;
			for (int i = 1; i < checked.length; i++) {
				if(!checked[i]) tempB[tempCnt++] = i;
			}
			
			// 인영이 카드 조합을 만든다.
			permutation(0);
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	private static void permutation(int cnt) {
		if(cnt == CARD_NUM) {
			// 만들어진 카드 조합으로 규영이 카드와 게임한다.
			game();
			return; // return 안해주면 시간 오래걸림
		}
		
		for (int i = 0; i < CARD_NUM; i++) {
			if(isSelected[i]) continue;
			
			B[cnt] = tempB[i];
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static void game() {
		int scoreA = 0, scoreB = 0;
		
		// 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고
		// 낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
		for (int i = 0; i < CARD_NUM; i++) {
			if(A[i]>B[i]) scoreA = scoreA + A[i] + B[i];
			else if(A[i]<B[i]) scoreB = scoreB + A[i] + B[i];
		}
		
		if(scoreA>scoreB) win++;
		else if(scoreA<scoreB) lose++;
	}
	
}
