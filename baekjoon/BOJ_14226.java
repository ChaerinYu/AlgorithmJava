package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * study week 3
 * 14226. 이모티콘
 * @author Chaerin Yu
 * 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 
 * 숨바꼭질 문제처럼 하려다가 실패 -> queue에 화면 스마일 수, 클립보드 스마일 수, 연산 수 저장
 */
public class BOJ_14226 {

	static int S; // 스마일 이모티콘 개수
	static int res;
	
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new StringReader(src));
		
		S = Integer.parseInt(br.readLine()); // 스마일 수
		
		res = Integer.MAX_VALUE;
		bfs(1, 0, 0);
		
		sb.append(res).append("\n");
		System.out.println(sb);
	}
	
	/**
	 * 
	 * @param start 처음 스마일 개수
	 * @param clipboard 클립보드에 저장된 스마일 개수
	 * @param cnt 연산 회수
	 */
	static void bfs(int start, int clipboard, int cnt) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[1001][1001]; // visited[화면에 출력된 개수][클립보드에 복사된 개수]
		
		queue.offer(new int[] {start, clipboard, cnt});
		visited[start][clipboard] = true;
		
//		int cnt = 1;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			int contentNum, clipboardNum, cntNum;
			
			while(queueSize-->0) {
				int[] current = queue.poll();
				contentNum = current[0]; // 화면 스마일 수
				clipboardNum = current[1]; // 클립보드 스마일 수
				cntNum = current[2]; // 연산 회수
				
				// 화면의 스마일 개수가 S가 같다면 멈춘다.
				if(contentNum==S) {
					res = cntNum;
					return;
				}
				
				// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
				// 복사하려면 화면에 최소 1개의 스마일 필요
				if(contentNum-1>=0 && contentNum*2<=1000 && !visited[contentNum][contentNum]) {
					queue.offer(new int[] {contentNum, contentNum, cntNum+1});
					visited[contentNum][contentNum] = true;
				}
				// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
				// 클립보드에 복사된 내용이 있어야 붙여넣기 가능함
				if(clipboardNum>0 && contentNum+clipboardNum<=1000 && !visited[contentNum+clipboardNum][clipboardNum]) {
					queue.offer(new int[] {contentNum+clipboardNum, clipboardNum, cntNum+1});
					visited[contentNum+clipboardNum][clipboardNum] = true;
				}
				// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
				if(contentNum-1 > 1 && !visited[contentNum-1][clipboardNum]) {
					queue.offer(new int[] {contentNum-1, clipboardNum, cntNum+1});
					visited[contentNum-1][clipboardNum] = true;
				}
				
			} // queueSize end
//			cnt++;
		} // queue empty end
	}
	
	private static String src = "4";
}
