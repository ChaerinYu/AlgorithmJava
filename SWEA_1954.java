package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D2] 1954.달팽이 숫자
 */
public class SWEA_1954 {
	public static final int[] dr = {0, 1, 0, -1};
	public static final int[] dc = {1, 0, -1, 0};
	
	public static int[][] snail;
	public static int[][] checked;
	
	public static void main(String args[]) throws Exception
	{
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			int num = Integer.parseInt(reader.readLine());
			
			snail = new int[num][num];
			checked = new int[num][num];
			
			int cnt = num, snailCnt = 1, order = 0, r = 0, c = -1;

			while(true) {
				//System.out.println("1order: "+order);
				for(int i=0; i<cnt; i++) {
					c = c+dc[order];
					
					snail[r][c] = snailCnt++;
					checked[r][c] = 1;
				}
				cnt--;
				order = ++order%4;
				//System.out.println("2order: "+order);
				//System.out.println(order);
				for(int i=0; i<cnt; i++) {
					r = r+dr[order];

					snail[r][c] = snailCnt++;
					checked[r][c] = 1;
				}
				order = ++order%4;
				//System.out.println("3order: "+order);
				if(cnt==0) break;
			}
			System.out.println("#"+test_case);
			for(int i=0; i<snail.length; i++) {
				for(int j=0; j<snail.length; j++ ) {
					System.out.print(snail[i][j]+" ");
				}
                System.out.println();
			}
            
			
		}
		
	}
}
