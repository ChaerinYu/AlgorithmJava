package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D2] 1288. 새로운 불면증 치료법
 * 이전에 셌던 번호들의 각 자리수에서 0에서 9까지의 모든 숫자를 보는 것은 최소 몇 번 양을 센 시점일까?
 */
public class SWEA_1288 {
	
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("src/SWEA/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		
		for(int test_case=1; test_case<=tc; test_case++) {
			
//			int num = Integer.parseInt(reader.readLine());
//			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			int N = Integer.parseInt(reader.readLine()); // 시작 수 
			int[] numCheck = new int[10];

			int answer = 0, tempN = N;
			outer: while(true) {
				answer++;
				
				int numLen = Integer.toString(tempN).length(); // 몇 자리 수 인지 확인한다.
//				int tenIdx = (int) Math.pow(10, numLen-1);
				
				if(numLen == 1) {
					numCheck[tempN]++;
				} else {
					// N의 각 자리 수를 확인한다. 
					String tempStrN = String.valueOf(tempN);
					for(int i=0; i<numLen; i++) {
						int tempIdx = Integer.parseInt(tempStrN.substring(i, i+1));
						numCheck[tempIdx]++;
					}
				}
				
				for(int i=0; i<10; i++) {
					if(numCheck[i] == 0) {
						tempN += N;
						continue outer;
					}
				}
				
				break;
			}
			System.out.println("#"+test_case+" "+tempN);
		}
		
	}
}
