package programmers;

/**
 * 2021.10.29
 * 위클리 챌린지 - 1주차_부족한 금액 계산하기
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class 부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        long answer = money;
        
        for(int i=1; i<=count; i++) {
            answer -= price*i;
        }
        
        if(answer >= 0) return 0;
        else return -answer;
    }
    
    //  return Math.max(price * (count * (count + 1) / 2) - money, 0);
}
