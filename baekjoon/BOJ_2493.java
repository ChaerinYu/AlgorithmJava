package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2493. 탑 
 * 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자.
 * 탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라. 
 */
public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 탑 수 
		
		// 탑 list
//		Stack<int[]> stack = new Stack<int[]>();
		// 건물 높이, 위치 둘 다 동시에 push, pop 해준다.
		Stack<Integer> stack = new Stack<Integer>(); // 건물 높이 저장 
		Stack<Integer> tempStack = new Stack<Integer>(); // 건물 높이 위치(index) 저장	
//		LinkedList<Integer> linked = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int item = 0;
		for(int i=1; i<=N; i++) {
			item = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) { // 시작시 stack 비어있는 경우
				sb.append(0);
				sb.append(" ");
				stack.push(item);
				tempStack.push(i);
			} else {
				// 비어있지 않는 경우
				while(true) {
					// pop 하다가 empty된 경우
					if(stack.isEmpty()) {
						sb.append(0);
						sb.append(" ");
						stack.push(item);
						tempStack.push(i);
						break;
					}
					// 앞 건물(이전 index 건물)이 높은 경우
					else if(stack.peek() > item) {
							sb.append(tempStack.peek());
							sb.append(" ");
							stack.push(item);
							tempStack.push(i);
							break;
					}
					// 앞 건물(이전 index 건물)들이 다 낮은 경우
					else {
						stack.pop();
						tempStack.pop();
					}
				}
			}
			
			/*
			item = Integer.parseInt(st.nextToken());
			linked.add(item);
			
			if(stack.isEmpty()) {
				stack.push(item);
				sb.append(linked.indexOf(stack.peek()));
				sb.append(" ");
			} else {
				while(!stack.isEmpty()) {
					if(stack.peek() > item) {
						sb.append(linked.indexOf(stack.peek()));
						stack.push(item);
						break;
					} else {
						sb.append(linked.indexOf(stack.peek()));
						sb.append(" ");
						stack.pop();
					}
				}
			}
			*/
			
			/*
			item = Integer.parseInt(st.nextToken());
			tempStack.push(item);
			
			if(stack.isEmpty()) {
				stack.push(item);
				sb.append(tempStack.indexOf(stack.peek()));
				sb.append(" ");
			} else {
				while(!stack.isEmpty()) {
					if(stack.peek() > item) {
						sb.append(tempStack.indexOf(stack.peek()));
						stack.push(item);
						break;
					} else {
						sb.append(tempStack.indexOf(stack.peek()));
						sb.append(" ");
						stack.pop();
					}
				}
			}
			*/
		}

		System.out.println(sb);
		br.close();
		
	}

}