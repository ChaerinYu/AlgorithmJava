package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * [D3] 1225. 암호생성기
 * 다음 주어진 조건에 따라 n개의 수를 처리하면 8자리의 암호를 생성할 수 있다.
	- 8개의 숫자를 입력 받는다.
	- 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 
	다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.
	이와 같은 작업을 한 사이클이라 한다.
	- 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.
 */
public class SWEA_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testN = 0;
		LinkedList<Integer> list = null;
		String input = null;
		StringTokenizer st = null;
		
		for(int tc=1; tc<=10; tc++) {
			testN = Integer.parseInt(br.readLine());
			list = new LinkedList<Integer>();

			input = br.readLine();
			st = new StringTokenizer(input, " ");
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			while(list.peekLast() != 0) {
				int firstN = list.peekFirst();
				firstN = firstN - cnt;
				if(firstN <= 0) firstN = 0;
				list.poll();
				list.offer(firstN);
				cnt = cnt%5+1;
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();
		}
	}

}
