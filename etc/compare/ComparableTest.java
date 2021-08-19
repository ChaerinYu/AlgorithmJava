package etc.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {

	private static class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.no-o2.no;
		}
	}
	
	public static void main(String[] args) {
		// Student 객체 만듦
		Student[] arr = new Student[] {new Student(1, 10)
									, new Student(3, 60)
									, new Student(2, 80)
									, new Student(4, 60)
									, new Student(5, 100)};
		System.out.println("정렬 전");
		print(arr);
		// comparable: 자기자신과 타원소 비교
		// comparable implements 및 compareTo() 재정의가 안되어 있으면 비교 판단이 안됨
		// implements 및 재정의 후 sort 진행하면 return에 따라서 정렬 수행
		System.out.println("내림차순 정렬 후");
		Arrays.sort(arr);
		print(arr);
		// 2. comparator 활용
		// 2번째 인자로 comparator 넣어줌
		// 정의한 comparator를 넣어줄 수도 있고 new 사용도 가능, 람다식 사용 가능
		System.out.println("정렬 2, 오름차순 정렬");
		Arrays.sort(arr, new StudentComparator());
		print(arr);
		System.out.println("람다, 정렬, 점수");
		Arrays.sort(arr, (s1, s2) ->Integer.compare(s1.score, s2.score));
		print(arr);
		System.out.println("정렬, 점수 내림차순");
		Arrays.sort(arr, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			};
		});
		print(arr);
	}
	
	private static void print(Student[] arr) {
		for(Student s: arr) {
			System.out.println(s);
		}
	}
}

//정렬 전
//Student [no = 1, score = 10]
//Student [no = 3, score = 60]
//Student [no = 2, score = 80]
//Student [no = 4, score = 60]
//Student [no = 5, score = 100]
//내림차순 정렬 후
//Student [no = 1, score = 10]
//Student [no = 2, score = 80]
//Student [no = 3, score = 60]
//Student [no = 4, score = 60]
//Student [no = 5, score = 100]
//정렬 2, 오름차순 정렬
//Student [no = 1, score = 10]
//Student [no = 2, score = 80]
//Student [no = 3, score = 60]
//Student [no = 4, score = 60]
//Student [no = 5, score = 100]
//람다, 정렬, 점수
//Student [no = 1, score = 10]
//Student [no = 3, score = 60]
//Student [no = 4, score = 60]
//Student [no = 2, score = 80]
//Student [no = 5, score = 100]
//정렬, 점수 내림차순
//Student [no = 5, score = 100]
//Student [no = 2, score = 80]
//Student [no = 3, score = 60]
//Student [no = 4, score = 60]
//Student [no = 1, score = 10]
