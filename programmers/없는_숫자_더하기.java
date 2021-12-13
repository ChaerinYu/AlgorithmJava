package programmers;

/**
 * 없는 숫자 더하기
 * 2021.12.13
 * @author user
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 */
public class 없는_숫자_더하기 {

	public static void main(String[] args) {
		
	}

    public int solution(int[] numbers) {
        boolean[] numArr = new boolean[10];
        
        for(int i=0; i<numbers.length; i++) {
            numArr[numbers[i]] = true;
        }
        
        int answer = 0;
        for(int i=1; i<numArr.length; i++) {
            if(!numArr[i]) answer += i;
        }
        
        return answer;
    }
}

/**
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
**/