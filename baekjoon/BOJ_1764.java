package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 2021.11.06
 * 1764. 듣보잡 
 * @author Chaerin Yu
 */
public class BOJ_1764 {

	static int N, M; // 듣도 보도 못한 사람
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
		M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N+M; i++) {
			String key = br.readLine();
			if(map.containsKey(key)) {
				// 기존에 있던 데이터인 경우
				map.put(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for (String key : map.keySet()) {
			if(map.get(key) > 1) {
				list.add(key);
			}
		}
		
		// 정렬
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (String string : list) {
			sb.append(string).append("\n");
		}
		System.out.print(sb.toString());
	}
}
