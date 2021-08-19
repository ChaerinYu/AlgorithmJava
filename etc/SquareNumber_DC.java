package etc;

import java.util.Scanner;

/**
 * 2021.08.17
 * divide and conquer
 * 재귀 recursion 
 * 거듭제곱
 * @author user
 *
 */
public class SquareNumber_DC {

	static int callCnt;
	
	// 재귀 recursion
	static long exp1(long x, long y) {
		callCnt++;
		if(y==1) return x;
		
		return x*exp1(x, y-1);
	}
	
	// 분할정복 divide and conquer
	static long exp2(long x, long y) {
		callCnt++;
		
		if(y==1) return x;
		
		long r = exp2(x, y/2); // y/2 -> 5/2 = 2 = 4/2 이므로 홀짝 구분안해줌
		long res = r*r;
		
		if(y%2 == 1) res *= x; // x^(y/2)일 경우, y가 1 짤림 -> 홀수인 경우 1번 더 곱해줘야 한다.
		
		return res;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println("재귀");
		System.out.println(exp1(x,y));
		System.out.println(callCnt);
		
		callCnt = 0;
		System.out.println("분할정복");
		System.out.println(exp2(x,y));
		System.out.println(callCnt);
	}

}
