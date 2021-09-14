package etc.dp;

import java.util.Scanner;
/**
 * DP Knapsack
 * int[][] D = new int[2][W+1];
 * @author user
 *
 */
public class DP3_KnapsackTest2 {

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
		
		int[][] D = new int[2][W+1]; // new int[2][W+1]로도 해보기
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				
				if(weights[i] <= w) { // 해당 물건을 가방에 넣을 수 있다.
					// 이전 물건 vs 현재 물건의 가치 + 이전 물건(자신의 무게를 뺀 잔여무게)
					if(i%2==1)
						D[1][w] = Math.max(D[0][w], profits[i] + D[0][w-weights[i]]);
					else
						D[0][w] = Math.max(D[1][w], profits[i] + D[1][w-weights[i]]);
				} else { // 해당 물건을 가방에 넣을 수 없다.
					if(i%2==1)
						D[1][w] = D[0][w];
					else 
						D[0][w] = D[1][w];
				}
			}
		}
		
		System.out.println(D[N%2][W]);
		
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
