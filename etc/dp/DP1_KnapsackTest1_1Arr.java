package etc.dp;

import java.util.Scanner;
/**
 * 0/1 knapsack 일차원 배열만 사용
 * @author user
 *
 */
public class DP1_KnapsackTest1_1Arr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물건 수
		int W = sc.nextInt(); // 가방 최대 무게
		
		int[] weights = new int[N+1]; // 물건 무게
		int[] profits = new int[N+1]; // 물건 가치
		
		// 물건 0 개념 가져가므로 1부터 시작
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[] D = new int[W+1];
		for (int i = 1; i <= N; i++) {
			// 뒤에서부터 자신의 무게까지 for문
			for (int w = W; w >= weights[i]; w--) {
				// 이전 물건 vs 현재 물건의 가치 + 이전 물건(자신의 무게를 뺀 잔여무게)
				D[w] = Math.max(D[w], profits[i] + D[w-weights[i]]);
			}
		}
		
		System.out.println(D[W]);
		
	}
}
/**
[입력]
4
10
5 10
4 40
6 30
3 50

[출력]
90
*/
