package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 2309. 일곱 난쟁이
 * 
 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 * 일곱 난쟁이의 키의 합이 100이 됨
 */
public class BOJ_2309 {

	private static int NUM = 9; // 난쟁이 수
	private static int[] shorts = new int[NUM];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int fakeSum = 0;
		// 난쟁이 키 입력 
		for(int n=0; n<9; n++) {
			shorts[n] = Integer.parseInt(br.readLine());
			fakeSum += shorts[n];
		}

		Arrays.sort(shorts);
		int out1=0, out2=0;
		for(int i=0; i<NUM; i++) {
			for(int j=i+1; j<NUM; j++) {
				if(fakeSum - shorts[i] - shorts[j] == 100) {
					out1 = i;
					out2 = j;
					break;
				}
			}
		}
		shorts[out1]=100;
		shorts[out2]=100;
		
		Arrays.sort(shorts);

		for(int i=0; i<NUM-2; i++) {
			System.out.println(shorts[i]);
		}
		
	}

}
