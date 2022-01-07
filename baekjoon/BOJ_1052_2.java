package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1052. 물병
 * @author Chaerin Yu
 * 2022.01.07
 * 얘는 범위때문에 안됨 ㅠ
 */
public class BOJ_1052_2 {

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
		
		int res = 0;
		int cnt = 0;
		while(true) {
			cnt = 0;
			String binaryStr = Integer.toBinaryString(n);
			int binaryNum = Integer.parseInt(binaryStr);
//			System.out.println(binaryStr+", "+binaryStr.length());
//			System.out.println(1 << binaryStr.length());
			for (int i = binaryStr.length(); i >= 0; i--) {
				if((binaryNum & (1 << i)) != 0) cnt++;
				System.out.println((binaryNum & (1 << i)));
			}
			System.out.println("aa");
			if(cnt <= k) break;
			n++;
			res++;
		}
		
		System.out.println(res);
	}

}
