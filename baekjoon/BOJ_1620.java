package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 2021.11.06
 * @author Chaerin Yu
 * 1620. 나는야 포켓몬 마스터 이다솜
 */
public class BOJ_1620 {

	private static int N, M; // 포켓몬 수, 문제 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 포켓몬 수
		M = Integer.parseInt(st.nextToken()); // 문제 수
		
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		Map<Integer, String> numMap = new HashMap<Integer, String>();
		
		for (int i = 1; i <= N; i++) {
			String poketmon = br.readLine();
			nameMap.put(poketmon, i);
			numMap.put(i, poketmon);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			if(Character.isDigit(question.charAt(0))) {
				// 문제가 숫자일 때
				sb.append(numMap.get(Integer.parseInt(question)));
			} else {
				// 문제가 문자일 때
				sb.append(nameMap.get(question));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
