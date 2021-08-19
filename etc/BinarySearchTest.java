package etc;

import java.util.Arrays;

/**
 * 2021.08.17
 * binary search
 * 이진 검색 
 * @author user
 *
 */
public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr = {10, 4, 6, 20, 35, 7};
		
		// binary search하기 위해서는 오름차순 정렬 해줘야 한다.
		Arrays.sort(arr);
		// 4, 6, 7, 10, 20, 35
		System.out.println(binarySearch(arr, 6));
		System.out.println(binarySearch(arr, 35));
		System.out.println(binarySearch(arr, 50));
		System.out.println(Arrays.binarySearch(arr, 6));
		System.out.println(Arrays.binarySearch(arr, 35));
		System.out.println(Arrays.binarySearch(arr, 50)); // -7
		System.out.println(Arrays.binarySearch(arr, 22)); // -6
		System.out.println(Arrays.binarySearch(arr, 0)); // -1
	}
	
	// key에 해당하는 원소의 index return
	static int binarySearch(int[] arr, int key) {
		int start = 0, end = arr.length-1;
		
		while(start<=end) {
			int mid = (start+end)/2; // 중간 위치 구하기
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] < key) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		// while문 나오면 못찾은 경우
		return -1;
	}

}
