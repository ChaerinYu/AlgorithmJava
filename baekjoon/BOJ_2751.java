package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 2751. 수 정렬하기 2
 * @author Chaerin yu
 * 2021.11.19
 * 다른 방식들로 도전해봤지만 시간초과가 많이 난다. -_-
 */
public class BOJ_2751 {

	static final int RANGE = 1_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] freq = new int[2*RANGE+1];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(freq[num+RANGE] > 0) continue;
			freq[num+RANGE]++;
			list.add(num);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			sb.append(n).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}
