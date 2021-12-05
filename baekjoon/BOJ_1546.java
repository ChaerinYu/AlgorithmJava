package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1546. 평균
 * @author Chaerin Yu
 * 2021.12.05
 */
public class BOJ_1546 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 시험본 과목 수
		int[] points = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = 0; // 최고점
		// 점수 입력
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(st.nextToken());
			if(M<points[i]) M = points[i];
		}
		
		double[] newPoints = new double[N];
		double total = 0;
		for (int i = 0; i < N; i++) {
			newPoints[i] = (double) points[i]/M*100;
//			System.out.println(newPoints[i]);
			total += newPoints[i];
		}
		
		System.out.println(total/N);
		
	}

}
