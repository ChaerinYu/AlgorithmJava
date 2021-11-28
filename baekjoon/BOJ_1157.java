package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2021.11.28
 * @author Chaerin Yu
 * 1157. 단어공부
 */
public class BOJ_1157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toLowerCase().toCharArray();
		
		int[] freq = new int[26];
		int maxCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i]-'a']++;
			// 가장 많이 사용된 알파벳 등장 횟수 저장
			if(freq[arr[i]-'a'] > maxCnt) {
				maxCnt = freq[arr[i]-'a'];
			}
		}
		
		char res = '?';
		int cnt = 0;
		for (int i = 0; i < freq.length; i++) {
			if(freq[i]==maxCnt) {
				// 여러 개 존재하는 경우
				if(cnt > 0) {
					res = '?';
					break;
				}
				res = (char) (i+'a'-32); // 대문자로 변환
				cnt++;
			}
		}

		System.out.println(res);
	}

}
