package test;

import java.util.HashMap;
import java.util.Map;

public class 프로그래밍1 {
	public static void main(String[] args) {
		String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
		System.out.println(solution(id_list, 3));
	}

    public static int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < id_list.length; i++) {
        	String[] ids = id_list[i].split(" ");
            Map<String, Integer> check = new HashMap<String, Integer>(); // 오늘 방문자 리스트
        	for (String string : ids) {
        		
        		if(!check.containsKey(string)) {
        			// 이미 존재하는 키인 경우
        			if(map.containsKey(string)) {
        				map.put(string, map.get(string)+1);
        			} else {
        				map.put(string, 1);
        			}
        		}
        		check.put(string, 1);
			}
		}
        
        for (String key : map.keySet()) {
			if(map.get(key) >= k) answer += k;
			else answer += map.get(key);
		}
        
        
        return answer;
    }

	static class Member {
		String id;
		int visitedNum;
		
		public Member(String id, int visitedNum) {
			this.id = id;
			this.visitedNum = visitedNum;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getVisitedNum() {
			return visitedNum;
		}

		public void setVisitedNum(int visitedNum) {
			this.visitedNum = visitedNum;
		}
		
	}
}
