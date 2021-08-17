package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 3985. 롤 케이크
 * 첫째 줄에 롤 케이크의 길이 L (1 ≤ L ≤ 1000)이 주어진다. 
 * 둘째 줄에는 방청객의 수 N (1 ≤ N ≤ 1000)이 주어진다. 
 * 다음 N개 줄에는 각 방청객 i가 종이에 적어낸 수 Pi와 Ki가 주어진다. (1 ≤ Pi ≤ Ki ≤ L, i = 1..N)
 *  방청객은 1번부터 N번까지 번호가 매겨져 있다. 각 방청객은 종이에 자신이 원하는 조각을 적어서 낸다. 이때, 두 수 P와 K를 적어서 내며, P번 조각부터 K번 조각을 원한다는 뜻이다.
 */
public class BOJ_3985 {

	private static int L; // 롤케이크 길이
	private static int N; // 방청객 수
	private static int[] P; // 방청객이 적은 수 P번 조각
	private static int[] K; // 방청객이 적은 수 K번 조각
	
	private static int[] cake; // 롤 케이크
	
	private static int expected; // 많은 조각 받을거라고 기대하는 사람
	private static int real; // 실제로 많이 받은 사람
	private static int expectedCnt; // 많은 조각 받을거라고 기대하는 사람 조각 수
	private static int realCnt; // 실제로 많이 받은 사람 조각 수
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 입력
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		P = new int[N];
		K = new int[N];
		
		cake = new int[L];
		
		// 조각개수 제일 많은 사람을 찾기 위하여 최솟값으로 초기화해준다.
		expectedCnt = Integer.MIN_VALUE;
		realCnt = Integer.MIN_VALUE;

		// 첫 번째 사람으로 초기화해준다.
		expected = 1; real = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tempP = Integer.parseInt(st.nextToken());
			int tempK = Integer.parseInt(st.nextToken());
			P[i] = tempP;
			K[i] = tempK;
			
			// 케이크 나눠주기 (시작 조각, 끝 조각, 사람 순서)
			shareCake(tempP, tempK, i+1);
			
			// 기대한 케이크 조각 수 최대값 업데이트
			if(expectedCnt<tempK-tempP) {
				expectedCnt = tempK-tempP;
				expected = i+1; // index는 0부터 시작하므로 +1해준다.
			}
		}
		
		// 제일 많이 받을 거라 기대한 사람 과 실제로 많이 받은 사람 출력
		System.out.println(expected);
		System.out.println(real);
	}
	
	// 케이크 나눠주기
	private static void shareCake(int start, int dest, int number) {
		// 실제로 받은 케이크조각
		int cakePiece = 0;
		// index 0부터 시작하기 때문에 -1해준다.
		for (int i = start-1; i <= dest-1; i++) {
			// 아직 아무도 안가져간 케이크인 경우, 할당해준다.
			if(cake[i] == 0) {
				cake[i] = number;
				cakePiece++;
			}
		}
		// 실제로 받은 케이크 조각 수 최대값 업데이트
		if(realCnt < cakePiece) {
			realCnt = cakePiece;
			real = number;
		}
	}
}
