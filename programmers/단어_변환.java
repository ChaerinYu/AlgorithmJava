package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2022.02.17
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * @author Chaerin Yu
 * 단어 변환
 * BFS/DFS
 */
public class 단어_변환 {

	static int answer;
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}

    public static int solution(String begin, String target, String[] words) {
    
    	answer = 0;
    	bfs(begin, target, words);
        return answer;
    }

	private static void bfs(String begin, String target, String[] words) {
		Queue<String> queue = new LinkedList<String>();    // 단어 QUEUE
		Queue<Integer> nQueue = new LinkedList<Integer>(); // N단계 QUEUE
		boolean[] visited = new boolean[words.length];
		
		queue.offer(begin);
		nQueue.offer(0);
		visited = checkVisit(begin, words, visited);
		
		String now = "";
		int num = 0;
		while(!queue.isEmpty()) {
			now = queue.poll();
			num = nQueue.poll();
			
			if(now.equals(target)) {
				answer = num;
				return;
			}
			
			for (int i = 0; i < words.length; i++) {
				// 이미 확인한 단어인 경우 continue
				if(visited[i]) continue;
				// 한 글자만 다른 단어 찾기
				int cnt = 0;
				for (int j = 0; j < now.length(); j++) {
					if(now.charAt(j) != words[i].charAt(j)) cnt++;
				}
				if(cnt == 1) {
					visited[i] = true;
					queue.offer(words[i]);
					nQueue.offer(num+1);
				}
			}
		}
	}

	/**
	 * begin 문자열 방문체크
	 * @param str
	 * @param words
	 * @param visited
	 * @return
	 */
	private static boolean[] checkVisit(String str, String[] words, boolean[] visited) {
		int idx = -1;
		for(int i=0; i<words.length; i++) {
			if(str.equals(words[i])) {
				idx = i;
				break;
			}
		}
		if(idx != -1) 
			visited[idx] = true;
		return visited;
	}
}
