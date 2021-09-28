package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * [D4] 6026. 성수의 비밀번호 공격
 * @author ChaerinYu
 * CT Computer Thinking 컴퓨터띵킹 전사함수
 */
public class SWEA_6026 {

	static final int MOD = 1_000_000_007;
	
	static int T, M, N; // 테스트 케이스 수, M개의 키보드, 비밀번호 자리 수 M, N( 1 ≤ M ≤ N ≤ 100)
	static long[] fac; // 팩토리얼
	static long res;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		factorial();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			long l1, l2, l3;
			long total = 0;
			for (int i = 0; i <= M; i++) {
				l1 = i%2 == 0?1:-1;
				l2 = nCr(i);
				l3 = pow(M-i, N);
//				res += l1*l2*l3;
				res = ((l1*l2)%MOD*(l3)%MOD)%MOD;
				// MOD를 한번 더 해주면 절대 음수가 나오지 못함
				total = (total+res+MOD)%MOD;
			}
			
//			res = res % MOD;
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.print(sb);
		
		
	}
	
	/**
	 * l2, l3 페르마의 소정리
	 * @param r
	 * @return
	 */
	private static long nCr(int r) {
		if(r==0) {
			return 1;
		}
		long l1 = fac[M];
		long l2 = pow(fac[M-r], MOD-2);
		long l3 = pow(fac[r], MOD-2);
		
		return ((l1*l2)%MOD*(l3)%MOD)%MOD;
	}
	
	/**
	 * 팩토리얼 전처리로 미리 구하기
	 */
	private static void factorial() {
		fac = new long[101];
		fac[0] = fac[1] = 1;
		for (int i = 2; i <= 100; i++) {
			fac[i] = (fac[i-1]*i)%MOD;
		}
	}
	
	// 분할정복의 형태로 거듭제곱 구하기
	private static long pow(long a, int b) {
		if(b==1) {
			return a;
		}
		long half = pow(a, b/2);
		if(b%2 == 0) return (half*half)%MOD;
		// 나머지 연산의 분배 법칙
		return ((half*half)%MOD*(a)%MOD)%MOD;
	}
	
	private static String src = "3\r\n" + 
			"1 1\r\n" + 
			"2 5\r\n" + 
			"7 11";
}
