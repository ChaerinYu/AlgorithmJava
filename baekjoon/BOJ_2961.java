package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2961. 도영이가 만든 맛있는 음식
 */
public class BOJ_2961 {

	private static int N; // 재료 수
	private static int[] S; // 신 맛
	private static int[] B; // 쓴 맛
	
	private static boolean[] isSelected;
	
	private static int dish;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료 수
		
		S = new int[N]; // 신 맛(곱)
		B = new int[N]; // 쓴 맛(합)
		
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			S[i] = Integer.parseInt(input[0]);
			B[i] = Integer.parseInt(input[1]);
		}
		
		dish = Math.abs(S[0]-B[0]);
		subset(0);
		System.out.println(dish);
		
	}

	private static void subset(int cnt) {
		if(cnt == N) {
			int sour = 1, bitter = 0;
			boolean flag = false;
			for (int i = 0; i < cnt; i++) {
				if(isSelected[i]) {
					sour = sour * S[i];
					bitter = bitter + B[i];
					flag = true;
				}
				// 선택 한번도 안된 경우(flag=false)는 제외
				if(flag && Math.abs(sour-bitter) < dish) {
					dish = Math.abs(sour-bitter);
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		
		isSelected[cnt] = false;
		subset(cnt+1);
	}
}
