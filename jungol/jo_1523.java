package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=795&sca=99&sfl=wr_hit&stx=1523
 * 1523 : 별삼각형1
 * 삼각형의 크기 n(n의 범위는 100 이하의 자연수)과 종류 m(m은 1부터 3사이의 자연수)을 입력받는다.
 */
public class jo_1523 {

	private static int n; // 삼각형 크기
	private static int m; // 출력 종류
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n<=0 || n>100 || m<1 || m>3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		// 좌측정렬+증가
		if(m==1) {
			for(int r=1; r<=n; r++) {
				for(int c=1; c<=r; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		// 좌측정렬+감소
		else if(m==2) {

			for(int r=n; r>=1; r--) {
				for(int c=1; c<=r; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
		// 중앙정렬+증가
		else if(m==3) {

			for(int r=1; r<=n; r++) {
				for(int c=r; c<n; c++) {
					System.out.print(" ");
				}
				for(int c=1; c<=2*r-1; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
