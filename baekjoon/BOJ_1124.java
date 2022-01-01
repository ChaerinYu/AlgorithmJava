package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1124. 언더프라임
 * 소인수 분해 했을 때, 나오는 소수의 개수가 소수일 때
 * 2022.01.01
 * @author user
 *
 */
public class BOJ_1124 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] noPrimeArr = new boolean[B+1];
		int[] arr = new int[B+1];
		noPrimeArr[0] = noPrimeArr[1] = true; // 소수 아님
		
		// 에라토스테네스의 체
		for (int i = 2; i <= B; i++) {
			// 소수일 때
			if(!noPrimeArr[i]) {
				for (int j = i*2; j <= B; j+= i) {
					noPrimeArr[j] = true; // 소수 아님 체크
					// i 나누어지는 횟수만큼 +1
					// 특정 수가 소수임이 확인되면 그 수의 배수들을 
					// 소수가 아니라고 처리해주는 과정에서
					// 해당 소수로 몇 번 나누어지는지 확인
					int temp = j;
					while(temp % i == 0) {
						temp /= i;
						arr[j]++;
					}
				}
			}
		}
		
		int res = 0;
		for (int i = A; i <= B; i++) {
			if(!noPrimeArr[arr[i]]) res++;
		}
		System.out.println(res);
	}

}
