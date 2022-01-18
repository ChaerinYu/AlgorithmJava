package programmers;

import java.util.HashSet;
/**
 * 2022.01.18
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 전화번호 목록
 * @author Chaerin Yu
 */
public class 전화번호_목록2 {

	public static void main(String[] args) {
		String[] phone_book = {"1234", "1235", "567"};
		System.out.println(solution(phone_book));
	}
	
    public static boolean solution(String[] phone_book) {
    	HashSet<String> set = new HashSet<String>();
    	
    	// 모든 전화번호 넣고
    	for (int i = 0; i < phone_book.length; i++) {
			set.add(phone_book[i]);
		}
        
    	// 모든 전화번호의 substring 이 set에 있는지 확인
        for(int i=0; i<phone_book.length; i++) {
        	for (int j = 0; j < phone_book[i].length(); j++) {
				if(set.contains(phone_book[i].substring(0, j))) return false;
			}
        }
        
        return true;
    }
}
