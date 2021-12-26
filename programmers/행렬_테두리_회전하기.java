package programmers;

import java.util.Arrays;
/**
 * [2021 Dev-Matching] 행렬 테두리 회전하기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 */
public class 행렬_테두리_회전하기 {

	public static void main(String[] args) {
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] ans = solution(6, 6, queries);
		System.out.println(Arrays.toString(ans));
	}

	static int[][] map;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        prev(rows, columns);
        for (int i = 0; i < queries.length; i++) {
        	int[][] copy = new int[rows+1][columns+1];
        	for (int j = 0; j < copy.length; j++) {
        		copy[j] = Arrays.copyOf(map[j], columns+1);
			}
			// queries[i][0]: start row
        	// queries[i][1]: start column
        	// queries[i][2]: end row
        	// queries[i][3]: end column
        	
        	int min = 10_001;
        	// →: (start row, start column) -> (start row, end column)
//        	map[queries[i][0]][queries[i][1]] = copy[queries[i][0]+1][queries[i][1]];
        	for (int j = queries[i][1]+1; j <= queries[i][3]; j++) {
        		map[queries[i][0]][j] = copy[queries[i][0]][j-1];
        		if(min > map[queries[i][0]][j]) min = map[queries[i][0]][j];
			}
        	// ↓: (start row, end column)   -> (end row, end column)
        	for (int j = queries[i][0]+1; j <= queries[i][2]; j++) {
				map[j][queries[i][3]] = copy[j-1][queries[i][3]];
        		if(min > map[j][queries[i][3]]) min = map[j][queries[i][3]];
			}
        	// ←: (end row, end column)     -> (end row, start column)
        	for (int j = queries[i][3]-1; j >= queries[i][1]; j--) {
				map[queries[i][2]][j] = copy[queries[i][2]][j+1];
        		if(min > map[queries[i][2]][j]) min = map[queries[i][2]][j];
			}
        	// ↑: (end row, start column)   -> (start row, start column)
        	for (int j = queries[i][2]-1; j >= queries[i][0]; j--) {
        		map[j][queries[i][1]] = copy[j+1][queries[i][1]];
        		if(min > map[j][queries[i][1]]) min = map[j][queries[i][1]];
			}
        	
        	answer[i] = min;
//        	print();
        	
		}
        
        return answer;
    }
    
    private static void print() {
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
    }

    // 행렬 입력
	private static void prev(int rows, int columns) {
		map = new int[rows+1][columns+1];
		
		int num = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = num++;
			}
		}
	}
}
