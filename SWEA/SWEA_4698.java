package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * [D3] 4698. 테네스의 특별한 소수
 * @author ChaerinYu
 * @date   21/08/30
 *
 */
public class SWEA_4698 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 소수 구하기
		// array값이 1일 경우, 소수가 아니다.
		int[] primeNum = new int[1000001];
		primeNum[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			for (int j = 2; j <= 1000000; j++) {
				// int 범위 벗어남
				if(i*j > 1000000) {
					break;
				}
				primeNum[i*j]=1; // array 0 아니면 소수 아님
			}
		}
		
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken()); // 특별한 소수 기준
			int a = Integer.parseInt(st.nextToken()); // from
			int b = Integer.parseInt(st.nextToken()); // to
			
			int res = 0;
			// 1은 소수가 아니다.
			if(a==1) a = 2;
			
			for (int i = a; i <= b; i++) {
				if(primeNum[i] == 0) {
					char[] arrI = String.valueOf(i).toCharArray();
					for (int j = 0; j < arrI.length; j++) {
						if(arrI[j]-'0' == d) {
							res++;
							break;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}

}
