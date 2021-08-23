package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 1759. 암호 만들기
 * @author user
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 
 * 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 
 * 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
 * 새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 
 * C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 
 * 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
 */
public class BOJ_1759 {
	
	static int L, C; // 암호 길이, 알파벳
	static char[] alpha; // 암호에 쓰인 알파벳 array
	
	static char[] password;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		alpha = new char[C];
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);

		password = new char[L];
		getPassword(0, 0);
	}

	static void getPassword(int cnt, int start) { 
		
		if(cnt == L) {
			int tempM = 0, tempJ = 0;
			for (int i = 0; i < password.length; i++) {
				if("aeiou".contains(String.valueOf(password[i]))) {
					tempM++; // 모음
				} else {
					tempJ++;
				}
			}
			// 최소 모음 1개  최소 자음 2개
			if(tempM >= 1 && tempJ >= 2) {
				for (int i = 0; i < password.length; i++) {
					System.out.print(password[i]);
				}
				System.out.println();
			}
			
			
			return;
		}
		
		// 조합
		for (int i = start; i < alpha.length; i++) {
			password[cnt] = alpha[i];
			
			getPassword(cnt+1, i+1);
		}
	}
	
}
