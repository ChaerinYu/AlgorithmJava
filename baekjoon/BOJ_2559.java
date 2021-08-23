package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2559. 수열 
 * @author user
 * 첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다. 
 * 첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다. N은 2 이상 100,000 이하이다. 
 * 두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다. K는 1과 N 사이의 정수이다. 
 * 둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -100 이상 100 이하이다. 
 * 
 */
public class BOJ_2559 {

	static int N, K; // 전체 날짜의 수, 연속적 날짜 수
	static int[] temperature, sumArr; 
	static int idx = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 날짜 수
		K = Integer.parseInt(st.nextToken()); // 연속 날짜 수
		
		temperature = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		
		sumArr = new int[N-K+1]; // 합 array
		System.out.println(go());
	}
	
	static int go() {
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < N-K+1; i++) {

			// index 0일때는 for문 전체 합 구하기
			if(i == 0) {
				for (int j = i; j < i+K; j++) {
					sum += temperature[j];
				}
			} else { // 아닐 때는 이전 합에서 이전 숫자 빼고 다음 숫자 더해주기
				sum = sum-temperature[i-1]+temperature[i+K-1];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
