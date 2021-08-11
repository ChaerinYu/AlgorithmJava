package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * [D4] 1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
	사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이 식의 유효성을 검사하는 프로그램을 작성하여라.
	여기서 말하는 유효성이란, 사칙연산 “+, -, *, /”와 양의 정수로 구성된 임의의 식이 적절한 식인지를 확인하는 것으로, 
	계산이 가능하다면 “1”, 계산이 불가능할 경우 “0”을 출력한다.
	(단, 계산이 가능한지가 아닌 유효성을 검사하는 문제이므로 0으로 나누는 경우는 고려하지 않는다. )
 */
public class SWEA_1233_2 {

	private static int N; // 노드 수
	private static Stack<String> stack; // 스택 
	
	private static String[] node; // node
	private static String[][] children; // node의 child node
	
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine()); // 노드 수
			
			stack = new Stack<String>();
			node = new String[N+1];
			children = new String[N+1][2];
			
			StringTokenizer st = null;
			
			// node와 각 node의 children node 데이터 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int nodeIdx = Integer.parseInt(st.nextToken());
				node[nodeIdx] = st.nextToken();
				children[i+1][0] = "a"; children[i+1][1] = "a";
				int childN = 0;
				while(st.hasMoreTokens()) {
					children[i+1][childN++] = st.nextToken();
				}
			}
			
			answer = 1;
			for (int i = 0; i < N; i++) {
				String nodeData = node[i+1];
				
				// 사칙연산있는 경우
				if(nodeData.equals("+") || nodeData.equals("-") || nodeData.equals("*") || nodeData.equals("-")) {
					dfs(1);
				}
			}
			System.out.println("#"+tc+" "+answer);
			
		}
	}
	
	private static void dfs(int index) {
		if(index*2 <= N) dfs(index*2);
		
		if(!children[index][0].equals("a") && !children[index][1].equals("a")) {
			for (int i = 0; i < node[index].length(); i++) {
	            if (Character.isDigit(node[index].charAt(i))) {
	                answer = 0;
	                return;
	            }
	        }
			stack.push(node[index]);
		}
		if(index*2+1 <= N) dfs(index*2+1);
		
	}
}
