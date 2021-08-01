package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 11399. ATM
 * 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
 */
public class BJ_11399 {

	private static int waitSum = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine()); // 사람 수 
		int[] waitTime = new int[N]; // 돈 인출하는 데 걸리는 시간 
		
		String[] waitStr = reader.readLine().split(" ");
		for(int i=0; i<N; i++) {
			waitTime[i] = Integer.parseInt(waitStr[i]);
		}
		
		waitSum = 0;
		Arrays.sort(waitTime);
		
		for(int i=0; i<N; i++) {
			waitSum += waitTime[i];
			for(int j=0; j<i; j++) {
				waitSum += waitTime[j];
			}
		}
		
		System.out.println(waitSum);
	}

}
