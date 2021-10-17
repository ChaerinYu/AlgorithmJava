package programmers;

/**
 * 2021.10.17
 * 문자열 압축
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * 엄청난 시간 단축!
 */
public class 문자열_압축2 {

	public static void main(String[] args) {
		System.out.println(solution("abcabcdede"));
	}
	public static int solution(String s) {
        int answer = s.length(); // 정답
        int len = s.length(); // 문자열 길이

        for (int i = 1; i <= len/2 + 1; i++) {
        	String before = ""; // 이전 단어
        	int sum = 0; // 최종 압축된 문자열 길이
        	int cnt = 1; // 단어 등장 수 카운팅
        	
        	// i개씩 단어 만들기
        	for (int j = 0; j < len; j+=i) {
        		// 문자열 생성
        		String temp = ""; 
        		if(j+i>=len) temp = s.substring(j, len);
        		else temp = s.substring(j, j+i);
        		
        		if(temp.equals(before)) {
        			// 이전 단어와 동일한 경우 +1
        			cnt++;
        		} else {
        			// 이전 단어와 다른 경우
        			// 1인 경우 (인접 단어와 중복 안되는 경우) 굳이 1 작성 안 함
        			if(cnt != 1)
        				sum += (int) Math.log10(cnt)+1; // 단어 길이 숫자의 문자열 길이
        			cnt = 1; // 카운팅 초기화
        			
        			// 압축 길이에 단어 길이 더하기
        			sum += before.length();
        			// 비교 대상(단어) 업데이트
        			before = temp;
        		}
			}
        	// 마지막 단어 처리
        	if(cnt != 1)
        		sum += (int) Math.log10(cnt)+1;
        	sum += before.length();
        	// 마지막 단어 처리 끝
        	
        	// 이전에 구한 정답보다 짧은 경우 업데이트
        	if(answer > sum)
        		answer = sum;
		}
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
