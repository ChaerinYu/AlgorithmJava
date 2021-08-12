package etc;

import java.util.Arrays;

/*
 * N개의 서로 다른 수에서 뽑는 순열
 */
public class PermutationBitTest {
	
	// R 개의 숫자 뽑기 
	// R = N: nPr => P!
	static int N=3, R=3;
	static int[] input;
	static int[] numbers;
	
	public static void main(String[] args) {
		input = new int[] {1, 4, 7};
		numbers = new int[R];
		
		permutation(0, 0);
	}
	
	private static void permutation(int cnt, int flag) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수들이 들어있는 배열모든 원소에 대해 시도 
		for (int i = 0; i < N; i++) { // i: 인덱스
			if((flag & 1<<i) != 0) continue; // 사용중인 수면 다음 수로. 
			// 해당 자리가 1로 되어 있으므로 continue 처리한다.
			
			// 0이면 내려옴
			numbers[cnt] = input[i];
			// 다음 자리 순열 뽑으러 gogo
			permutation(cnt+1, (flag | 1<<i));
		}
	}

}
