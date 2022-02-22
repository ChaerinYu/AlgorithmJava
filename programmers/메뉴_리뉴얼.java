package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 2022.02.22
 * 2021 KAKAO BLIND RECRUITMENT
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class 메뉴_리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		
		System.out.println(solution(orders, course));
	}

	static Map<String, Integer> map ;
    public static ArrayList<String> solution(String[] orders, int[] course) {
    	ArrayList<String> answer = new ArrayList<>();
    	
    	// orders 안에 있는 문자열 오름차순으로
    	char[] charArr = null;
    	for (int i = 0; i < orders.length; i++) {
    		charArr = orders[i].toCharArray();
			Arrays.sort(charArr);
			orders[i] = new StringBuilder(new String(charArr)).toString();
		}
    	
    	StringBuilder sb = null;
    	// course
    	for (int i = 0; i < course.length; i++) {
    		// 조합 수 카운팅
    		map = new HashMap<>();
    		int max = 0;
    		
    		for (int j = 0; j < orders.length; j++) {
				sb = new StringBuilder();
				// 코스 수 <= 문자열 길이일 때에만 조합 구하기
				if(course[i] <= orders[j].length()) {
					comb(0, 0, course[i], orders[j], sb);
				}
			}
    		
    		// 가장 많이 주문된 횟수 저장
    		for (String key : map.keySet()) {
				max = Math.max(map.get(key), max);
			}

    		// 최소 2번 주문했고 max 수와 일치하는 경우 answer에 추가
    		for (String key : map.keySet()) {
				if(max >= 2 && map.get(key) == max) {
					answer.add(key);
				}
			}
    		
		}
    	// 오름차순 정렬
    	Collections.sort(answer);
        return answer;
    }
    
    
	private static void comb(int idx, int cnt, int n, String str, StringBuilder sb) {
		if(cnt == n) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
			return;
		}
		
		for (int i = idx; i < str.length(); i++) {
			sb.append(str.charAt(i));
			comb(i+1, cnt+1, n, str, sb);
			sb.delete(cnt, cnt+1);
		}
	}
}
