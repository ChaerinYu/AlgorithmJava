package programmers;

import java.util.ArrayList;
import java.util.Collections;
/**
 * K번째 수
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * 정렬 문제
 */
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
		int idx = 0;
		// 명령어 수 만큼 for문
		for (int i = 0; i < commands.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int start = commands[i][0]; // 시작
			int end = commands[i][1]; // 끝
			int pick = commands[i][2]; // 선택한 인덱스
			
			for (int j = start-1; j < end; j++) {
				list.add(array[j]);
			}
            Collections.sort(list);
			answer[idx++] = list.get(pick-1);
		}
        // return Arrays.toString(answer);
        return answer;
    }
}

/**
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

*/