package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 프로그래밍3_2 {
	
	public static void main(String[] args) {
		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
		
		System.out.println(Arrays.toString(solution(logs)));
	}

    public static String[] solution(String[] logs) {
        
        Arrays.sort(logs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] or1Arr = o1.split(" ");
				String[] or2Arr = o2.split(" ");
				return Integer.compare(Integer.parseInt(or1Arr[0]), Integer.parseInt(or2Arr[0]));
			}
        	
		}); // 수험번호 별로 정렬
        
        Map<String, Map> students = new HashMap<String, Map>();
        
        Map<Integer, Integer> list = new HashMap<Integer, Integer>();
    	String prev = ""; int cnt = 0;
        for (String string : logs) {
        	String[] quest = string.split(" ");
        	String id = quest[0];
        	// 이전 아이디와 같은 경우 list에 마저 넣는다.
        	if(id.equals(prev)) {
        		list.put(Integer.parseInt(quest[1]), Integer.parseInt(quest[2]));
        	} else {
        		// 아이디가 "" 가 아닐 때에만, 수험생이 푼 문제로 등록
        		if(!(prev.equals("")))
        			students.put(prev, list);
        		// 초기화해주고 다시 문제정보 입력
        		list = new HashMap<Integer, Integer>();
        		list.put(Integer.parseInt(quest[1]), Integer.parseInt(quest[2]));
        		prev = id; // prev update
        	}
        	
        	cnt ++;
        	if(cnt==logs.length) {
    			students.put(prev, list);
        	}
		}
        
        
        // 5문제 이상 푼 학생을 일단 의심학생으로 넣는다.
        ArrayList<String> suspicion = new ArrayList<String>();
        for (String key : students.keySet()) {
        	System.out.println("key: "+key);
        	Map<Integer, Integer> qMap = students.get(key);
        	if(qMap.size() >= 5) {
        		suspicion.add(key);
        	}
		}
        
        // 의심학생
        Map<String, Boolean> answerList = new HashMap<String, Boolean>();
        System.out.println(suspicion.size());
        for (int i = 0; i < suspicion.size(); i++) {
			loopOut:
        	for (int j = i+1; j < suspicion.size(); j++) {
				Map<Integer, Integer> list1 = students.get(suspicion.get(i));
				Map<Integer, Integer> list2 = students.get(suspicion.get(j));
				
				for (Integer qNumber : list1.keySet()) {
					if(list1.get(qNumber) != list2.get(qNumber)) {
						continue loopOut;
					}
				}
				
				answerList.put(suspicion.get(i), true);
				answerList.put(suspicion.get(j), true);
			}
		}

        // 의심학생 없는 경우
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
}
