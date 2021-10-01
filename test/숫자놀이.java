package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 숫자놀이
 * @author 
 * boj_1755
 */
public class 숫자놀이 {
	
	static final String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	static int N, M; // 정수 1~99
	static ArrayList<Words> words;
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src)); // 제출 시 주석처리
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 숫자 from
		M = Integer.parseInt(st.nextToken()); // 숫자 to
		
		words = new ArrayList<Words>();
		inputWords();
		
		Collections.sort(words); // 정렬
		
		// 한 줄에 10개씩 출력한다.
		for (int i = 0; i < words.size(); i++) {
			if(i != 0 && i%10 == 0)sb.append("\n"); // 한 줄에 10개 씩 출력해야 함
			sb.append(words.get(i).num).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void inputWords() {
		for (int i = N; i <= M; i++) {
			char[] nums = Integer.toString(i).toCharArray();
			String temp = "";
			for (char c : nums) {
				temp += number[c-'0'];
			}
			words.add(new Words(i, temp));
		}
	}
	
	static class Words implements Comparable<Words> {
		int num; String word;

		public Words(int num, String word) {
			this.num = num;
			this.word = word;
		}

		@Override
		public int compareTo(Words o) {
			return this.word.compareTo(o.word);
		}
		
	}
	
	
	private static String src = "37 58";
}
