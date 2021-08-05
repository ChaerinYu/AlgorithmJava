package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 15649. N과 M (1)
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */
public class BOJ_15649 {

	private static int N, M;
	private static boolean[] isSelected;
	private static int[] numbers;
	
	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(numbers[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isSelected[i]) continue;

			isSelected[i] = true;
			numbers[cnt] = i;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer tk = new StringTokenizer(input, " ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		
		isSelected = new boolean[N+1];
		numbers = new int[M];
		
		permutation(0);
	}

}
