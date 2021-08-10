package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2605. 줄 세우기
 */
public class BOJ_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 학생 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LinkedList<Integer> students = new LinkedList<Integer>();
		
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(st.nextToken()); // 뽑은 번호
			students.add(cmd, i);
		}
		
		for(int i=N-1; i>=0; i--) {
			System.out.print(students.get(i)+1+ " ");
		}
		
	}

}
