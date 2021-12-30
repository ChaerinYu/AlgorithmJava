package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1072. 게임
 * 2021.12.30
 * @author Chaerin Yu
 * 이분 탐색
 */
public class BOJ_1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		long x = Long.parseLong(st.nextToken()); 
//		long y = Long.parseLong(st.nextToken());
		int x = Integer.parseInt(st.nextToken()); 
		int y = Integer.parseInt(st.nextToken());
		
		int z = (int) ((long) y*100/x);
//		if(z >= 99) {
//			System.out.println(-1);
//			System.exit(0);
//		}
		int res = -1;
		int left = 0, right = 1_000_000_000;
		int mid = (left+right)/2;
		while(left <= right) {
			mid = (left+right)/2;
			
			if((int) ((long)(y+mid)*100/(x+mid)) != z) {
				res = mid;
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		System.out.println(res);
	}

}
