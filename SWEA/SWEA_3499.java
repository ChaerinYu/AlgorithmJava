package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D3] 3499. 퍼펙트 셔플
 */
public class SWEA_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case 수
		
		int N = 0; // 카드 수 
		String[] cards = null; // 카드 
		int firstLast = 0; // 첫 번째 카드 그룹 마지막장
		String[] shuffle = null; // 섞은 후 카드
		
		for(int tc=1; tc<=T; tc++) {

			N = Integer.parseInt(br.readLine()); // 카드 수 
			
			cards = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int cnt = 0;
			while(st.hasMoreTokens()) {
				cards[cnt++] = st.nextToken();
			}
			
			firstLast = N/2; // 첫 번째 카드 뭉치의 마지막 카드
			shuffle = new String[N];
			
			cnt = 0;
			for(int i=0; i<N; i+=2) {
				
				shuffle[i] = cards[cnt];
				// 홀수일 때
				if(N%2 == 1) {
					if(i+1>=N) break; // 마지막은 카드가 없으므로 안해도 된다.
					cnt++;
					shuffle[i+1] = cards[firstLast+cnt];
				}
				// 짝수일 때 
				else {
					shuffle[i+1] = cards[firstLast+cnt];
					cnt++;
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(shuffle[i]+" ");
			}
			System.out.println();
		}
	}

}
