package etc;

public class CombNextPermutationTest {
	
	public static void main(String[] args) {
		
		int[] input = {7, 1, 4, 2, 3};
		int N = input.length;
		int R = 3;
		
		int[] p = new int[N]; // np돌릴 배열을 만든다. (bit flag과 유사한 역할)
		// R개만큼 뒤쪽부터 1로 채워준다.
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		
		// 다음 조합을 넘겨줘야 하기 때문에 현재 조합을 먼저 수행해줘야 한다.
		// -> do-while문 사용
		// 다음 조합이 없으면 멈추도록 한다. while(np(input))
		do {
			// 조합 사용
			for (int i = 0; i < N; i++) {
				// 1인 경우 숫자가 선택된 경우 (p배열은 0과 1로만 이루어짐)
				if(p[i] == 1) System.out.print(input[i]+" ");
			}
			System.out.println();
		} while(np(p));
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
