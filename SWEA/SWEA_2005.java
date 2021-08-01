package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D2] 2005. 파스칼의 삼각형 
 */
public class SWEA_2005 {

	public static int[][] triangle;
	
	
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
//			String[] input = reader.readLine().split(" ");
			int size = Integer.parseInt(reader.readLine());
			
			triangle = new int[size][];
			
			for(int i=0; i<size; i++) {
				
				// 1, 2번째 라인에서는 1, 1 1 만 찍음
				if( i == 0 ) {
					triangle[0] = new int[1];
					triangle[0][0] = 1;
				} else if ( i == 1 ) {
					triangle[1] = new int[2];
					triangle[1][0] = 1;
					triangle[1][1] = 1;
				} else {

					triangle[i] = new int[i+1];

					triangle[i][0] = 1;
					for(int j=1; j<i; j++) {
						triangle[i][j] += triangle[i-1][j-1] + triangle[i-1][j];
					}
					triangle[i][i] = 1;
					
				}
			}

			System.out.println("#"+test_case);
			for(int i=0; i<size; i++) {
				for(int j=0; j<triangle[i].length; j++) {
					System.out.print(triangle[i][j]+ " ");
				}
				System.out.println();
			}
			
		}
		
	}
}
