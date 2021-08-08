package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1406. 에디터 
 * 	L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
	D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
	B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
	삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
	P $	$라는 문자를 커서 왼쪽에 추가함
 */
public class BOJ_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); // 문자열 
		
		// 입력받은 문자열 문자 하나씩 stack에 넣는다.
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> tempStack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine()); // 명령어 개수 
		
		StringTokenizer st = null;
		char commend = ' ';
		char alpha = ' ';
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			commend = st.nextToken().charAt(0);
			
			switch(commend) {
				case 'L': // 커서 왼쪽 이동 시, tempStack에 stack peek 값을 넣는다.
					if(!stack.isEmpty())
						tempStack.push(stack.pop());
					break;
				case 'D': // 커서 오른쪽 이동 시, stack에 tempStack peek 값을 넣는다.
					if(!tempStack.isEmpty())
						stack.push(tempStack.pop());
					break;
				case 'B': // 지울 때에는 그냥 바로 제거한다.
					if(!stack.isEmpty())
						stack.pop();
					break;
				case 'P':
					alpha = st.nextToken().charAt(0);
					stack.push(alpha);
					break;
				default: 
					break;
			}
		}
		
		// System.out.print(); 사용하여 출력시 시간초과 발생함..
		StringBuilder sb = new StringBuilder();
		// stack에 있는 문자들을 tempStack으로 옮겨준다.
		while(stack.size() > 0) {
			tempStack.push(stack.pop());
		}
		// tempStack에 있던 값들은 pop하면서 출력한다.
		while(tempStack.size() > 0) {
			sb.append(tempStack.pop());
		}
		System.out.println(sb);
	}

}
