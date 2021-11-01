package programmers;
/**
 * 2021.11.01
 * 이상한 문자 만들기
 * 느낀점: 진짜.. 이상하다.
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class 이상한_문자_만들기 {

	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
		System.out.println(solution("try hell hell hell"));
		System.out.println(solution("hello hell hello hell"));
	}

	private static String solution(String s) {
		
        String[] words = s.split("");
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(String word: words) {
        	if(" ".equals(word)) {
        		sb.append(" ");
        		idx = 0;
        	} else {
    			if(idx%2 == 0) 
    				sb.append(word.toUpperCase());
    			else
    				sb.append(word.toLowerCase());
    			idx++;
        	}
        }
        
        return sb.toString();
	}
	
	
}
