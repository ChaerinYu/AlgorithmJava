package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 프로그래밍3 {
	
	public static void main(String[] args) {
		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
		
		System.out.println(solution(logs));
	}

    public static String[] solution(String[] logs) {
        
        Arrays.sort(logs); // 수험번호 별로 정렬
        
        Map<String, List<QuestInfo>> students = new HashMap<String, List<QuestInfo>>();
        
        List<QuestInfo> list = new ArrayList<QuestInfo>();
    	String prev = "";
        for (String string : logs) {
        	String[] quest = string.split(" ");
        	String id = quest[0];
        	// 이전 아이디와 같은 경우 list에 마저 넣는다.
        	if(id.equals(prev)) {
        		list.add(new QuestInfo(Integer.parseInt(quest[1]), Integer.parseInt(quest[2])));
        	} else {
        		// 아이디가 "" 가 아닐 때에만 
        		if(!prev.equals(""))
        			students.put(quest[0], list);
        		// 초기화해주고 다시 문제정보 입력
        		list = new ArrayList<QuestInfo>();
        		list.add(new QuestInfo(Integer.parseInt(quest[1]), Integer.parseInt(quest[2])));
        		prev = id; // prev update
        	}
		}
        
        ArrayList<String> suspicion = new ArrayList<String>();
        for (String key : students.keySet()) {
        	List<QuestInfo> qList = students.get(key);
        	if(qList.size() >= 5) {
        		suspicion.add(key);
        	}
		}

        Map<String, Boolean> answerList = new HashMap<String, Boolean>();
        System.out.println(suspicion.size());
        for (int i = 0; i < suspicion.size(); i++) {
			loopOut:
        	for (int j = i+1; j < suspicion.size(); j++) {
				boolean flag = false;
				List<QuestInfo> list1 = students.get(suspicion.get(i));
				List<QuestInfo> list2 = students.get(suspicion.get(j));
				
				for (int k = 0; k < list1.size(); k++) {
					if(list1.get(k).getQuestN() != list2.get(k).getQuestN() 
							|| list1.get(k).getScore() != list2.get(k).getScore()) {
						flag = true;
						continue loopOut;
					}
				}
				
				answerList.put(suspicion.get(i), true);
				answerList.put(suspicion.get(j), true);
			}
		}

        if(answerList.size() == 0) {
        	return new String[] {"None"};
        } else {
        	String[] answer = new String[answerList.size()]; int idx = 0;
        	for (String key : answerList.keySet()) {
        		answer[idx++] = key;
        	}
        	
        	Arrays.sort(answer);
        	return answer;
        }
    }

	static class QuestInfo {
		int questN;
		int score;
		
		public QuestInfo(int questN, int score) {
			this.questN = questN;
			this.score = score;
		}

		public int getQuestN() {
			return questN;
		}

		public void setQuestN(int questN) {
			this.questN = questN;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
	}
}
