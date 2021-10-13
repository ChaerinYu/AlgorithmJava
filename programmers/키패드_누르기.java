package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021.10.13
 * [카카오 인턴] 키패드 누르기
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class 키패드_누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}
	
	static Map<Integer, int[]> dial = new HashMap<Integer, int[]>();
    
    private static void setDial() {
        dial.put(1, new int[] {0, 0});
        dial.put(2, new int[] {0, 1});
        dial.put(3, new int[] {0, 2});
        dial.put(4, new int[] {1, 0});
        dial.put(5, new int[] {1, 1});
        dial.put(6, new int[] {1, 2});
        dial.put(7, new int[] {2, 0});
        dial.put(8, new int[] {2, 1});
        dial.put(9, new int[] {2, 2});
        dial.put(0, new int[] {3, 1});
    }
    
    public static String solution(int[] numbers, String hand) {
        // String answer = "";
        StringBuilder answer = new StringBuilder();
        
        setDial();
        
        int[] prevR = {3, 2}, prevL = {3, 0};
        for(int num : numbers) {
            int[] now = dial.get(num);
            // 3, 6, 9
            if(num>0 && num%3 == 0) {
                answer.append("R");
                prevR = now;
            }
            // 1, 4, 7
            else if(num%3 == 1) {
                answer.append("L");
                prevL = now;
            }
            else {
                int lenL = Math.abs(now[0]-prevL[0])+Math.abs(now[1]-prevL[1]);
                int lenR = Math.abs(now[0]-prevR[0])+Math.abs(now[1]-prevR[1]);
                
                if(lenL>lenR) {
                    answer.append("R");
                    prevR = now;
                } else if (lenL<lenR) {
                    answer.append("L");
                    prevL = now;
                } else {
                    // 오른손 잡이 일 때
                    if("right".equals(hand)) {
                        answer.append("R");
                        prevR = now;
                    } else {
                        answer.append("L");
                        prevL = now;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}
