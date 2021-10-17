package programmers;

import java.util.ArrayList;

/**
 * 2021.10.17
 * 문자열 압축
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class 문자열_압축 {

	public static void main(String[] args) {
		System.out.println(solution("abcabcdede"));
	}
	public static int solution(String s) {
        int answer = 0; // 정답
        int len = s.length(); // 문자열 길이

        int prevSize = Integer.MAX_VALUE; // 이전 압축 문자열 길이
        String answerStr = ""; // 제일 짧은 압축 문자열
        for (int i = len; i >= 1; i--) {
        	// i개씩 단어 만들기
        	ArrayList<String> list = new ArrayList<String>();
        	for (int j = 0; j < len; j+=i) {
        		String temp = ""; 
        		if(j+i>=len) temp = s.substring(j, len);
        		else temp = s.substring(j, j+i);
				list.add(temp);
			}
        	// 압축 문자열 저장
        	ArrayList<Word> compressed = new ArrayList<Word>();
        	String prev = list.get(0);
        	int num = 0;
        	for (String word : list) {
				if(word.equals(prev)) {
					// 이전과 같은 경우
					num++;
				} else {
					// 이전과 다른 경우, list에 넣어주고 num 초기화
					compressed.add(new Word(prev, num));
					num = 1; // 현재 단어 카운팅
				}
				prev = word; // 이전 단어 업데이트
			}
			compressed.add(new Word(prev, num));
        	
    		answerStr = "";
    		for (Word word : compressed) {
    			// 압축 안된 경우 1 생략
    			if(word.num != 1)
    				answerStr += word.num;
				answerStr += word.word;
			}
    		// 이전 압축 문자열보다 짧은 경우 업데이트
    		if(prevSize > answerStr.length())
    			prevSize = answerStr.length();
		}
//        System.out.println(answerStr);
        answer = prevSize;
        return answer;
    }
	
	static class Word {
		String word;
		int num;
		
		public Word(String word, int num) {
			this.word = word;
			this.num = num;
		}
		
		
	}
}
