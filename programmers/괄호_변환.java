package programmers;

/**
 * 괄호 변환
 * 21.10.24
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class 괄호_변환 {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}

    public static String solution(String p) {
    	if(p.length()==0) return "";

    	// 문자열 만들기
		// u, v로 나누기
    	char[] arr = p.toCharArray();
    	int point = 0;
    	for (int i = 0, cnt = 0; i < arr.length; i++) {
			if(arr[i]=='(') cnt++;
			else cnt--;
			if(cnt==0) {
				point = i+1;
				break;
			}
		}
    	String u = p.substring(0, point);
    	String v = p.substring(point, p.length());
		
    	return isRight(u) ? u + solution(v) : "(" + solution(v) + ")" + trim(u);
    }

	// 올바른 괄호 문자열인지 체크
	private static boolean isRight(String p) {
    	char[] arr = p.toCharArray();
    	int cnt = 0;
    	for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='(') cnt++;
			else cnt--;
			if(cnt<0) return false;
    	}
    	if(cnt != 0) return false;
    	
		return true;
	}
	
	// 다듬기 (첫번째, 마지막 글자 제거하고 남은 문자('(',')')들 뒤집어서 저장)
	private static String trim(String p) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i < p.length()-1; i++) {
			if(p.charAt(i) == ')') sb.append("(");
			else sb.append(")");
		}
		return sb.toString();
	}

}
