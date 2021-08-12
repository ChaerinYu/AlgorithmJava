package etc;

import java.util.Arrays;

public class NextPermutationTest {
	
	public static void main(String[] args) {
		
		int[] input = {7, 1, 4};
		
		Arrays.sort(input); // 가장 작은 순열 만들기 -> 1, 4, 7
		
		// 다음 순열을 넘겨줘야 하기 때문에 현재 순열을 먼저 수행해줘야 한다.
		// -> do-while문 사용
		// 다음 순열이 없으면 멈추도록 한다. while(np(input))
		do {
			// 순열 사용
			System.out.println(Arrays.toString(input));
			
		} while(np(input));
	}
	
	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환 위치(i-1)를 찾는다.
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		// 맨 앞 자리 까지 온 상황 // 절벽(가장 큰 순열)
		if(i==0) return false;
		
		// step2. i-1위치와 교환할 큰 값 찾기 (교환할 큰 값은 N부터 i index 위치)
		int j = N-1;
		// i-1은 i가 있기에 항상 존재한다. (없었으면 위에서 return되었음) j>=0 조건 넣을 필요 없음
		while(numbers[i-1]>=numbers[j]) --j;
		
		// step3. i-1위치값과 교환할 j위치값 교환
		swap(numbers, i-1, j);
		
		// step4. 꼭대기 위치(i)부터 맨 뒤(N-1)까지 오름차순 정렬
		// 꼭대기(i)부터 맨 뒤까지 내림차순 형태의 순열을 오름차순으로 정렬해준다.
		int k = N-1;
		while(i<k) {
			swap(numbers, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
