package programmers;

import java.util.Calendar;

/**
 * 2021.10.18
 * 2016년
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12901?language=java
 * 2016년 1월 1일은 금요일입니다.
 */
public class _2016년 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

    public static String solution(int a, int b) {
    	String[] weeks = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, 2016);
        today.set(Calendar.MONTH, a-1);
        today.set(Calendar.DATE, b);
//        System.out.println(weeks[today.get(Calendar.DAY_OF_WEEK)]);
        return weeks[today.get(Calendar.DAY_OF_WEEK)];
    }
}
