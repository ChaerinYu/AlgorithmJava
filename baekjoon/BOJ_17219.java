package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 17219. 비밀번호 찾기
 * @author Chaerin Yu
 * 2021.11.11
 */
public class BOJ_17219 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소 수
		int M = Integer.parseInt(st.nextToken()); // 비밀번호 찾으려는 사이트 수
		
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pwd = st.nextToken();
			
			map.put(site, pwd);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		System.out.print(sb.toString());
	}

}
