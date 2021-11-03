package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2021.11.03
 * 종이의 개수
 * @author Chaerin Yu
 */
public class BOJ_1780 {

	private static int N; // 종이 크기
	private static int[][] paper;
	
	private static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken())+1; // -1, 0, 1 -> 0, 1, 2
			}
		}
		
		nums = new int[3];
		go(0, 0, N);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static void go(int sr, int sc, int size) {
		int start = paper[sr][sc];
		
		boolean flag = false;
		out: 
		for (int i = sr; i < sr+size; i++) {
			for (int j = sc; j < sc+size; j++) {
				if(start != paper[i][j]) {
					flag = true;
					break out;
				}
			}
		}
		
		if(!flag) {
			nums[start]++;
			return;
		}
		
		int temp = size/3;
		
		go(sr, sc, temp);
		go(sr+temp, sc, temp);
		go(sr+2*temp, sc, temp);
		
		go(sr, sc+temp, temp);
		go(sr+temp, sc+temp, temp);
		go(sr+2*temp, sc+temp, temp);
		
		go(sr, sc+2*temp, temp);
		go(sr+temp, sc+2*temp, temp);
		go(sr+2*temp, sc+2*temp, temp);
		
//		System.out.printf("%d %d %d %n", start, sr, sc);
	}
	
	
}
