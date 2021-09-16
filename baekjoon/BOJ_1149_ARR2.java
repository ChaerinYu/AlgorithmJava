package baekjoon;

import java.util.Scanner;

/**
 * 1149. RGB 거리
 * @author ChaerinYu
 */
public class BOJ_1149_ARR2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 몇개 집인지 n
        int[][] a = new int[n+1][3]; // 집을 칠하는 비용 정보 받을 배열
        int[][] d = new int[n+1][3]; // 메모제이션
        for (int i=1; i<=n; i++) {
            for (int j=0; j<3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=1; i<=n; i++) { // R,G,B 색 칠했을 때 최소 비용을 구해줌.
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + a[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + a[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + a[i][2];
        }
        System.out.println(Math.min(Math.min(d[n][0], d[n][1]),d[n][2])); //N개의 집을 칠할 때 최소 비용 
    }
}
