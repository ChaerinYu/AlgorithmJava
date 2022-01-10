package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2022.01.10
 * Study 17week
 * @author Chaerin Yu
 * 16953. A → B
 */
public class BOJ_16953_3 {
	
	static int A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		// B를 A로 만들어보기
		while(true) {
			// A == B 일 때 멈추기
			if(A == B) {
				break;
			}
			// A가 더 큰 경우 B로 만들 수 없음
			else if(B < A) {
				cnt = -1;
				break;
			} else {
				// 끝자리 1인 경우
				if(B % 10 == 1) {
					B /= 10;
				}
				// 2로 나눠지는 경우
				else if(B % 2 == 0) {
					B /= 2;
				}
				// 아무것도 아닌 경우 -> 만들 수 없는 경우
				else {
					cnt = -1;
					break;
				}
			}
			
			cnt++;
		}
		System.out.println(cnt);
	}
	
}
