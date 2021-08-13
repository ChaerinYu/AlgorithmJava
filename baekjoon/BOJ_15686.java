package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 15686. 치킨 배달
 * 1: 집, 2: 치킨 집
 * 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 
 * 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
 * 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.
 * 
 * 조합을 이용하여 풀어야 한다.
 * 부분집합으로 풀게 될 경우, M개가 아닌 모든 경우의 수를 고려하기 때문에 더 걸린다.
 * 문제에서 추출해야 하는 값(남길 치킨집 개수)을 받기때문에 조합으로 풀면 된다.
 * 
 */
public class BOJ_15686 {

	private static int[][] city; // 도시
	
	private static int N; // 도시 크기
	private static int M; // 수익 많이 볼수 있는 최대 치킨집 개수
	
	private static int[][] houseLocation; // 집 위치 저장
	private static int[][] chickenLocation; // 치킨집 위치 저장
	private static int[][] selectedChicken; // 치킨집 위치 저장
	
	private static int indexH; // 입력된 집 수
	private static int indexC; // 입력된 치킨 집 수

	private static int tempAnswer;
	private static int answer;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 도시 크기
		M = Integer.parseInt(input[1]); // 최대 수익 치킨집 수
		
		city = new int[N+1][N+1];
		houseLocation = new int[2*N][2];
		chickenLocation = new int[13][2];
		selectedChicken = new int[M][2];
		
		// 도시 입력
		indexH = 0;
		indexC = 0;
		for (int r = 1; r <= N; r++) {
			input = br.readLine().split(" ");
			for (int c = 1; c <= N; c++) {
				city[r][c] = Integer.parseInt(input[c-1]);
				// 사람사는집 위치 저장
				if(city[r][c] == 1) {
					houseLocation[indexH][0] = r;
					houseLocation[indexH][1] = c;
					indexH++;
				}
				// 치킨집 위치 저장
				else if(city[r][c] == 2) {
					chickenLocation[indexC][0] = r;
					chickenLocation[indexC][1] = c;
					indexC++;
				}
			}
		}
		
		
		answer = Integer.MAX_VALUE; tempAnswer=0;
		combination(0, 0);
		
		
		System.out.println(answer);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			int min; tempAnswer = 0;
			for (int i = 0; i < indexH; i++) {
				min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int location = Math.abs(houseLocation[i][0]-selectedChicken[j][0])
							+ Math.abs(houseLocation[i][1]-selectedChicken[j][1]);
					min = Math.min(min, location); // 집에서 제일 가까운 치킨집 거리
				}
				tempAnswer += min;
			}
			answer = Math.min(answer, tempAnswer);
			return;
		}
		
		for (int i = start; i < indexC; i++) {
			selectedChicken[cnt] = chickenLocation[i];
			
			combination(cnt+1, i+1);
		}
	}
	
}
