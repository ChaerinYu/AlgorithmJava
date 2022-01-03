package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 1141. 접두사
 * 2022.01.03
 * @author user
 *
 */
public class BOJ_1141 {

	static class Word implements Comparable<Word> {
		String s;
		int len;
		
		public Word(String s, int len) {
			this.s = s;
			this.len = len;
		}

		@Override
		public int compareTo(Word o) {
			return Integer.compare(this.len, o.len);
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 단어 수
		Word[] arr = new Word[n];
		String s = "";
		int len = 0;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			len = s.length();
			
			arr[i] = new Word(s, len);
		}
		
		// 길이 순서로 정렬
		Arrays.sort(arr);
		
		int res = 0;
		boolean prefix = false;
		for (int i = 0; i < n; i++) {
			prefix = false;
			for (int j = i+1; j < n; j++) {
				// 접두사 일치 -> arr[i].s는 접두사X 집합의 원소가 될 수 없음
				if(arr[j].s.substring(0, arr[i].len).equals(arr[i].s)) {
					prefix = true;
					break;
				}
			}
			if(prefix) res++;
		}
		// 접두사X 집합 원소가 될 수 없는 경우 빼주기
		System.out.println(n-res);
	}

}
