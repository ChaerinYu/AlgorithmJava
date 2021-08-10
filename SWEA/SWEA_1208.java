package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
  [D3] 1208. [S/W 문제해결 기본] 1일차 - Flatten
 */
class SWEA_1208
{
	private static final int WIDTH = 100; // 가로길이 
	private static int dump; // 덤프 수 (덤프 횟수는 1이상 1000이하)
	private static int[] box; // 박스 (모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		for(int tc=1; tc<=10; tc++) {
			dump = Integer.parseInt(br.readLine());
			box = new int[WIDTH];
			st = new StringTokenizer(br.readLine(), " ");
			sb = new StringBuilder();
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			
			for(int i=0; i<WIDTH; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(box);
			while(true) {
				if(dump == 0) break;
				box[0]++;
				box[99]--;
				dump--;
				Arrays.sort(box);
				if(box[99]==box[0]) break;
			}
			
			sb.append(box[99]-box[0]);
			
			//System.out.println("#"+tc+" "+ans);
			System.out.println(sb);
		}
	}

}
