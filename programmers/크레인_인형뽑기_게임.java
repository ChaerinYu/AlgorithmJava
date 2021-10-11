package programmers;

import java.util.Stack;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * 크레인 인형뽑기
 * @author ChaerinYu
 *
 */
public class 크레인_인형뽑기_게임 {

	public static void main(String[] args) {
		
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int n = solution(board, moves);
		System.out.println(n);
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<moves.length; i++) {
            int idx = moves[i]-1; // inde 0부터 시작하므로 -1해준다.
            
            int rIdx = 0;
            while(board[rIdx][idx] == 0) {
            	rIdx++;
                if(rIdx >= board.length-1) break;
            }
            
            if(board[rIdx][idx]==0) continue; // 범위 초과할 때까지 확인했는데 0인 경우, 인형 없는 경우
            
            // stack 빈 경우에는 인형 넣어준다.
            if(stack.size() == 0) {
            	stack.push(board[rIdx][idx]);
            } else {
            	// stack 비지 않은 경우
            	// 맨 꼭대기 인형 확인
                int top = stack.peek();
                
                // 같은 경우 인형 2개 사라짐
                if(top==board[rIdx][idx]) {
                	stack.pop();
                    answer += 2;
                } else {
                	// 아니면 그냥 넣기
                	stack.push(board[rIdx][idx]);
                }
            }
            // 뽑은 인형 자리 0으로 
            board[rIdx][idx] = 0;
            
        }
        
        return answer;
    }
}
