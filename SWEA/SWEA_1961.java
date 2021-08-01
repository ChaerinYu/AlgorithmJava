package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * [D2] 1961. 숫자 배열 회전
 */
public class SWEA_1961 {
	
	private static int num = 0;
	// 90 degree 씩 도는 array
	private static int[][] turnMap(int[][] map) {
		int[][] tempMap = new int[num][num];
		
		for(int r=0; r<num; r++) {
			for(int c=0; c<num; c++) {
				tempMap[r][c] = map[num-1-c][r];
			}
		}
		
		return tempMap;
	}
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("src/SWEA/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			num = Integer.parseInt(reader.readLine());
//			String[][] map = new String[num][num];
			int[][] map = new int[num][num];
			
//			int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}}; // 90, 180, 270
			
			// insert 
			for(int r=0; r<num; r++) {
				String[] rows = reader.readLine().split(" ");
				for(int c=0; c<num; c++) {
					map[r][c] = Integer.parseInt(rows[c]);
				}
			}
			
			int[][] rotation90 = turnMap(map);
			int[][] rotation180 = turnMap(rotation90);
			int[][] rotation270 = turnMap(rotation180);
			

			System.out.println("#"+test_case);
			for(int r=0; r<num; r++) {
				for(int c=0; c<num; c++) {
					System.out.print(rotation90[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<num; c++) {
					System.out.print(rotation180[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<num; c++) {
					System.out.print(rotation270[r][c]);
				}
				System.out.println();
			}
			
			/*
			String[][] resultMap = new String[num][3];
			
			for(int r=0; r<num; r++) {
				for(int c=0; c<3; c++) {
					resultMap[r][c] = "";
				}
			}
			
			// 결과값은 무조건 row: num column: 3
			for(int r=0; r<num; r++) {

				int tempR = 0, tempC = 0;

				
				for(int c=0; c<3; c++) {

					if(c == 0) {
						tempR = num-1;
						tempC = r;
					} else if(c == 1) {
						tempR = num-1-r;
						tempC = num-1;
					} else { // 2열 
						tempR = 0;
						tempC = num-1-r;
					}
					
					for(int k=0; k<num; k++) {
						int nr = tempR+deltas[c][0]*k;
						int nc = tempC+deltas[c][1]*k;
						
//						if(nr<0 || nr>=num || nc<0 || nc>=num) break;
						resultMap[r][c] += map[nr][nc];
					}
				}
			}
			
			System.out.println("#"+test_case);
			for(int r=0; r<num; r++) {
				for(int c=0; c<3; c++) {
					System.out.print(resultMap[r][c]+ " ");
				}
				System.out.println();
			}
			
			*/
		}
		
	}
}
