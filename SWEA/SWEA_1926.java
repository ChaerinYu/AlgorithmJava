package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D2] 1926. 간단한 369게임
 */
public class SWEA_1926 {

	public static void main(String args[]) throws Exception
	{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		String[] arr = new String[N];
		for(int i=1; i<=N; i++) {
			String strNum = String.valueOf(i);
			if(strNum.contains("3") || strNum.contains("6") || strNum.contains("9")) {
				int numLength = strNum.length();
				String temp = "";
				for(int j=0; j<numLength; j++) {
					char tempNum = strNum.charAt(j);
					if(tempNum=='3' || tempNum=='6' || tempNum=='9') {
						temp += "-";
					}
				}
				arr[i-1] = temp;
			} else {
				arr[i-1] = String.valueOf(i);
			}
			
			System.out.print(arr[i-1]+" ");
		}
	}
}
