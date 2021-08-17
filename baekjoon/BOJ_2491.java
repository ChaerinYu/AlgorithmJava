package baekjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * 2491. 수열
 * @author user
 * linkedlist 쓰면 시간초과 발생
 * scanner 쓸 때와 bufferedReader 쓸 때 속도 대략 4배차이
 */
public class BOJ_2491 {
	static int N; // 수열의 길이
	static int[] numbers; // 숫자
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int idx1 = 1, idx2 = 1;
		int max = 1;

		for (int i = 1; i < N; i++) {
			// 오름차순
			if(numbers[i-1]<=numbers[i]) {
				idx1++;
			} else {
				idx1 = 1;
			}
			max = Math.max(max, idx1);
		}
		
		for (int i = 1; i < N; i++) {
			// 내림차순
			if(numbers[i-1]>=numbers[i]) {
				idx2++;
			} else {
				idx2 = 1;
			}
			max = Math.max(max, idx2);
		}
		
		System.out.println(max);
		
	}
	
}
