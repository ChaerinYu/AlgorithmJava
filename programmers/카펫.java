package programmers;

import java.util.Arrays;
/**
 * 2021.12.08
 * @author Chaerin Yu
 * 완전탐색
 */
public class 카펫 {

	public static void main(String[] args) {
		int[] ans = solution(10, 2);
		System.out.println(Arrays.toString(ans));
	}

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // brown = (가로 + 세로 - 2)*2
        // yellow = (가로-2)*(세로-2)
        outer: 
        for(int i=brown/2; i>=1; i--) {
            for(int j=i; j>=1 ; j--) {
                if(brown == (i+j-2)*2 && yellow == (i-2)*(j-2)) {
                    answer[0] = i;
                    answer[1] = j;
                    break outer;
                }
            }
        }
        
//        int a = (brown+4)/2; // 가로+세로
//        int b = yellow+2*a-4; // 넓이 (가로x세로)
//        answer = new int[]{(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
}
