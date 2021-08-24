package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 13300. 방 배정
 * @author user
 * 한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때, 조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수를 구하는 프로그램을 작성하시오.
 * 첫 번째 줄에는 수학여행에 참가하는 학생 수를 나타내는 정수 N(1 ≤ N ≤ 1,000)과 
 * 한 방에 배정할 수 있는 최대 인원 수 K(1 < K ≤ 1,000)가 공백으로 분리되어 주어진다. 
 * 다음 N 개의 각 줄에는 학생의 성별 S와 학년 Y(1 ≤ Y ≤ 6)가 공백으로 분리되어 주어진다. 
 * 성별 S는 0, 1중 하나로서 여학생인 경우에 0, 남학생인 경우에 1로 나타낸다. 
 */
public class BOJ_13300 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 방 최대 인원 수
		
		int[][] students = new int[2][6+1]; // 1~6학년, 성별
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken()); // 성별
			int Y = Integer.parseInt(st.nextToken()); // 학년
			
			students[S][Y]++; // 각 성별/학년별 더하기
		}
		
		int res = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				int num = students[i][j];
				// 최대 인원 수 나눴을 때 떨어지는 경우
				if(num%K==0) {
					res += num/K;
				} else {
					res += num/K+1;
				}
			}
		}
		
		System.out.println(res);
	}
}
