package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D2] 2001. 파리 퇴치 
 */
public class SWEA_2001 {

	public static int[] dr; // 0, 0, 1, 1
	public static int[] dc; // 0, 1, 0, 1
	
	public static int[][] flies;
	
	public static int Answer = 0;
	
	public static int N = 0; // 파리 배열 크기
	public static int M = 0; // 파리채 크기 
	public static int MAX = Integer.MIN_VALUE;
	
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			String[] input = reader.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			
			flies = new int[N][N];
			
			dr = new int[M*M];
			dc = new int[M*M];
			
			int deltaNum = 0;
			// dr 배열 업데이트 0 ... 1 ... 2...
			for(int i=0; i<M*M; i++) {
				if(i!=0 && i % M == 0) {
					deltaNum++;
				}
				dr[i] = deltaNum;
			}
			// dc 배열 업데이트 0 1 2 .. 0 1 2 ..
			for(int i=0; i<M*M; i++) {
				if(i % M == 0) {
					deltaNum = 0;
				}
				dc[i] = deltaNum++;
			}
			
			
			
			// 파리 값 입력 
			for(int r=0; r<N; r++) {
				String[] fliesR = reader.readLine().split(" ");
				for(int c=0; c<N; c++) {

					flies[r][c] = Integer.parseInt(fliesR[c]);
					
				}
			}
			
			Answer = Integer.MIN_VALUE;
			
			for(int r=0; r<N-M+1; r++) {
				for(int c=0; c<N-M+1; c++) {
					int sum = 0;
					for(int i=0; i<M*M; i++) {
						int nr = r+dr[i];
						int nc = c+dc[i];
						
						sum+= flies[nr][nc];
					}
					
					Answer = Math.max(sum, Answer);
				}
			}
			System.out.println("#"+test_case+" "+Answer);
		}
		
	}
}
