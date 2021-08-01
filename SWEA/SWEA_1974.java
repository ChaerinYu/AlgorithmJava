package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * [D2] 1974.스도쿠 검증
 */
public class SWEA_1974 {

	public static final int[] dr = {0, 0, 0, 1, 1, 1, 2, 2, 2};
	public static final int[] dc = {0, 1, 2, 0, 1, 2, 0, 1, 2};
	
	public static final int SUDOKU_SIZE = 9;
	public static int[][] sudoku;
	public static int[] checked;
	
	public static int Answer = 0;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];
			
			// sudoku 값 입력 
			for(int r=0; r<SUDOKU_SIZE; r++) {
				String[] input = reader.readLine().split(" ");
				for(int c=0; c<SUDOKU_SIZE; c++) {

					sudoku[r][c] = Integer.parseInt(input[c]);
					
				}
			}
			
			Answer = 1; // sudoku Answer 초기화 
			
			sudokuchecked: for(int r=0; r<SUDOKU_SIZE; r++) {
				for(int c=0; c<SUDOKU_SIZE; c++) {
					checked = new int[SUDOKU_SIZE+1]; // 초기화 1~9
					if(r%3 == 0 && c%3 ==0) {
						// 3x3 check
						for(int temp=0; temp < SUDOKU_SIZE; temp++) {
							int nr = r + dr[temp];
							int nc = c + dc[temp];
							
							int tempCheck = checked[sudoku[nr][nc]];
							if(tempCheck != 0) {
								Answer = 0;
								break sudokuchecked;
							} else {
								checked[sudoku[nr][nc]] = 1;
							}
						}
						checked = new int[SUDOKU_SIZE+1]; // 초기화 
						
						// 행 row 체크
						for(int temp=0; temp <SUDOKU_SIZE; temp++) {
							int tempCheck = checked[sudoku[r][temp]];

							if(tempCheck != 0) {
								Answer = 0;
								break sudokuchecked;
							} else {
								checked[sudoku[r][temp]] = 1;
							}
						}
						checked = new int[SUDOKU_SIZE+1]; // 초기화 
						
						// 열 column 체크 
						for(int temp=0; temp <SUDOKU_SIZE; temp++) {
							int tempCheck = checked[sudoku[temp][c]];

							if(tempCheck != 0) {
								Answer = 0;
								break sudokuchecked;
							} else {
								checked[sudoku[temp][c]] = 1;
							}
						}
					}
					
				}
			}
			System.out.println("#"+test_case+" "+Answer);
		}
		
	}
}
