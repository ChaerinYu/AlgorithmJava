package programmers;

import java.util.Arrays;
/**
 * 2021.12.20
 * https://programmers.co.kr/learn/courses/30/lessons/42747#
 * H-Index
 * @author user
 *
 */
public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
			if(citations[i] >= citations.length - i) {
				return citations.length-i;
			}
		}
        return 0;
    }
}
