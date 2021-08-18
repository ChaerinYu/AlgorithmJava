package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2477. 참외밭
 * @author user
 * 첫 번째 줄에 1m2의 넓이에 자라는 참외의 개수를 나타내는 양의 정수 K (1 ≤ K ≤ 20)가 주어진다. 
 * 참외밭을 나타내는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이 (1 이상 500 이하의 정수) 가 
 * 둘째 줄부터 일곱 번째 줄까지 한 줄에 하나씩 순서대로 주어진다. 변의 방향에서 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
 * 첫째 줄에 입력으로 주어진 밭에서 자라는 참외의 수를 출력한다.
 */
public class BOJ_2477 {

	private static int K; // 1제곱미터당 참외 개수
	private static int[] dir;
	private static int[] len;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		// 1, 2로 입력받은 숫자 중 max 구하기 (동, 서)
		// 3, 4 로 입력받은 숫자 중 max 구하기 (남, 북)
		StringTokenizer st = null;
		
		int heightMAX = 1;
		int widthMAX = 1;
		int heightIdx = 0, widthIdx = 0;
		dir = new int[6];
		len = new int[6];

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			dir[i] = Integer.parseInt(st.nextToken()); // 방향
			len[i] = Integer.parseInt(st.nextToken()); // 길이
			
			if(dir[i]==3 || dir[i]==4) {
				if(len[i] > heightMAX) {
					heightMAX = len[i];
					heightIdx = i;
				}
			} else {
				if(len[i] > widthMAX) {
					widthMAX = len[i];
					widthIdx = i;
				}
			}
		}
		
		// 참외밭은 무조건 반시계 방향!
		// heightMAX와 widthMAX는 서로 붙어있음
		// 안짤린 변의 길이 둘 다 나온 후, 2번째 3번째 변의 길이가 짤린 길이
		// ex) 5번째 0번째 길이 -> 2번째 3번째 변의 길이
		if((heightIdx == 0 && widthIdx == 5) || (heightIdx == 5 && widthIdx == 0)) {
			System.out.println(K*(heightMAX*widthMAX-len[2]*len[3]));
		} else {
			int tempIdx = Math.max(heightIdx, widthIdx);
			System.out.println(K*(heightMAX*widthMAX-len[(tempIdx+2+6)%6]*len[(tempIdx+3+6)%6]));
		}
	}
}
