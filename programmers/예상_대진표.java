package programmers;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 * 예상 대진표
 * @author user
 *
 */
public class 예상_대진표 {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

    public static int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a!=b) {
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }

        return answer;
        
//        (a-1) XOR (b-1)값을 이진수 문자열로 변환한 길이를 세는 거니까. 
//        예를들어 3과 7이면 11 XOR 111이고 값은 100이 되니까 문자열 길이가 바로 3라운드가 된다.
//        return Integer.toBinaryString((a-1)^(b-1)).length();
    }
}
