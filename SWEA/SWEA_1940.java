package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D2] 1940. 가랏! RC카!
 * 입력으로 매 초마다 아래와 같은 command 가 정수로 주어진다.
	0 : 현재 속도 유지.
	1 : 가속
	2 : 감속
	위 command 중, 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.
	가속도의 단위는, m/s2 이며, 모두 양의 정수로 주어진다.
	입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 거리를 계산하는 프로그램을 작성하라.

 * 	1. N은 2이상 30이하의 정수이다. (2 ≤ N ≤ 30)
	2. 가속도의 값은 1 m/s2 혹은 2 m/s2 이다.
	3. 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.
 */
public class SWEA_1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/input_1940.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case
		
		StringTokenizer st = null;
		int N = 0; // 커맨드 수
		int command = 0; // 시간 (초)마다의 명령
		int accel = 0; // 유지, 가속, 감속
		int velocity = 0; // 가속도
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 커맨드 수
			velocity = 0;
			accel = 0;
			int distance = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				command = Integer.parseInt(st.nextToken()); // command
				if(command != 0)
					accel = Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					// 유지
				} else if(command == 1) {
					// 가속
					velocity += accel;
				} else {
					// 감속
					if(accel>velocity) velocity = 0;
					else velocity -= accel;
				}
				distance += velocity;
				
			}
			System.out.println("#"+tc+" "+distance);
		}
	}

}
