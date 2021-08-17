package SWEA;

import java.util.Scanner;

/*
 * 1940. 가랏! RC카!
 */
public class Solution_0809_SWEA_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		int N;
		for (int t = 1; t <= TC; t++) {
			int res = 0; // 누적된 거리 값
			int ac = 0;
			N = sc.nextInt();
			int cmd;
			for (int i = 0; i < N; i++) {
				cmd = sc.nextInt();
				switch(cmd) {
					case 0:
						break;
					case 1: // 가속
						ac = ac+sc.nextInt();
						break;
					case 2: // 감속
						ac = ac-sc.nextInt();
						if(ac<0) ac = 0;
						break;
				}
				res = res+ac;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
