package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1166. 선물
 * @author Chaerin Yu
 * 2022.01.04
 */
public class BOJ_1166 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // a 정육면체 개수
		int l = Integer.parseInt(st.nextToken()); // 높이
		int w = Integer.parseInt(st.nextToken()); // 가로
		int h = Integer.parseInt(st.nextToken()); // 세로
		
		double low = 0, high = Math.max(l, Math.max(w, h)); // 가장 큰 변을 찾아서 binary search
		// binary search
		for (int i = 0; i < 10_000; i++) {
			// 찾으려는 정육면체 박스의 한 변의 길이
			double mid = (low+high)/2;
			// 박스 길이 늘리기
			if((long)(l/mid)*(long)(w/mid)*(long)(h/mid) >= n) low = mid;
			// 박스 길이 줄이기
			else high = mid;
		}
		System.out.println(low);
	}

}
