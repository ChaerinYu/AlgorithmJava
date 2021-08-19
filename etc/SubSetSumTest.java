package etc;

import java.util.Scanner;
/**
 * 모든 수가 자연수라는 전제!
 * @author user
 *
 */
public class SubSetSumTest {

	static int N, totalCnt, S, totalCnt2, totalCnt3; // S: 목표 합
	static int[] input;
	static boolean[] isSelected;
	
	static int callCnt2, callCnt3; // 호출 횟수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		input = new int[N];
		isSelected = new boolean[N];
		totalCnt = 0;
		callCnt2 = callCnt3 = totalCnt2 = totalCnt3 = 0;
//		callCnt3 = callCnt2 = totalCnt3 = totalCnt2 = 0;
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
//		generateSubset(0); // 부분집합에 고려된 애가 아무도 없으므로 0부터 시작한다.
//		if(S == 0) totalCnt--;
//		System.out.println("경우의 수: "+totalCnt);

		generateSubset2(0, 0); // 부분집합에 고려된 애가 아무도 없으므로 0부터 시작한다.
		System.out.println("경우의 수: "+totalCnt2+", 호출 횟수: "+callCnt2);

		generateSubset3(0, 0); // 부분집합에 고려된 애가 아무도 없으므로 0부터 시작한다.
		System.out.println("경우의 수: "+totalCnt3+", 호출 횟수: "+callCnt3);
	}
	
	/**
	 * 부분집합
	 */
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
	
	/**
	 * 백트래킹1
	 * 가지치기 하지 않은 버전
	 * @param cnt
	 * @param sum
	 */
	private static void generateSubset2(int cnt, int sum) { // cnt: 부분집합을 처리하기 위해 고려된 원소 수
		
		callCnt2++;
		
		if(cnt == N) {
			// 부분집합 완성
			
			// 부분집합의 합 == 목표합 체크 
			// 목표 합이 0인 경우는, 공집합도 포함하므로 공집합의 경우는 제외하고 계산해줘야 한다.
			if(sum == S) {
				totalCnt2++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i]+ " ");
				}
				System.out.println();
			}
			
			return;
		}
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset2(cnt+1, sum+input[cnt]); // 뒤에 올 수 있는 모든 상황을 다 했다.
		
		// 현재 원소를 부분집합에 넣지않기
		isSelected[cnt] = false;
		generateSubset2(cnt+1, sum);
	}
	
	/**
	 * 백트래킹2
	 * @param cnt
	 * @param sum
	 */
	private static void generateSubset3(int cnt, int sum) { // cnt: 부분집합을 처리하기 위해 고려된 원소 수
															// sum: 기존까지 부분집합 구성원소들의 합
		callCnt3++;
		
		// 부분집합의 합 == 목표합 체크 
		// 목표 합이 0인 경우는, 공집합도 포함하므로 공집합의 경우는 제외하고 계산해줘야 한다.
		if(sum == S) {
			totalCnt3++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) System.out.print(input[i]+ " ");
			}
			System.out.println();
			return;
		}

		// 합이 초가되거나 N개의 부분집합 다 만들었을 경우
		// (위에서 RETURN안되고 내려왔으면 합이 S가 안된 경우)
		if(sum>S || cnt == N) return;
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset3(cnt+1, sum+input[cnt]); // 뒤에 올 수 있는 모든 상황을 다 했다.
		
		// 현재 원소를 부분집합에 넣지않기
		isSelected[cnt] = false;
		generateSubset3(cnt+1, sum);
	}

}
/**
 * 
 입력
5 21
5 6 10 11 16
 결과
5 6 10 
5 16 
10 11 
경우의 수: 3
 */

/**
6 21
5 21 11 16 6 10
5 16 
5 6 10 
21 
11 10 
경우의 수: 4, 호출 횟수: 127
5 16 
5 6 10 
21 
11 10 
경우의 수: 0, 호출 횟수: 1
*/