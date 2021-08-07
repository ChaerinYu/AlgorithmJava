package etc;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[], totalCnt;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 주사위 던짓 횟수
		numbers = new int[N];
		totalCnt = 0;
		
		int M = sc.nextInt();
		switch(M) {
		case 1: // 주사위 던지기 1: 중복순열
			dice1(0);
			break;
		case 2: // 주사위 던지기 2: 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3: // 주사위 던지기 3: 중복조합 
			dice3(0, 1);
			break;
		case 4: // 주사위 던지기 4: 조합
			dice4(0, 1); // 주사위는 1부터 시작하니까 1부터 시작.
			break;
		}
		System.out.println("경우의 수: "+totalCnt);
	}
	
	// 중복순열
	private static void dice1(int cnt) {
		// 순열완성
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
		
	}
	
	// 순열
	// 조금 전 까지 순열로 처리한 애들을 파라미터로 넘김 
	// 여담: 던지는 횟수가 7 이상이면 가능한 순열의 수는 0
	private static void dice2(int cnt) {
		// 순열완성
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			// 중복 체크
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			dice2(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	// 중복 조합
	private static void dice3(int cnt, int start) {
		
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i); // 현재 선택한 수 부터 처리하도록!
		}
		
	}
	
	// 조합
	// 시작 범위(start)부터 끝까지 체크 
	private static void dice4(int cnt, int start) {
		
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
		
	}

}
