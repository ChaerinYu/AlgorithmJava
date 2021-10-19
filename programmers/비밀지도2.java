package programmers;

import java.util.Arrays;

/**
 * 2021.10.19
 * 비밀지도
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class 비밀지도2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
	}

    public static String[] solution(int n, int[] arr1, int[] arr2) {

    	String[] answer = new String[n];
    	for (int i = 0; i < n; i++) {
    		answer[i] = Integer.toBinaryString(arr1[i]|arr2[i]);
    		answer[i] = String.format("%"+n+"s", answer[i]);
    		answer[i] = answer[i].replaceAll("1", "#");
    		answer[i] = answer[i].replaceAll("0", " ");
    	}
    	
        return answer;
    }
    
}
