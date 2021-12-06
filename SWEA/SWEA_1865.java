package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * [D4] 1865. 동철이의 일 분배
 * @author Chaerin Yu
 * 못품 ㅠㅠ
 */
public class SWEA_1865 {

	static int N; // 직원 수
	static boolean[] isSelected;
	static double works[][], arr[]; // 직원마다 일 성공할 확률, 직원이 하는 일(정답)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 직원 수
			
			works = new double[N+1][N+1]; // 직원마다 일 성공 확률
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					works[i][j] = Double.parseDouble(st.nextToken()) / 100; // 일 성공확률 입력
				}
			}
			arr = new double[N+1];
			isSelected = new boolean[N+1];
			perm(0);
		}
		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			arr[cnt] = works[cnt][i];
			isSelected[i] = true;
			
			perm(cnt+1);
			isSelected[i] = false;
		} 
	}

}
