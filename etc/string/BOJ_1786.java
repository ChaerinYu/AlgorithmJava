package etc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1786. 찾기
 * @author ChaerinYu
 * KMP Algorithm (Knuth–Morris–Pratt Algorithm) O(N+M)
 */
public class BOJ_1786 {

	static char[] T, P; // 원본, 패턴 문자열
	static int[] pi; // 부분일치 테이블 index: i위치 까지, value: i위치까지의 접미사(또는 접두사) 길이
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		T = br.readLine().toCharArray(); // 원본 문자열
		P = br.readLine().toCharArray(); // 패턴 문자열
		
		// 부분일치 테이블 생성하기 - 패턴 문자열끼리 비교해서 생성한다.
		pi = new int[P.length];
		// 접미사(i) 시작은 (첫 글자 틀리면 0부터 시작해야 하니까) 1부터 해야 한다. (접두사 j는 0부터 시작) 
		// 만약 동일하게 0부터 시작하게 되면 결국 같은 문자열을 돌면서 
		// 인덱싱 위치를 비교하기 때문에 전체가 같은 문자열로 취급된다.
		for (int i = 1, j = 0; i < P.length; i++) {
			// index 문자열 다른 경우, 이전 index 확인
			while (j > 0 && P[i] != P[j]) {
				j = pi[j-1];
			}
			// 문자열이 같은 경우, 길이 +1
			if(P[i] == P[j]) pi[i] = ++j;
		}
//		System.out.println(Arrays.toString(pi));
		
		int cnt = 0; // 원본 문자열에서 발견되는 패턴 문자열 개수
		ArrayList<Integer> list = new ArrayList<Integer>(); // 원본에서 패턴 문자열 위치 저장 list
		// i: 원본 문자열 포인터, j: 패턴 문자열 포인터
		for (int i = 0, j = 0; i < T.length; i++) {
			// 문자 다른 경우, 이전 인덱스 참고
			while (j > 0 && T[i] != P[j]) {
				j = pi[j-1];
			}
			// 같은 문자인 경우
			if(T[i] == P[j]) {
				// 패턴 문자열의 마지막 문자인 경우
				if(j==P.length-1) {
					cnt++;
					list.add(i+1-P.length);
					j = pi[j]; // 패턴이 j까지 모두 일치했으므로 이동할 위치인덱스를 부분일치테이블 값으로 설정한다.
				} else {
					// 마지막 문자가 아닌 경우, 나머지 뒷 문자들도 확인 필요.
					j++;
				}
			}
		}
		sb.append(cnt).append("\n");
		for (Integer integer : list) {
			sb.append(integer+1).append("\n");
		}
		System.out.println(sb);
	}
	
	private static String src = "ab  ab\r\n" + 
			"  ab";
}
