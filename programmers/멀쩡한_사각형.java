package programmers;
/**
 * 21.10.07
 * 멀쩡한 사각형
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 * 깨진 사각형의 개수 = 가로 + 세로 - (가로 세로의 최대공약수)
 */
public class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        int broken = w + h - gcd(w,h);
        
        return (long) w*h - broken;
    }
    // 최대 공약수
    public int gcd(int w, int h) {
        if(w % h == 0) return h;
        else return gcd(h, w%h);
    }
}
/**
 * 패턴이 최대공약수의 수만큼 나타나기 때문에
 * (w/최대공약수 + h/최대공약수 - 1)*최대공약수 가 전체 직사각형에서 잘려진 사각형의 개수
 * 즉 (W+H-최대공약수)
 * 
우선 w와 h가 공약수가 있다면 문제를 공약수를 나눈 w' 와 h'로 축소시킬수있습니다.
w'와 h'가 서로소라 가정했을때 대각선은 반대쪽 코너에 도달하기전 
w'-1 세로선과 h'-1 가로선을 지나고 지날때마다 새로운 정사각형이 추가됩니다. 
그래서 첫 정사각형을 포함 1 + (w'-1) + (h'-1) = w' + h' - 1개의 정사각형을 지나게 되므로 
공약수를 다시 곱해주면 w + h - gcd(w,h)개의 정사각형을 지나는것을 찾을수있습니다.
**/
