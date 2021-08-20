package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2116. 주사위 쌓기
 * @author user
 * 첫줄에는 주사위의 개수가 입력된다. 그 다음 줄부터는 한 줄에 하나씩 주사위의 종류가 1번 주사위부터 주사위 번호 순서대로 입력된다. 
 * 주사위의 종류는 각 면에 적혀진 숫자가 그림1에 있는 주사위의 전개도에서 A, B, C, D, E, F 의 순서로 입력된다. 
 * 입력되는 숫자 사이에는 빈 칸이 하나씩 있다. 주사위의 개수는 10,000개 이하이며 종류가 같은 주사위도 있을 수 있다.
 */
public class BOJ_2116 {

	static int N; // 주사위 개수
	static int[][] dice; // 주사위
	
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		
		dice = new int[N][6];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				// 0, 5 / 1, 3 / 2, 4 쌍을 이루는데 각 index 합 5로 맞추기 위해 3과 4를 바꿔서 입력한다.
				if(j==3)
					dice[i][4] = Integer.parseInt(st.nextToken());
				else if(j==4)
					dice[i][3] = Integer.parseInt(st.nextToken());
				else
					dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 주사위 하나일 때
		if(N == 1) {
			System.out.println(6);
			return;
		}
		
		res = 0;
		int firstSideMax = 6; // 첫번째 주사위의 옆면 중 최대값
		for (int i = 0; i < 6; i++) {
			// 위아래 면 중 6이 있는 경우, 최대 값은 5
			// 0,5/1,4/2,3 쌍을 이룸
			if(dice[0][i]+dice[0][5-i] == 11) firstSideMax = 4; // 위아래가 5, 6
			else if(dice[0][i] == 6 || dice[0][5-i] == 6) firstSideMax = 5; // 위 or 아래가 6
			else firstSideMax = 6; // 그 외
			
			res = Math.max(res, build(dice[0][i], dice[0][5-i], firstSideMax)); // 1번째 주사위 바닥
		}
		
		// 첫 번째 주사위 옆면 최대값 + 나머지 주사위 옆면 합 최대값
		System.out.println(res);
		
	}

	// 주사위 쌓기
	/**
	 * 
	 * @param bottom 첫번째 주사위 바닥
	 * @param top 첫번째 주사위 윗면
	 * @param sideMax 첫번째 주사위 옆면 최대값
	 * @return 첫번째주사위 위아래가 bottom, top과 같을 때, 나머지 주사위 한 옆면 합 최대값
	 */
	static int build(int bottom, int top, int sideMax) {
		int max = 0; 
		int sum = sideMax;
		for (int i = 1; i < dice.length; i++) {

			
			for (int j = 0; j < 6; j++) {
				// 이전 주사위 바닥과 같은 경우 (현재 주사위의 윗면)
				if(dice[i][j] == bottom) {
					top = dice[i][j];
					bottom = dice[i][5-j]; // bottom을 현재 주사위의 아랫면으로 업데이트해준다.
					break;
				}
			}
			
			if(top+bottom == 11) { // 위 아래가 6, 5인 경우
				sum += 4;
			} else if(top == 6 || bottom == 6) { // 위 아래 둘 중 하나가 6인 경우
				sum += 5;
			} else { // 그 외
				sum += 6;
			}
			
			max = Math.max(max, sum);
		}
		return max;
	}
}
