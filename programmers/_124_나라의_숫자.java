package programmers;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * @author ChaerinYu
 * 3진법이랑 유사하다. 0,1,2 숫자가 아닌 1,2,4 숫자만 존재
 */
public class _124_나라의_숫자 {
    public String solution(int n) {
		StringBuilder answer = new StringBuilder();
	    String[] num = {"4","1","2"}; // 0 대신 4
        
        String a;
        while(n>0) {
            a = num[n%3]; // n%3으로 끝자리 계산
            n = (n-1)/3; // 남은 수 계산
            answer.insert(0, a);
        }
        return answer.toString();
    }
}
/*
 * 
		StringBuilder answer = new StringBuilder();
        
        int a;
        while(n>0) {
            a = n%3;
            n = n/3;
            if(a==0) {
                n -= 1;
                a = 4;
            }
            answer.insert(0, a);
        }
        return answer.toString();
 */
/*
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;
*/
