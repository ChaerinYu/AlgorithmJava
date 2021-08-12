package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2961. 도영이가 만든 맛있는 음식
 * 바이너리 카운팅 (binary counting)
 */
public class BOJ_2961_2 {

	private static int N; // 재료 수
	private static int[] S; // 신 맛
	private static int[] B; // 쓴 맛
	
	private static int dish;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료 수
		
		S = new int[N]; // 신 맛(곱)
		B = new int[N]; // 쓴 맛(합)
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			S[i] = Integer.parseInt(input[0]);
			B[i] = Integer.parseInt(input[1]);
		}
		
		dish = Math.abs(S[0]-B[0]);
		binarycounting();
		System.out.println(dish);
		
	}
	
	private static void binarycounting() {
		
		for (int i = 0; i < (1<<N); i++) {
			int sour = 1, bitter = 0;
			for (int j = 0; j < N; j++) {
				if( (i & 1<<j) != 0) {
					sour = sour * S[j];
					bitter = bitter + B[j];
					// 재료를 하나만 선택해도 되므로 재료 선택할 때마다 조건을 걸어줘도 괜찮다.
					// 만일 그게 아니라면 따로 if문을 빼서 하도록!!
					if(Math.abs(sour-bitter) < dish) {
						dish = Math.abs(sour-bitter);
					}
				}
			}
		}
	}
}
