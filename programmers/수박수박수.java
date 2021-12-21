package programmers;
/**
 * 수박수박수박수
 * https://programmers.co.kr/learn/courses/30/lessons/12922
 * @author ChaerinYu
 * 2021.12.21
 */
public class 수박수박수 {

	public static void main(String[] args) {

	}
	
    public String solution(int n) {
        String watermelon = "수박";
        StringBuilder sb = new StringBuilder();
        // 
        if(n % 2 == 0) {
            for(int i=0; i<n/2; i++) {
                sb.append(watermelon);
            }
        } else {
            sb.append(watermelon);
            for(int i=0; i<n/2; i++) {
                sb.append(watermelon);
            }
            if(n%2 == 1) sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }

}
