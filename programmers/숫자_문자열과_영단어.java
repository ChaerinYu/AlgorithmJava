package programmers;

/**
 * 21.10.23
 * 숫자 문자열과 영단어
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class 숫자_문자열과_영단어 {

	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}
    public static int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strArr.length; i++) {
        	s = s.replaceAll(strArr[i], String.valueOf(i));
		}
//        System.out.println(s);
        return Integer.parseInt(s);
    }
}
