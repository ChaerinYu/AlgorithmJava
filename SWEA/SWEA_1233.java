package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D4] 1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
	사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이 식의 유효성을 검사하는 프로그램을 작성하여라.
	여기서 말하는 유효성이란, 사칙연산 “+, -, *, /”와 양의 정수로 구성된 임의의 식이 적절한 식인지를 확인하는 것으로, 
	계산이 가능하다면 “1”, 계산이 불가능할 경우 “0”을 출력한다.
	(단, 계산이 가능한지가 아닌 유효성을 검사하는 문제이므로 0으로 나누는 경우는 고려하지 않는다. )
 */
public class SWEA_1233 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 노드 수
			
			StringTokenizer st = null;
			int answer = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				char temp = st.nextToken().charAt(0);
				while(st.hasMoreTokens()) {
					// 뒤에 더 있는데(자식노드가 있는데) 숫자인 경우 answer = 0
					if(Character.isDigit(temp)) answer = 0;
					st.nextToken();
				}
			}
			System.out.println("#"+tc+" "+answer);
			
		}
	}
}
