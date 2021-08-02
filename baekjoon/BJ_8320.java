package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 8320. 직사각형을 만드는 방법
 * 변의 길이가 1인 정사각형 n개를 가지고 있다. 
 * 이 정사각형을 이용해서 만들 수 있는 직사각형의 개수는 총 몇 개일까?
 */
public class BJ_8320 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine()); // 정사각형 개수 

		int answer = N;
		for(int i=2; i<=N/2; i++) {
			for(int j=i; j<=N; j++) {
				if(i*j<= N) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
