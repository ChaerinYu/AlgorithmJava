package programmers;

import java.util.ArrayList;
/**
 * 2022.02.02
 * 모의고사
 * 완전탐색
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class 모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<Integer> solution(int[] answers) {
    	// 수포자 1, 2, 3의 제출답안
        int[][] submits = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        // 정답
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] scores = new int[submits.length]; // 수포자 1, 2, 3의 점수
        int[] sizes = new int[submits.length]; // 수포자 1, 2, 3의 찍는 방식 사이즈
        for(int i=0; i<sizes.length; i++) {
            sizes[i] = submits[i].length;
        }
        // 문제
        int question = 0;
        for(int a : answers) {
            for(int i=0; i<sizes.length; i++) {
            	// 정답 맞는 경우
                if(submits[i][question%sizes[i]] == a) {
//            	if(submits[i][question%sizes[i]] == answers[question]) {
                    scores[i]++;
                }
            }
            question++;
        }
        // 많이 맞은 수
        int max = 0;
        for(int score: scores) {
            if(score > max) max = score;
        }
        
        int person = 1;
        for(int score: scores) {
            if(score == max) answer.add(person);
            person++;
        }
        
        return answer;
    }
}
