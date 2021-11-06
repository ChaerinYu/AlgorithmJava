package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2021.11.06
 * 가장 큰 수
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * 순열 쓸 경우 시간초과 발생함 ㅠㅠ
 */
public class 가장_큰_수 {

	public static void main(String[] args) {
		int[] numbers = {0,0,0,0,0};
		System.out.println(solution(numbers));
	}
	
//	private static String[] arr;
//	private static boolean[] visited;
//	private static String answer;
	
	public static String solution(int[] numbers) {
        
//        arr = new String[numbers.length];
//        visited = new boolean[numbers.length];
//        answer = "0";
//        perm(numbers, 0);
        
		String[] strNumArr = new String[numbers.length];
		for (int i = 0; i < strNumArr.length; i++) {
			strNumArr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strNumArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1);
			}
		});
		
		// [0, 0, 0]인 경우 고려
        if(strNumArr[0].charAt(0) == '0') return "0";
        
        StringBuilder answer = new StringBuilder();
        for (String string : strNumArr) {
			answer.append(string);
		}
        
		return answer.toString();
    }
	/*
	private static void perm(int[] numbers, int index) {
		if(index == numbers.length) {
			StringBuilder sb = new StringBuilder();
			for (String a : arr) {
				sb.append(a);
			}
			String temp = sb.toString();
			if(temp.charAt(0) != '0') {
				if(answer.compareTo(temp) < 0) answer = temp;
			}
			return;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if(visited[i]) continue;
			arr[index] = String.valueOf(numbers[i]);
			visited[i] = true;
			perm(numbers, index+1);
			visited[i] = false;
		}
	}
	*/
}
