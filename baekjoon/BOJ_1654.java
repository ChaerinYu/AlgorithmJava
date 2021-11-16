package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1654. 랜선 자르기
 * @author Chaerin Yu
 * 2021.11.16
 * N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
 * 이분 탐색
 */
public class BOJ_1654 {

	static int K, N;
	static int[] line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); // 랜선 개수
		N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
		
		line = new int[K]; // 갖고 있는 랜선 수
		long high = 0;
		for (int i = 0; i < line.length; i++) {
			line[i] = Integer.parseInt(br.readLine());
			if(line[i]>high) high = line[i];
		}
		
		long low = 1;
		long res = 0;
		while(low <= high) {
			long mid = (low+high)/2;
			
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += line[i]/mid;
			}
			
			if(cnt>=N) {
				if(res < mid) res = mid;
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		
		System.out.println(res);
	}

}
