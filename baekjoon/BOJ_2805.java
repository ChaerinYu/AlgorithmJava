package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2021.11.21
 * @author Chaerin Yu
 * 나무 자르기
 * 이분탐색
 * ㅎㅎ long type을 잘 보자!
 */
public class BOJ_2805 {

	static int N; // 나무의 수 (1 ≤ N ≤ 1,000,000)
	static long M; // 나무의 길이 (1 ≤ M ≤ 2,000,000,000)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Long.parseLong(st.nextToken()); // 나무의 길이
		
		long[] tree = new long[N];
		long high = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
			if(high < tree[i]) high = tree[i];
		}
		
		long low = 0;
		long answer = 0;
		while(low <= high) {
			long mid = (low+high)/2;
			long sum = 0;
			for (int j = 0; j < N; j++) {
				long temp = tree[j]-mid;
				if(temp>=0) sum+=temp;
			}
			// 자른 나무의 총합이 m미터 이상이면 된다
			if(sum>=M) {
				low = mid+1;
				if(answer < mid) answer = mid;
//				answer = mid;
//				break;
			}
			else {
				high = mid-1;
			}
		}
		
		System.out.println(answer);
	}

}
