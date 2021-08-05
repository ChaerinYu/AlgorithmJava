package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=992&sca=99&sfl=wr_hit&stx=1719
 * 1719 : 별삼각형2
 * 삼각형의 크기 n(n의 범위는 100 이하의 홀수)과 종류 m(m은 1부터 4사이의 자연수)을 입력받는다.
 */
public class jo_1719_2 {

	private static int n; // 삼각형 크기
	private static int m; // 출력 종류
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n<=0 || n>100 || n%2 == 0 || m<1 || m>4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int half = n/2;
		
		// 좌측정렬 >
		if(m==1) {
			for(int r=1; r<=n; r++) {
				if(r<=half+1) {
					for(int c=1; c<=r; c++) {
						System.out.print("*");
					}
				} else {
					for(int c=n; c>=r; c--) {
						System.out.print("*");
					}
				}
				
				System.out.println();
			}
		}
		// 좌측정렬 <
		else if(m==2) {
			for(int r=0; r<n; r++) {
				for(int c=0; c<=half; c++) {
					int temp = Math.abs(half-r);
					if(c<temp) System.out.print(" ");
					else System.out.print("*");
				}
				System.out.println();
			}
		}
		// 모래시계
		else if(m==3) {
			for(int r=0; r<half; r++) {
				for(int c=0; c<r; c++) 
					System.out.print(" ");
				for(int c=r; c<n-r; c++) 
					System.out.print("*");
				System.out.println();
			}
			for(int r=0; r<half+1; r++) {
				for(int c=0; c<half-r; c++) 
					System.out.print(" ");
				for(int c=0; c<=r*2;c++) 
					System.out.print("*");
				System.out.println();
			}
		}
		// 
		else if(m==4) {
			for(int r=0; r<n; r++) {
				if(r<=half) {
					for(int c=0; c<n-r; c++) {
						if(c<=half) {
							if(c<r) System.out.print(" ");
							else System.out.print("*");
						}
					}
				} else {
					for(int c=0; c<=r; c++) {
						if(c<half) System.out.print(" ");
						else System.out.print("*");
					}
				}
				System.out.println();
			}
		}
	}

}
