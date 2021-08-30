package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 2164. 카드2
 * @author ChaerinYu
 * 첫째 줄에 남게 되는 카드의 번호를 출력한다.
 */
public class BOJ_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		int peek = 1; // 최소값인 N = 1일 때
		while(!queue.isEmpty()) {
			queue.poll();
			if(queue.isEmpty()) break;
			peek = queue.poll();
			queue.offer(peek);
		}
		System.out.println(peek);
	}

}
