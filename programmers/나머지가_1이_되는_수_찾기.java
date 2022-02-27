package programmers;
/**
 * 2022.02.28
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/87389
 * 월간 코드 챌린지 시즌3
 */
public class 나머지가_1이_되는_수_찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(10));
	}

    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
			if(n % i == 1) {
				answer = i;
				break;
			}
		}
        return answer;
    }
}
