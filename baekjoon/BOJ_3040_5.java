package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* next permutation 
 * 3040. 백설 공주와 일곱 난쟁이
 */
public class BOJ_3040_5 {
	
	private static final int DWALF_NUM = 9; // 들어온 난쟁이 수
	private static int[] DWALFS; // 난쟁이

	private static int[] DWALF_BIT; // 난쟁이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DWALFS = new int[DWALF_NUM];
		for (int i = 0; i < DWALF_NUM; i++) {
			DWALFS[i] = Integer.parseInt(br.readLine());
		}
		
		DWALF_BIT = new int[DWALF_NUM];
		int cnt = 0;
		while(++cnt<=7) DWALF_BIT[DWALF_NUM-cnt] = 1;
		
		Arrays.sort(DWALF_BIT);
		
		do {
			int tempSum = 0;
			for (int i = 0; i < DWALF_NUM; i++) {
				if(DWALF_BIT[i] == 1) {
					tempSum += DWALFS[i];
				}
			}
			if(tempSum == 100) {
				for (int i = 0; i < DWALF_NUM; i++) {
					if(DWALF_BIT[i] == 1) {
						System.out.println(DWALFS[i]);
					}
				}
				break;
			}
		} while (next_permutation());
		
		
	}
	
	private static boolean next_permutation() {
		int i = DWALF_NUM-1;
		
		while(i>0 && DWALF_BIT[i-1]>=DWALF_BIT[i]) i--;
		
		if(i == 0) return false;
		
		int j = DWALF_NUM-1;
		
		while(DWALF_BIT[i-1]>=DWALF_BIT[j]) j--;
		
		swap(i-1, j);
		
		int k = DWALF_NUM-1;
		while(i-1<=k) {
			swap(i, k);
			k--;
			i++;
		}
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = DWALF_BIT[i];
		DWALF_BIT[i] = DWALF_BIT[j];
		DWALF_BIT[j] = temp;
	}
}
