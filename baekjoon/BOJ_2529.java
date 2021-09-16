package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
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
		br = new BufferedReader(new StringReader(src));
		
		k = Integer.parseInt(br.readLine());
		visited = new boolean[k+1];
		
		arr = br.readLine().split(" ");
		
		dfs(0, "");
		
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
		
		
	}
	
	static private String src = "2\r\n" + 
			"< >";
}
