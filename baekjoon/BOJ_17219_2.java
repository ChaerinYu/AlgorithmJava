package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Study 13week
 * 2021.12.03
 * 17219. 비밀번호 찾기
 * @author Chaerin Yu
 */
public class BOJ_17219_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사이트 주소 수
		int M = Integer.parseInt(st.nextToken()); // 비밀번호 찾으려는 사이트 수
		
		Map<String, String> map = new HashMap<String, String>(); // map 사용
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken()); // site, password 입력
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
