package etc;

import java.util.Arrays;

/*
 * N개의 서로 다른 수에서 뽑는 순열
 */
public class PermutationTest2 {
	
	// R 개의 숫자 뽑기 
	// R = N: nPr => P!
	static int N=3, R=2;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		input = new int[] {1, 4, 7};
		numbers = new int[R];
		isSelected = new boolean[N];
		
		permutation(0);
		/*
		for(int i=0; i<N; i++) {
			System.out.println(numbers[i]);
		}
		System.out.println();
		*/
	}
	
	private static void permutation(int cnt) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수들이 들어있는 배열모든 원소에 대해 시도 
		for (int i = 0; i < N; i++) { // i: 인덱스
			if(isSelected[i]) continue; // 사용중인 수면 다음 수로
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			// 다음 자리 순열 뽑으러 gogo
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
