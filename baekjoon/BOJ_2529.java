package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 2529. 부등호 
 * @author ChaerinYu
 * dfs
 */
public class BOJ_2529 {
	
	static int k;
	static String[] arr;
	static boolean[] visited;
	static ArrayList<String> res = new ArrayList<String>();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
//		br = new BufferedReader(new StringReader(src));
		
		k = Integer.parseInt(br.readLine());
		visited = new boolean[k+1];
		
		arr = br.readLine().split(" ");
//		System.out.println(Arrays.toString(arr));
		visited = new boolean[10];
		dfs(0, "");
		
		// 오름차순 정렬
		Collections.sort(res);
		System.out.println(res.get(res.size()-1));
		System.out.println(res.get(0));
	}
	
	/**
	 * 
	 * @param cnt 문자열 길이
	 * @param str 문자열
	 */
	static void dfs(int cnt, String str) {
		if(cnt==k+1) {
			res.add(str);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!visited[i]) {
				// 문자열 첫 시작 또는 이전값과 현재값 부등호 갖고 올바르게 값 들어왔는지 확인
				if(cnt == 0 || 
						(!visited[i] && compare(Integer.parseInt(str.substring(str.length()-1, str.length())), i, arr[str.length()-1]))) {
					visited[i] = true;
					dfs(cnt+1, str+String.valueOf(i));
					visited[i] = false;
				}
			}
			
		}
		
	}
	
	static boolean compare(int a, int b, String sign) {
		if(sign.equals("<")) {
			return (a == Integer.min(a, b));
		} else {
			return (b == Integer.min(a, b));
		}
	}
	
	static private String src = "2\r\n" + 
			"< >";
}
