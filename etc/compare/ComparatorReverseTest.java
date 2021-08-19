package etc.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorReverseTest {
// Comparator의 reverseOrder() 메서드 사용
	// 현재 정렬에서 역순으로 바꾸주는 메서드고, 기본은 내림차순으로 바꿔준다.
	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {4, 3, 7, 5, 10};
		System.out.println("정렬 전: "+Arrays.toString(arr));
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("정렬 후: "+Arrays.toString(arr));
		
		Student[] arr2 = new Student[] {new Student(1, 10)
				, new Student(3, 60)
				, new Student(2, 80)
				, new Student(4, 60)
				, new Student(5, 100)};
		System.out.println("정렬 전 ====================");
		for(Student s: arr2) {
			System.out.println(s);
		}
		Arrays.sort(arr2, Comparator.reverseOrder());
		System.out.println("내림차순 정렬 후 ====================");
		// Student 클래스에서 compareTO로 내림차순 정렬해둔 상태로
		// 다시 reverseOrder해서 역순 오름차순으로 나오게 된다.
		// compareTo 오름차순 정렬로 바꾸고 다시 reverseOrder 내림차순으로 나오
		for(Student s: arr2) {
			System.out.println(s);
		}
		
	}

}

//정렬 전: [4, 3, 7, 5, 10]
//정렬 후: [10, 7, 5, 4, 3]
//정렬 전 ====================
//Student [no = 1, score = 10]
//Student [no = 3, score = 60]
//Student [no = 2, score = 80]
//Student [no = 4, score = 60]
//Student [no = 5, score = 100]
//내림차순 정렬 후 ====================
//Student [no = 5, score = 100]
//Student [no = 4, score = 60]
//Student [no = 3, score = 60]
//Student [no = 2, score = 80]
//Student [no = 1, score = 10]
