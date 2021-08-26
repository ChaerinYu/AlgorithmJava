package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1037. 오류교정
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=316&sca=99&sfl=wr_hit&stx=1037
 * @author ChaerinYu
 * 불리언 행렬의 각각의 열과 각각의 행이 짝수 합을 가질 때 패리티 성질을 가지고 있다고 하자. 다시 말하자면 한 집합에 짝수개의 1이 있다는 이야기 이다.
 */
public class jo_1037 {

	static int n; // 행렬의 크기 (n<100)
	static int[][] map; // 행렬
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		if(n<=0 || n>=100) return;  // wrong input
		
		map = new int[n+1][n+1];
		
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= n; c++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num!=0 && num!=1) return; // wrong input
				map[r][c] = num;
			}
		}
		
		// 행  확인
		// 2의배수 인지 확인하는 변수와 바꿔야할 비트 수
		int cnt = 0, wrongNumR = 0;
		int wR = 0, wC = 0;
		for (int r = 1; r <= n; r++) {
			cnt = 0;
			for (int c = 1; c <= n; c++) {
				if(map[r][c] == 1) cnt++;
			}
			if(cnt%2 != 0) {
				wR = r;
				wrongNumR++;
			}
			// 행만 확인했을 때 2개 이상이면 갱생불가
			if(wrongNumR>=2) {
				System.out.println("Corrupt");
				return;
			}
		}
		// 열 확인
		int wrongNumC = 0;
		for (int c = 1; c <= n; c++) {
			cnt = 0;
			for (int r = 1; r <= n; r++) {
				if(map[r][c] == 1) cnt++;
			}
			if(cnt%2 != 0) {
				wC = c;
				wrongNumC++;
			}
			// 패리티성질 못갖는 경우
			if(wrongNumC>0) {
				// wR이 0이 아니면 행에서도 오류 발생 -> 하나의 비트만 변경으로 갱생가능한지 확인
				if(wrongNumR == 1 && wrongNumC == 1) {
					int tempCntR = 0, tempCntC = 0;
					for (int i = 1; i <= n ; i++) {
						if(map[wR][i] == 1) tempCntR++;
						if(map[i][wC] == 1) tempCntC++;
					}
					// 1 더한 후 %2 했을 때 둘 다 0이 아니면 하나의 비트 변경으로 안됨
					if((tempCntR+1)%2==0 && (tempCntC+1)%2==0) {
						System.out.printf("Change bit (%d,%d)%n", wR, wC);
						return;
					}
				}
				// 열 오류가 2개 이상이면 갱생불가
				if(wrongNumC>=2) {
					System.out.println("Corrupt");
					return;
				}
			}
		}
		if(wrongNumC+wrongNumR>=1) {
			System.out.println("Corrupt");
			return;
		}
		
		System.out.println("OK");
	}
}
