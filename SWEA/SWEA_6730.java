package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/** IM TEST 준비
 * [D3] 6730. 장애물 경주 난이도
 * @author ChaerinYu
 * 
 */
public class SWEA_6730 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // test case 수
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // block 수
			int[] blocks = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				blocks[i] = Integer.parseInt(st.nextToken());
			}
			
			int upMax=0, downMax=0;
			for (int i = 1; i < N; i++) {
				if(i!=0) {
					// 올라가는 부분
					if(blocks[i-1]<blocks[i]) {
						int prev = Math.abs(blocks[i]-blocks[i-1]);
						if(prev > upMax) {
							upMax = prev;
						}
					}
					// 내려가는 부분
					if(blocks[i-1]>blocks[i]) {
						int next = Math.abs(blocks[i]-blocks[i-1]);
						if(next > downMax) {
							downMax = next;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+upMax+" "+downMax);
			
		}
		
	}

}
