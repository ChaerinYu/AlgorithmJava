package etc;

import java.util.Scanner;
/**
 * 같은 행에 두지 않는 방식
 * N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수
 * @author user
 *
 */
public class NQueenTest2 {
	
	static int N;
	static int[] col;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 한 행에 하나의 퀸이 있으므로,
		// 1차원 배열로 선언하여 각 배열에 queen의 열 위치를 저장한다.
		col = new int[N+1]; // 1행부터 시작할 거라서(0 index 안 씀) N+1로 선언
		cnt = 0;
		
		setQueens(1); // 1행부터 시작하므로
		System.out.println(cnt);
	}
	
	private static void setQueens(int rowNo) {
		
		// 기저 조건
		if(rowNo > N) { // N행까지 놔야하니까 > N
			// 마지막 행 까지 다 놔둔 경우
			cnt++;
			return;
		}
		
		// 현재 퀸 1열부터 N열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i; // i열에 놓아보기
			
			// 유망여부 체크: rowNo행 까지 유망한지 체크
			if(isAvailable(rowNo)) {
				setQueens(rowNo+1); // 다음행에 놓기
			}
		}
	}
	
	// 첫 번째 행 부터 다 비교해야 한다.
	// parameter rowNo: 현재 검사하려는 퀸
	private static boolean isAvailable(int rowNo) {
		
		for (int k = 1; k < rowNo; k++) { // k: 이전 퀸
			// 이전 열 index들은 이미 비교했기 때문에 현재 검사하려는 퀸만 구분해주면 된다.
			// 같은 열 인지, 대각선에 있는지 체크
			if(col[rowNo] == col[k] || Math.abs(col[rowNo]-col[k]) == (rowNo-k) ) {
				return false; // 유망하지 않음
			}
		}
		return true;
		
	}
}
