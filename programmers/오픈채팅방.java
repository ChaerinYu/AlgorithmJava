package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 2021.10.14
 * 오픈 채팅방
 * @author Chaerin Yu
 * 2019 KAKAO BLIND RECRUITMENT
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class 오픈채팅방 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"Enter uid1234 Muzi"
												, "Enter uid4567 Prodo"
												, "Leave uid1234"
												, "Enter uid1234 Prodo"
												, "Change uid4567 Ryan"})));
	}
	
	public static String[] solution(String[] record) {
        Map<String, String> user = new HashMap<String, String>(); // 사용자 목록
        StringTokenizer st = null;
        // 사용자 목록 세팅
        for(int i=0; i<record.length; i++) {
            st = new StringTokenizer(record[i]);
            String command = st.nextToken(); // 명령어
            String uid = st.nextToken();     // uid
            String nickname = "";            // 닉네임
            // Leave 아닌 경우에 닉네임 받아온다.
            if(!"Leave".equals(command))
                nickname = st.nextToken();
            
            if(nickname.length()>0) {
                user.put(uid, nickname);
            }
        }

        // 메시지 출력
		ArrayList<String> temp = new ArrayList<String>();
        
        for(int i=0; i<record.length; i++) {
            st = new StringTokenizer(record[i]);
            String command = st.nextToken(); // 명령어
            String uid = st.nextToken();     // uid
            String nickname = "";            // 닉네임
            // Leave 아닌 경우에 닉네임 받아온다.
            if(!"Leave".equals(command))
                nickname = st.nextToken();
            
            switch(command) {
                case "Enter":
                    temp.add(user.get(uid)+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    temp.add(user.get(uid)+"님이 나갔습니다.");
                    break;
                case "Change":
                    break;
                default:
                    break;
            }
        }
        
        String[] answer = new String[temp.size()];
        int idx = 0;
        for(String str:temp) {
            answer[idx++] = str;
        }
        return answer;
    }
	
}
