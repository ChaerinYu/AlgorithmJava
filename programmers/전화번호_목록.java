package programmers;

import java.util.Arrays;
/**
 * 2022.01.18
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 전화번호 목록
 * @author Chaerin Yu
 */
public class 전화번호_목록 {

	public static void main(String[] args) {
		String[] phone_book = {"1234", "1235", "567"};
		System.out.println(solution(phone_book));
	}
	
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i=1; i<phone_book.length; i++) {
        	if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }
        
        return true;
    }
}
