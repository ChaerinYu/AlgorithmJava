package programmers;

import java.util.Arrays;

/**
 * 2021.11.01
 * 구명보트
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class 구명보트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {40,50,150,160};
		System.out.println(solution(people, 200));
	}

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		int right = people.length-1;
		int left = 0;
		
		int answer = 0;
		while(right >= left) {
			if(people[right--]+people[left] <= limit) {
				left++;
			}
			answer++;
		}
		/*
		list.add(people[people.length-1]);
		for (int i = people.length-2; i >= 0; i--) {
			if(limit - list.get(list.size()-1) < people[i]) {
				list.add(people[i]);
			} else {
				list.set(list.size()-1, list.get(list.size()-1)+people[i]);
			}
		}*/
        return answer;
    }
}
