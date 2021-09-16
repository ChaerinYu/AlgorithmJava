package etc.dp;

import java.util.Arrays;
import java.util.Scanner;
/**
 * binarysearch
 * @author user
 *
 */
public class DP2_LISTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 모든 원소의 값은 다르다.
		int[] LIS = new int[N]; // 해당 길이를 증가 수열 중 맨 끝을 최소값으로 유지
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 길이만 안다면 사용해도 괜찮다 O(nlogn)
		int size = 0; // LIS에 채워진 원소 수
		for (int i = 0; i < N; i++) { // N번
			// 중복값이 없으므로 탐색이 안되므로(음수값) 바로 절대값을 취하여 -1한 후에 삽입 위치 설정한다.
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1; // logN
			LIS[temp] = arr[i];
			
			// 추가된 위치가 맨 뒤라면 사이즈 증가 필요 - 배열 증가했으므로 새로운 값 입력하기 위해 +1
			if(temp == size) ++size;
		}
		
		System.out.println(size);
	}
}
/**
6
3 2 6 4 5 1

3
*/