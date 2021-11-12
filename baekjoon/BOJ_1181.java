package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1181. 단어정렬
 * @author chaerin yu
 * 2021.11.12
 * 90616kb 400ms
 */
public class BOJ_1181 {

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
				char[] arr1 = o1.toCharArray();
				char[] arr2 = o2.toCharArray();
				if(arr1.length == arr2.length) {
					for (int i = 0; i < arr1.length; i++) {
						if(arr1[i] != arr2[i]) {
							return arr1[i]-arr2[i];
						}
					}
					return 0;
				}
				return arr1.length-arr2.length;
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
