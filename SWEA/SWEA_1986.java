package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D2] 1986. 지그재그 숫자
 */
public class SWEA_1986 {

	private static int sum = 0;
	
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			int num = Integer.parseInt(reader.readLine());
			
			sum = 0;
			for(int i=1; i<=num; i++) {
				if(i%2 == 0) {
					sum -= i;
				} else {
					sum += i;
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
