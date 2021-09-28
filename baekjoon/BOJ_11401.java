package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
/**
 * 11401. 이항 계수 3
 * @author Chaerin Yu
 * Computer Thinking - 전사함수, 페르마 소정리
 * 자연수 (N)과 정수 (K)가 주어졌을 때 이항 계수 를 1,000,000,007로 나눈 나머지를 구하는 프로그램
 */
public class BOJ_11401 {

	static final int MOD = 1_000_000_007; // 소수
	static int N, K; //  (1 ≤ N ≤ 4,000,000, 0 ≤ K ≤ N)
	
	static long[] fac;
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		makeFactorial(); // 팩토리얼 미리 만들기
		
		long answer = nCr(N, K);
		sb.append(answer);
//		long nn = fac[N];
//		long kk = fac[K]*fac[N-K]%MOD;
//		sb.append(nn*pow(kk, MOD-2)%MOD);
//		long l1, l2, l3, temp;
//		long total = 0;
//		for (int i = 0; i <= K; i++) {
//			l1 = i%2==0?1:-1;
//			l2 = nCr(i);
//			l3 = pow(K-i, N);
//			
//			temp = ((l1*l2)%MOD*(l3)%MOD)%MOD;
//			total = (total+temp+MOD)%MOD;
//		}
//		total = fac[N];
//		sb.append(total).append("\n");
		System.out.println(sb);
	}
	
	/**
	 * 분할정복 형태로 거듭제곱 구하기
	 * @param a
	 * @param b
	 * @return
	 */
	private static long pow(long a, int b) {
		if(b==1) return a;
		long half = pow(a, b/2);
		if(b%2==0) return (half*half)%MOD;
		return ((half*half)%MOD*(a)%MOD)%MOD;
	}

	/**
	 * nCr 구하기
	 * @param r
	 * @return
	 */
	private static long nCr(int n, int k) {
		if(k==0) return 1;
		// n!, (n-r)!, r!
		long l1 = fac[n];
		long l2 = pow(fac[n-k], MOD-2);
		long l3 = pow(fac[k], MOD-2);
		return ((l1*l2)%MOD*(l3)%MOD)%MOD;
	}
	private static long nCr(int r) {
		if(r==0) return 1;
		// n!, (n-r)!, r!
		long l1 = fac[K];
		long l2 = pow(fac[K-r], MOD-2);
		long l3 = pow(fac[r], MOD-2);
		return ((l1*l2)%MOD*(l3)%MOD)%MOD;
	}



	/**
	 * 팩토리얼 만들기
	 */
	private static void makeFactorial() {
		fac = new long[N+1];
		fac[0]=fac[1]=1;
		for (int i = 2; i < fac.length; i++) {
			fac[i] = (fac[i-1]*i)%MOD;
		}
	}


	private static String src = "5 2";
}
