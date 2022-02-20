package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 2022.02.20
 * @author Chaerin Yu
 * 2022 KAKAO BLIND RECRUITMENT
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 */
public class 신고_결과_받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 유저별 신고한 사용자 목록
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
			list.add(new ArrayList<String>());
		}
        // 중복신고제거
        Set<String> reportSet = new HashSet<String>();
        for (String str : report) {
        	reportSet.add(str);
        }
        
        StringTokenizer st = null;
        Map<String, Integer> freqMap = new HashMap<>(); // 각 유저별 신고당한 횟수
        for (String str : reportSet) {
			st = new StringTokenizer(str);
			String user1 = st.nextToken();
			String user2 = st.nextToken();
			
			int idx1 = -1, idx2 = -1;
			boolean findUser1 = false, findUser2 = false;
			for (int i = 0; i < id_list.length; i++) {
				if(id_list[i].equals(user1)) {
					// 신고한 사용자 찾기
					idx1 = i;
					findUser1 = true;
				} else if(id_list[i].equals(user2)) {
					// 신고당한 사용자 찾기
					idx2 = i;
					findUser2 = true;
				}
				// 둘 다 찾았으면 멈추기
				if(findUser1 && findUser2) break;
			}
			
			list.get(idx1).add(id_list[idx2]);
			freqMap.put(id_list[idx2], freqMap.getOrDefault(id_list[idx2], 0)+1);
		}
        
        
        for (String user : freqMap.keySet()) {
			if(freqMap.get(user) >= k) {
				// 신고한 이용자
				for (int i = 0; i < list.size(); i++) {
					// 신고한 이용자가 신고한 사람들
					for (int j = 0; j < list.get(i).size(); j++) {
						if(list.get(i).get(j).equals(user)) {
							answer[i]++; // 메일전송
							break;
						}
					}
				}
				
			}
		}
        
        return answer;
    }

}
