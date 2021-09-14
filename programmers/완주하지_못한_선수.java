package programmers;

import java.util.Arrays;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * @author ChaerinYu
 */
public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant); // 정렬
        Arrays.sort(completion); // 정렬
        boolean checked = false; 
        // 완주 못 한 선수가 마지막일 경우 체크하기 위함 (participant가 completion보다 1명 더 많음)
        for(int i=0; i<completion.length; i++) {
            // 정렬했는데 index에 다른 값 들어가 있으면 완주 못 한 선수
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                checked = true;
                break;
            }
        }
        // 완주 못 한 선수가 이름정렬했을 때 마지막인 경우 고려
        if(!checked) {
            answer = participant[participant.length-1];
        }
        
        return answer;
    }
}
/*

        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
                break;
            }
        }
*/
