package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D2] 1989. 초심자의 회문 검사
 */
public class SWEA_1989 {

	private static int Answer = 0;
	
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			String str = reader.readLine();
			String backStr = "";
			
			for(int i=str.length()-1; i>=0; i--) {
				backStr += str.charAt(i);
			}
			
			if(str.equals(backStr)) {
				Answer = 1;
			} else {
				Answer = 0;
			}
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
