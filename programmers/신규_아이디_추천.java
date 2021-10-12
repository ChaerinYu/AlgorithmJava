package programmers;
/**
 * 2021.10.12
 * 신규 아이디 추천
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class 신규_아이디_추천 {
	
	public static void main(String[] args) {
		String new_id = "=.=";
		String answer = solution(new_id);
		System.out.println(answer);
	}

    public static String solution(String new_id) {
//        String answer = "";
        // 1단계 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");
        // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while(new_id.contains(".."))
        	new_id = new_id.replace("..", ".");
        // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        while(new_id.indexOf(".") == 0) {
        	new_id = new_id.substring(1);
        }
        while(new_id.lastIndexOf(".") == new_id.length()-1 && new_id.length()>0) {
        	new_id = new_id.substring(0, new_id.length()-1);
        }
        // 5단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.length()==0) new_id = "a";
        // 6단계 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length()>15) {
        	new_id = new_id.substring(0, 15);
        	while(new_id.lastIndexOf(".") == new_id.length()-1) {
        		new_id = new_id.substring(0, new_id.length()-1);
        	}
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(new_id.length()<3) {
        	new_id += new_id.substring(new_id.length()-1);
        }
        return new_id;
    }
}
/**
class Solution {
	public String solution(String new_id) {
	    String answer = "";
	    String temp = new_id.toLowerCase();
	
	    temp = temp.replaceAll("[^-_.a-z0-9]","");
	    System.out.println(temp);
	    temp = temp.replaceAll("[.]{2,}",".");
	    temp = temp.replaceAll("^[.]|[.]$","");
	    System.out.println(temp.length());
	    if(temp.equals(""))
	        temp+="a";
	    if(temp.length() >=16){
	        temp = temp.substring(0,15);
	        temp=temp.replaceAll("^[.]|[.]$","");
	    }
	    if(temp.length()<=2)
	        while(temp.length()<3)
	            temp+=temp.charAt(temp.length()-1);
	
	    answer=temp;
	    return answer;
	}
}

**/