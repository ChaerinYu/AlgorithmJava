package programmers;
/**
 * 2021.10.16
 * 약수의 개수와 덧셈
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/77884
 */
public class 약수의_개수와_덧셈 {

	public void main(String[] args) {
		System.out.println(solution(13, 17));
	}
	
	public int solution(int left, int right) {
        int answer = 0;
        
        // 약수의 개수가 홀수인 경우 -> 제곱수
        for(int i=left; i<=right; i++) {
        	
        	int half = i/2;
        	
        	boolean flag = false;
        	// 숫자 1일 때
        	if(i==1) flag = true;
        	// 숫자 1이 아닐 때
        	else {
        		for (int j = 1; j <= half; j++) {
        			if(j*j == i) {
        				flag = true;
        				break;
        			}
        		}
        	}
        	
        	if(flag) answer -= i;
        	else answer += i;
        	
        }
        
        return answer;
    }
}
/**

	//제곱수인 경우 약수의 개수가 홀수
	if (i % Math.sqrt(i) == 0) {
	    answer -= i;
	}
	//제곱수가 아닌 경우 약수의 개수가 짝수
	else {
	    answer += i;
	}

**/