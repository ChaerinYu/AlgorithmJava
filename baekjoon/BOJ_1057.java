package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 프로그래머스 `예상 대진표` 문제 와 유사
 * @author Chaerin Yu
 * 1057. 토너먼트
 * 2021.12.29
 */
public class BOJ_1057 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer.parseInt(st.nextToken()); // 참가자 수
		int Kim = Integer.parseInt(st.nextToken()); // 김지민
		int Yim = Integer.parseInt(st.nextToken()); // 임한수
		
		int res = 0;
		while(Kim != Yim) {
			Kim = (Kim+1)/2;
			Yim = (Yim+1)/2;
			res++;
		}
		System.out.println(res);
	}
}
