package SWEA;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
  [D3] 2805. 농작물 수확하기
 */
class SWEA_2805
{

	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int size = Integer.parseInt(reader.readLine());
            
			int[][] map = new int[size][size];
			

			for(int r=0; r<size; r++) {
				String[] input = reader.readLine().split("");
				for(int c=0; c<size; c++) {
					map[r][c] = Integer.parseInt(input[c]);
				}
			}
			
			int sum = 0;
			for(int r=0; r<size; r++) {
				if(r <= size/2) {
					for(int c=size/2-r; c<=size/2+r; c++) {
						sum += map[r][c];
					}
				} else {
					for(int c=size/2-(size-r)+1; c<size/2+(size-r); c++) {
						sum += map[r][c];
					}
				}
			}
            
            System.out.println("#"+test_case+ " " + sum);
            
		}
	}
}

