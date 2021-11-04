package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1389. 케빈 베이컨의 6단계 법칙
 * @author Chaerin Yu
 * floyd-warshall 플로이드와샬
 */
public class BOJ_1389 {

	static int N, M; // 유저 수, 친구관계 수
	static int[][] friends;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 유저 수
		M = Integer.parseInt(st.nextToken()); // 친구관계 수
		
		friends = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(friends[i], N*N);
			friends[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			friends[from][to] = 1;
			friends[to][from] = 1;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					if(i==k || j==k) continue;
					if(friends[i][k] == 0 || friends[k][j] == 0) continue;
					if(friends[i][j] > friends[i][k] + friends[k][j]) {
						friends[i][j] = friends[i][k] + friends[k][j];
					}
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int person = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				temp += friends[i][j];
			}
			if(answer > temp) {
				answer = temp;
				person = i+1;
			}
		}
		
		System.out.println(person);
	}
	
}
