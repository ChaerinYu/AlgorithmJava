package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1158. 요세푸스 문제
 * 
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
 * 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 */
public class BOJ_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int K = Integer.parseInt(st.nextToken()); // k번째 제거
		
		Queue<Integer> numbers = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			numbers.add(i);
		}
		
		int i=1;
		int num = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!numbers.isEmpty()) {
			if(i%K != 0) {
				i = i%K; // k번째 아닌 경우 다시 입력한다.
				num = numbers.poll();
				numbers.offer(num);
			} else {
				sb.append(numbers.poll()).append(", ");
			}
			i++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
