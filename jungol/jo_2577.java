package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2577. 회전 초밥(고)
 * @author ChaerinYu
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1838&sca=90&page=2
 * 주어진 회전 초밥 벨트에서 먹을 수 있는 초밥의 가짓수의 최대값을 하나의 정수로 출력
 */
public class jo_2577 {

	static int N, d, k, c; // 접시 수, 초밥 종류 수, 연속해서 먹는 접시 수, 쿠폰 번호
	// 2≤N≤3,000,000, 2≤d≤3,000, 2≤k≤3,000 (k≤N), 1≤c≤d
	static int[] sushi; // 접시에 담긴 초밥
	static int[] mouth; // 내가 먹은 초밥들
	static int yum;
	
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
		k = Integer.parseInt(st.nextToken()); // 연속으로 먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		sushi = new int[N+k]; // 맨 마지막 원소 + 처음 1,2,3.., k-1번째 원소
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N+k; i++) {
			sushi[i] = sushi[i-N]; // 처음 1, 2, 3, .. , k-1번째 원소 넣기
		}
		
		mouth = new int[3010]; // 내 입안에 있는 초밥들 
		yum = 0; // 먹은 초밥 수
		
		eat(c); // 쿠폰이용해서 초밥 먹기 (쿠폰 포함 + 연속먹을 수 있는 횟수 -> 제일 많이 먹을 수 있는 상황)
		for (int i = 0; i < k-1; i++) {
			eat(sushi[i]); // k-1까지 먹은거 체크
		}
		res = 0; 
		// 1개 먹고 1개 뱉기 // k-1번째 다음부터 시작
		for (int i = 0; i < N; i++) {
			eat(sushi[i+k-1]); 
			res = Math.max(res, yum);
			spit(sushi[i]);
		}
		
		sb.append(res);
		System.out.println(sb);
	}

	// 퉤
	private static void spit(int dish) {
		mouth[dish] --;
		if(mouth[dish] ==0) yum--; // 내 입에 아예 없으면 먹어본 초밥 종류-1
	}

	// 냠냠
	private static void eat(int dish) {
		if(mouth[dish]==0) yum++; // 아직 안먹어본 초밥 (내 입에 없는 초밥) 먹으니까 먹어본 초밥 종류 +1
		mouth[dish] ++; // 지금 먹은 초밥 먹어본 횟수 +1 추가
	}
}
