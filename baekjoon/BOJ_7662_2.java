package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 * 7662. 이중 우선순위 큐
 * @author Chaerin Yu
 * 2021.11.27
 * reeMap은 이진 트리를 기반으로 오름차순으로 정렬된 형태로 저장한다. 
 * 따라서 firstKey()와 lastKey()는 O(logN)
 */
public class BOJ_7662_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			
			int k = Integer.parseInt(br.readLine()); // 연산 개수
			
			TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String oper = st.nextToken(); // 연산 (D or I)
				int n = Integer.parseInt(st.nextToken()); // 정수
				
				// D 1: Q에서 최대값 삭제, D -1: 최소값 삭제
				if("D".equals(oper)) {
					if(!treemap.isEmpty()) {
						int deleteNum = 0;
						if(n==1) {
							deleteNum = treemap.lastKey();
						} else {
							deleteNum = treemap.firstKey();
						}
						if(treemap.getOrDefault(deleteNum, 1) < 2) {
							treemap.remove(deleteNum);
						} else {
							treemap.put(deleteNum, treemap.get(deleteNum)-1);
						}
					}
				} else if("I".equals(oper)) {
					treemap.put(n, treemap.getOrDefault(n, 0)+1);
				}
			}
			
			if(treemap.isEmpty()) {
				sb.append("EMPTY");
			} else {
				sb.append(treemap.lastKey()).append(" ").append(treemap.firstKey());
			}
			sb.append("\n");
			
		}
		System.out.print(sb.toString());
	}


}
