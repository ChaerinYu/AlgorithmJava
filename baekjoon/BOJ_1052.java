package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1052. 물병
 * @author Chaerin Yu
 * 2022.01.07
 */
public class BOJ_1052 {

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
		
		// n이 2^m일 때마다 추가 없이 한 병 만들 수 있음
		int res = 0;
		int temp = n, cnt = 0;
		while(true) {
			cnt = 0; // 옮기는 물병 수
			temp = n; // 물병 수
			while(temp > 0) {
				// 합쳐지지 않는 물병 수
				if(temp % 2 == 1) cnt++;
				// 물병 합치기
				temp = temp/2;
			}
			if(cnt <= k) break;
			
			// 옮기는 물병 수가 k보다 큼 -> 상점에서 물병을 사야 함.
			n++; 
			res++; // 추가로 필요한 물병
		}
		
		System.out.println(res);
	}

}
