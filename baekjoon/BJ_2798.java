package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 2798. 블랙잭 
 * M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 */
public class BJ_2798 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]); // 카드 수 
		int M = Integer.parseInt(input[1]); // 딜러가 외친 수 
		
		String[] cardInput = reader.readLine().split(" ");
		int[] card = new int[N];
		
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(cardInput[i]);
		}
		
		int min = M;
		int temp = 0; // 초기화 
		for(int l=0; l<N-2; l++) {
			
			if(M < card[l]) continue; // M 넘었을 때 바로 continue;
			
			for(int m=l+1; m<N-1; m++) {
				
				if(M < card[l]+card[m]) continue; // M 넘었을 때 바로 continue;
				
				for(int n=m+1; n<N; n++) {
					
					int cardSum = card[l]+card[m]+card[n];
					
					if(M >= cardSum
							&& M-cardSum == Math.min(M-temp, M-cardSum)) {
						min = cardSum;
						temp = min;
					}
				}
			}
		}
		
		System.out.println(min);
	}

}
