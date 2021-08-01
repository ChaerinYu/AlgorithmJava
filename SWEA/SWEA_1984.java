package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * [D2] 1984. 중간 평균값 구하기
 */
public class SWEA_1984 {

	public static void main(String args[]) throws Exception
	{
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			String[] input = reader.readLine().split(" ");
			
            int[] inputNum = new int[10];
            for(int i=0; i<10; i++) {
                inputNum[i] = Integer.parseInt(input[i]);
            }
			Arrays.sort(inputNum);
			int sum = 0;
			for(int i=1; i<9; i++) {
				sum += inputNum[i];
                
			}
			int avg = (int) Math.round((double)sum/8);
			
			System.out.println("#"+test_case+" "+avg);
			
		}
		
	}
}
