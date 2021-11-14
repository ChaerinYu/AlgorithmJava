package programmers;
/**
 * 2021.11.12
 * 핸드폰 번호 가리기
 * @author chaerin yu
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class 핸드폰_번호_가리기 {

	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
	}
    public static String solution(String phone_number) {
        String answer = phone_number.substring(phone_number.length()-4);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<phone_number.length()-4; i++) {
            sb.append("*");
        }
        sb.append(answer);
        return sb.toString();

//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        return String.valueOf(ch);
    }
}
