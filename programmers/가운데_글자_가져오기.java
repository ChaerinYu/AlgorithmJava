package programmers;
/**
 * 2021.10.20
 * 가운데 글자 가져오기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class 가운데_글자_가져오기 {

	public static void main(String[] args) {
		System.out.println(solution("qwer"));
	}
	
	public static String solution(String s) {
		boolean odd = s.length() % 2 == 0 ? false : true;
        String answer = "";
        if(odd) {
        	answer = s.substring(s.length()/2, s.length()/2+1);
        } else {
        	answer = s.substring(s.length()/2-1, s.length()/2+1);
        }
        return answer;
    }
}
