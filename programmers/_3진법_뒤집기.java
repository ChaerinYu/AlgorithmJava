package programmers;

import java.util.ArrayList;

/**
 * 2021.10.17
 * 3진법 뒤집기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 */
public class _3진법_뒤집기 {

	public static void main(String[] args) {
		System.out.println(solution(125));
	}

    public static int solution(int n) {
        int answer = 0;
        StringBuilder list = new StringBuilder();
        while(n/3 > 0) {
            list.append(n%3);
            n = n/3;
        }
        list.append(n%3);
        
        for (int i = 0, three = (int) Math.pow(3, list.length()-1); i < list.length(); i++) {
			answer += (list.charAt(i)-'0') * three;
//			System.out.println(list.charAt(i)-'0'+", "+three);
//			System.out.println(answer);
			three /= 3;
		}
        
        return answer;
    }
}

/**
	public int solution(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }
**/
