package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 2810. 컵홀더
 * @author ChaerinYu
 * 극장의 한 줄의 정보가 주어진다. 
 * 이때, 이 줄에 사람들이 모두 앉았을 때, 컵홀더에 컵을 꽂을 수 있는 최대 사람의 수를 구하는 프로그램을 작성하시오. 
 * 모든 사람은 컵을 한 개만 들고 있고, 자신의 좌석의 양 옆에 있는 컵홀더에만 컵을 꽂을 수 있다.
 * S는 일반 좌석, L은 커플석을 의미하며, L은 항상 두개씩 쌍으로 주어진다.
 * 
 * 첫째 줄에 좌석의 수 N이 주어진다. (1 ≤ N ≤ 50) 둘째 줄에는 좌석의 정보가 주어진다.
 */
public class BOJ_2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine()); // 좌석 수
		String seats = br.readLine(); // 좌석
		
		// 커플 좌석 있는 경우
		if(seats.contains("LL")) {
			seats = seats.replaceAll("LL", "S"); // 커플좌석(LL)을 S로 replace해준다.
			System.out.println(seats.length()+1);
		} else {
			// 일반 좌석만 있는 경우
			System.out.println(seats.length());
		}
	}
}
