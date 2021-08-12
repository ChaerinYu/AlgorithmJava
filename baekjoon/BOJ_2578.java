package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 2578. 빙고 
 */
public class BOJ_2578 {

	private static final int SIZE = 5; // 빙고 사이즈
	private static int[][] map = new int[SIZE][SIZE]; // 빙고판
	private static int[][] step = new int[SIZE][SIZE]; // 사회자가 부르는 순서
	
	private static boolean[][] checked = new boolean[SIZE][SIZE]; // 호출된거 지우기
	
	private static int bingoNum = 0; // 빙고 갯수
	private static int count = 0; // 정답
	private static HashSet<Integer> lineCheck = new HashSet<Integer>(); // 각 케이스 별로 빙고개수 세기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 빙고판 입력
		for (int i = 0; i < SIZE; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		// 사회자가 부르는 숫자 입력
		counting: 
		for (int i = 0; i < SIZE; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < SIZE; j++) {
				step[i][j] = Integer.parseInt(input[j]);
				
				// 사회자의 번호 호출 동시에 map 위치 찾기
				lookFor: 
				for (int k = 0; k < SIZE; k++) {
					for (int l = 0; l < SIZE; l++) {
						
						// 현재 사회자가 호명한 번호 위치 발견시
						if(map[k][l] == step[i][j]) {
							checked[k][l] = true;
							
							bingoNum = 0; // 빙고 갯수
							
							checkBingo();
							
							// 빙고가 3개 이상일 때로 확인해줘야 한다.
							if(bingoNum >= 3) {
								count = i*SIZE + (j+1);
								break counting;
							}
							
							break lookFor;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	// 빙고 체크하기
	private static void checkBingo() {
		// row
		for (int r = 0; r < SIZE; r++) {
			lineCheck.clear();
			for (int c = 0; c < SIZE; c++) {
				if(checked[r][c])
					lineCheck.add(c);
			}
			if(lineCheck.size() == SIZE) bingoNum = bingoNum+1;
		}
		// column
		for (int c = 0; c < SIZE; c++) {
			lineCheck.clear();
			for (int r = 0; r < SIZE; r++) {
				if(checked[r][c])
					lineCheck.add(r);
			}
			if(lineCheck.size() == SIZE) bingoNum = bingoNum+1;
		}
		// diagonal 1 /
		lineCheck.clear();
		for (int r = 0; r < SIZE; r++) {
			if(checked[r][r])
				lineCheck.add(r);
			if(lineCheck.size() == SIZE) bingoNum = bingoNum+1;
		}
		// diagonal 2 \
		lineCheck.clear();
		for (int r = 0; r < SIZE; r++) {
			if(checked[r][(SIZE-1)-r])
				lineCheck.add(r);
			if(lineCheck.size() == SIZE) bingoNum = bingoNum+1;
		}
	}

}
