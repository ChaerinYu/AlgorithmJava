package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D2] 1970. 쉬운 거스름돈
 */
public class SWEA_1970 {
	
	private static final int[] changes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("src/SWEA/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
//			int num = Integer.parseInt(reader.readLine());
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			int money = Integer.parseInt(st.nextToken());
			int[] changeNum = new int[changes.length];
			
			for(int i=0; i<changes.length; i++) {
				int change = changes[i];
				changeNum[i] = money / change;
				money = money%change;
			}
			
			System.out.println("#"+test_case);
			for(int i=0; i<changes.length; i++) {
				System.out.print(changeNum[i]+ " ");
			}
			System.out.println();
		}
		
	}
}
