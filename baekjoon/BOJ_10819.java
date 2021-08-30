package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Study week 1
 * 10819. 차이를 최대로
 * @author ChaerinYu
 * N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * 첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
 * 첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.
 */
public class BOJ_10819 {
	
	static int N; 					// 배열 크기
	static int[] num; 				// 배열
	static int[] tempNum; 			// 순열 저장할 array
	static boolean[] isSelected; 	// 선택되었는지 체크
	static int res = 0; 			// 정답
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 배열 크기
		
		num = new int[N];
		tempNum = new int[N];
		isSelected = new boolean[N];
		
		// 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		
		System.out.println(res);
	}
	
	// N자리 순열만들기
	static void permutation(int cnt) {
		if(cnt == N) {
			int temp = 0;
			for (int i = 1; i < N; i++) {
				temp += Math.abs(tempNum[i]-tempNum[i-1]);
			}
			res = Math.max(res, temp);
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			tempNum[cnt] = num[i];
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
