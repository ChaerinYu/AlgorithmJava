package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1052. 물병
 * @author Chaerin Yu
 * 2022.01.07
 */
public class BOJ_1052_1 {

	static int n, k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 물병 수
		k = Integer.parseInt(st.nextToken()); // 최종 물병 수
		
		if(n < k) {
			System.out.println(0);
			System.exit(0);
		}
		
		// 1 개수 세기
		int res = 0;
		int cnt = 0;
		while(true) {
			cnt= 0;
			char[] arr = Integer.toBinaryString(n).toCharArray();
			for (char c : arr) {
				if(c=='1') cnt++;
			}
			if(cnt <= k) break;
			n++;
			res++;
		}
		
		System.out.println(res);
	}

}
