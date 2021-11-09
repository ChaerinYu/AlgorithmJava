package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 9375. 패션왕 신해빈
 * @author Chaerin Yu
 * 2021.11.09
 */
public class BOJ_9375 {

	static int T; // 테스트 케이스 수
	static int N; // 의상 수 (최대 30)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 의상 수
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 버리는 값
				String kind = st.nextToken();
				
				map.put(kind, map.getOrDefault(kind, 0)+1);
			}
			int answer = 0;
			for (String key : map.keySet()) {
				int temp = map.get(key);
				answer += answer*temp + temp;
			}
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
/**
[입력]
2
3
hat headgear
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face

[출력]
5
3
**/