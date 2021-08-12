package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 바이너리카운팅
 * 3040. 백설 공주와 일곱 난쟁이
 */
public class BOJ_3040_3 {
	
	private static final int DWALF_NUM = 9; // 들어온 난쟁이 수
	private static int[] DWALFS; // 난쟁이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DWALFS = new int[DWALF_NUM];
		for (int i = 0; i < DWALF_NUM; i++) {
			DWALFS[i] = Integer.parseInt(br.readLine());
		}
		
		subset(0);
		
	}
	
	private static void subset(int cnt) {
		if(DWALF_NUM == cnt) {
			
			for (int i = 0; i < 1 << DWALF_NUM; i++) {
				boolean[] isSelected = new boolean[DWALF_NUM];
				int sum = 0; int scnt = 0;
				for (int j = 0; j < DWALF_NUM; j++) {
//					10101010
//				&	00000010
//				------------
//					10101010
					if( (i & 1<<j) != 0 ) {
						isSelected[j] = true;
						sum += DWALFS[j];
						scnt++;
					}
				}

				// 7명의 난쟁이와 총 합 100 인지 확인하기
				if(sum == 100 && scnt == 7) {
					for (int j = 0; j < DWALF_NUM; j++) {
						if(isSelected[j]) System.out.println(DWALFS[j]);
					}
					return;
				}
			}
		}
		subset(cnt+1);
	}
}
