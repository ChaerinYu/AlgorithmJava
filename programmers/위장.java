package programmers;

import java.util.HashMap;
/**
 * 백준 9375 패션왕 신해빈 문제와 유사
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 * 2022.01.20
 */
public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
	
    public static int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String[] arr : clothes) {
        	map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        }
        int answer = 1; int temp = 0;
        for (String string : map.keySet()) {
        	System.out.println(map.get(string));
			temp = map.get(string);
			answer *= temp + 1;
		}
        // 모든 경우의 수에서 안입는 수 빼기
        return answer-1;
    }

}
