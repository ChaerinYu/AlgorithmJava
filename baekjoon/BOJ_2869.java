package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 2869. 달팽이는 올라가고 싶다
 * @author Chaerin Yu
 * 2021.11.21
 */
public class BOJ_2869 {

	static long A, B, V; //  (1 ≤ B < A ≤ V ≤ 1,000,000,000)
	// 낮, 밤, 높이
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken()); // 낮
		B = Long.parseLong(st.nextToken()); // 밤
		V = Long.parseLong(st.nextToken()); // 높이

		// 달팽이는 하루에 A-B만큼 올라간다.
		// V가 아닌 V-B미터를 나눈 이유는 낮에 도착할 수 있지만 밤에 B만큼 내려가는 걸 고려
        // B < A
		double day =(double)(V-B)/(A-B);

        System.out.println((int)Math.ceil(day));
	}

}
