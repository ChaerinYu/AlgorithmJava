package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D3] 9229. 한빈이와 Spot Mart
 * 
	스팟마트에는 N개의 과자 봉지가 있으며, 각 과자 봉지는 ai그램의 무게를 가진다.
	배가 많이 고픈 한빈이는 최대한 양이 많은 (무게가 많이 나가는) 과자 봉지를 고르고 싶으나,
	과자 두 봉지의 무게가 M 그램을 초과하면 무거워서 과자를 들고 다닐 수 없다.
	한빈이가 들고 다닐수 있는 과자들의 최대 무게 합을 출력하라. 한빈이는 과자를 “정확히” 두 봉지 사야 함에 유의하라.
	
	과자 봉지의 개수와 무게 합 제한을 나타내는 자연수 N, M이 주어진다.
	(2 ≤ N ≤ 1000 , 2 ≤ M ≤ 2000000)
	이후 N개의 줄에 각 과자봉지의 무게 가 주어진다. (1 ≤ ai ≤ 1000000)
 */
public class SWEA_9229 {

	private static int weight = 0;
	private static int N; // 과자 봉지 개수
	private static int M; // 과자 무게 제한
	private static int[] ai; // 과자 무게
	private static int[] isSelected;
	
	private static void pick(int index, int cnt) {
		if(cnt == 2) {
			int s = isSelected[0]+isSelected[1];
			if(s > M) return;
			if(weight < s) weight = s;
			return;
		}
		
		for (int i = index; i < N; i++) {
			isSelected[cnt] = ai[i];
			
			pick(i+1, cnt+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/input_9229.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			ai = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				ai[i] = Integer.parseInt(st.nextToken());
			}
			weight = -1;
			isSelected = new int [2];
			pick(0, 0);
			
			System.out.println("#"+tc+" "+weight);
		}
	}

}
