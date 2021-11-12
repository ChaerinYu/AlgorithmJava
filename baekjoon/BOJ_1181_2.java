package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/**
 * 1181. 단어정렬
 * @author chaerin yu
 * 2021.11.12
 * 28736kb 260ms
 */
public class BOJ_1181_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 길이

		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length()-o2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]).append("\n");
		for (int i = 1; i < arr.length; i++) {
			if(!arr[i].equals(arr[i-1])) sb.append(arr[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
