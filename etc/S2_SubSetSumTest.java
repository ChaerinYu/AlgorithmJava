package etc;

import java.util.Scanner;

public class S2_SubSetSumTest {

	static int N, totalCnt, S; // S: 목표 합
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		input = new int[N];
		isSelected = new boolean[N];
		totalCnt = 0;
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0); // 부분집합에 고려된 애가 아무도 없으므로 0부터 시작한다.
		if(S == 0) totalCnt--;
		System.out.println("경우의 수: "+totalCnt);
	}
	
	// 순열 조합 같은 경우는 앞에 처리된 개수! 
	// 얘는 넣든 넣지 않든 어디(어느 원소)까지 처리되었는지 확인하는 파라미터
	private static void generateSubset(int cnt) { // cnt: 부분집합을 처리하기 위해 고려된 원소 수
		if(cnt == N) {
			// 부분집합 완성
			
			// 부분집합의 합을 계산한다.
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) sum += input[i];
			}
			// 부분집합의 합 == 목표합 체크 
			// 목표 합이 0인 경우는, 공집합도 포함하므로 공집합의 경우는 제외하고 계산해줘야 한다.
			if(sum == S) {
				totalCnt++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i]+ " ");
				}
				System.out.println();
			}
			
			return;
		}
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt+1); // 뒤에 올 수 있는 모든 상황을 다 했다.
		
		// 현재 원소를 부분집합에 넣지않기
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}

}
