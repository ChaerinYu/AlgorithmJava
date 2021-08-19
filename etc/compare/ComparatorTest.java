package etc.compare;

import java.util.Arrays;
import java.util.Comparator;

/*
 * API 있는 거 사용한 경우, 내가 Comparable 바꿀 수 없음
 * Comparator를 만들어서 넣어주는 형태
 */
public class ComparatorTest {

	private static class MyComparator implements Comparator<int []> {
		@Override
		public int compare(int[] o1, int[] o2) {
			int diff = o1[0] - o2[0];
			return diff != 0 ? diff : o2[1]-o1[1];
		}
	}
	
	public static void main(String[] args) {
		
		int[][] arr = new int[][] {{1, 10}, {3, 50}, {2, 80}, {4, 10}, {1, 100}};
		print(arr);
		
		System.out.println("정렬 후");
		Arrays.sort(arr, new MyComparator());
		print(arr);
		
	}

	private static void print(int[][] arr) {
		for(int[] a: arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
//[1, 10]
//[3, 50]
//[2, 80]
//[4, 10]
//[1, 100]
//정렬 후
//[1, 100]
//[1, 10]
//[2, 80]
//[3, 50]
//[4, 10]