package programmers;

import java.util.Calendar;

/**
 * 2021.10.18
 * 2016년
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12901?language=java
 * 2016년 1월 1일은 금요일입니다.
 * 훨씬 빠르다.
 */
public class _2016년2 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

    public static String solution(int a, int b) {
    	String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    	int[] tDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
    	int d = -1;
    	for (int i = 0; i < a-1; i++) {
			d += tDays[i];
		}
    	d += b;
    	
    	d = d%7;
    	
        return weeks[d];
    }
}
