package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [D3] 1493. 수의 새로운 연산
 * 2차원 평면 제 1사분면 위의 격자점 (x,y)에 위 그림과 같이 대각선 순서로 점에 수를 붙인다.
 * #(1,1) = 1, #(2,1)=3, #(2,2) = 5, #(4,4) = 25이다.
 * &(1) = (1,1), &(3) = (2,1), &(5) = (2,2), &(25) = (4,4)이다.
 * (x,y) + (z,w) = (x+z, y+w)로 정의한다.
 * p★q는 #(&(p)+&(q))
 * &(1)=(1,1), &(5) = (2,2)이므로, 1★5 = #(&(1)+&(5)) = #((1,1)+(2,2)) = #(3,3) = 13이 된다.
 */
public class SWEA_1493 {

	private static final int SIZE = 10000;
	private static int T; // test case 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			int p = Integer.parseInt(input[0]);
			int q = Integer.parseInt(input[1]);
			
			int[] pCoord = getCoordinate(p);
			int[] qCoord = getCoordinate(q);
			
//			System.out.printf("%d %d %n", pCoord[0]+qCoord[0], pCoord[1]+qCoord[1]);
			System.out.println("#"+tc+" "+getDiagonalValue(pCoord[0]+qCoord[0], pCoord[1]+qCoord[1]));
		}
	}
	
	// 좌표 갖고 오기
	private static int[] getCoordinate(int value) {
		int tempValue = 1;
		int tempCoord = 1;
		while(tempCoord>0) {
			for (int r = 1, c = tempCoord; r <= tempCoord; r++, c--) {
//			for (int r = 1; r <= tempCoord; r++) {
//				for (int c = tempCoord; c >= 1; c--) {
					if(tempValue == value) {
						return new int[] {r, c};
					}
					tempValue++;
//				}
			}
			tempCoord++;
		}
		return null;
	}

	// 대각선 값 갖고 오기
	private static int getDiagonalValue(int coordR, int coordC) {
		int tempValue = 1;
		int tempCoord = 1;
		while(tempCoord>0) {
			for (int r = 1, c=tempCoord; r <= tempCoord; r++, c--) {
//			for (int r = 1; r <= tempCoord; r++) {
//				for (int c = tempCoord; c >= 1; c--) {
					if(coordR == r && coordC == c) {
						return tempValue;
					} else {
						tempValue++;
					}
//				}
			}
			tempCoord++;
		}
		return 0;
	}
}
