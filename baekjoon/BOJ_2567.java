package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2567. 색종이 - 2
 * @author Chaerin Yu
 * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 
 * 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
 * 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 둘레의 길이를 구하는 프로그램을 작성하시오.
 * 색종이의 수는 100이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다. 
 * 
 */
public class BOJ_2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 색종이 수
		
		int[][] map = new int[102][102]; // 도화지
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for (int r = y; r <= y+10; r++) {
				for (int c = x; c <= x+10; c++) {
					map[r][c]++;
				}
			}
		}
		
		int res = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(map[i][j] == 1) {
					if(map[i-1][j] == 0) res++;
					if(map[i][j-1] == 0) res++;
					if(map[i+1][j] == 0) res++;
					if(map[i][j+1] == 0) res++;
				}
			}
		}
		
		System.out.println(res);
	}
}
