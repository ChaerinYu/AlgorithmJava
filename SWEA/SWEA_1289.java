package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * [D3] 1289. 원재의 메모리 복구하기
 */
public class SWEA_1289 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc <= T; tc++) {
			String input = br.readLine();
			char[] byteInput = input.toCharArray();
			
			char temp = '0';
			int answer = 0;
			for(int i=0; i<byteInput.length; i++) {
				if(byteInput[i] == temp) {
					continue;
				} else {
					temp = byteInput[i];
					answer++;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}
}
