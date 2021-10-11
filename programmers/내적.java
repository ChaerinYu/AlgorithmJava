package programmers;
/**
 * 21.10.11
 * https://programmers.co.kr/learn/courses/30/lessons/70128
 * @author ChaerinYu
 *
 */
public class 내적 {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int n = solution(a, b);
		System.out.println(n);
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}
