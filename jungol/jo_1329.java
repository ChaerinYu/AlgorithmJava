package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=608&sca=99&sfl=wr_hit&stx=1329
 * 1329. 별삼각형3
 */
public class jo_1329 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 삼각형의 높이
		
		// 100 이하의 양의 홀수가 아니면 return
		if(N%2 == 0 || N>100) {
			System.out.println("INPUT ERROR!");
			return;
		} else {
			for(int r=1; r<=N; r++) {
				if(r<=N/2+1) {
					for(int c=1; c<r; c++) {
						System.out.print(" ");
					}
					for(int c=1; c<=2*r-1; c++) {
						System.out.print("*");
					}
				} else {
					for(int c=1; c<=N-r; c++) {
						System.out.print(" ");
					}
					for(int c=1; c<=2*(N-r)+1; c++) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
	}

}
