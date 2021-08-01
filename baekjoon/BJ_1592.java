package baekjoon;

import java.util.Scanner;

/*
 * 1592. 영식이와 친구들
 */
public class BJ_1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] receiveNum = new int[N];
		int order = 0;
		int cnt = 0;
		
		while(true) {
			receiveNum[order%N]++;
			
			if(receiveNum[order%N] == M) break;
			
			// 현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게, 
			// 짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
			if(receiveNum[order%N]%2 == 0) {
				order = order - L;
				if(order<=0) order += N;
			}
			else order = order + L;
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
