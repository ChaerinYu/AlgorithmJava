package programmers;

/**
 * 체육복
 * 
 * @author ChaerinYu 
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 *         greedy 그리디 알고리즘
 */
public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] clothes = new int[n];
		// Arrays.fill(clothes, 1);
		for (int i = 0; i < lost.length; i++) {
			clothes[lost[i] - 1]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			clothes[reserve[i] - 1]++;
		}

		for (int i = 0; i < clothes.length; i++) {
			if (clothes[i] < 0) {
				if (i > 0 && clothes[i - 1] > 0) {
					clothes[i]++;
					clothes[i - 1]--;
					continue;
				}
				if (i < n - 1 && clothes[i + 1] > 0) {
					clothes[i]++;
					clothes[i + 1]--;
					continue;
				}
			}
		}
		for (int i = 0; i < clothes.length; i++) {
			if (clothes[i] >= 0)
				answer++;
		}
		return answer;
	}
}
/**
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
 */