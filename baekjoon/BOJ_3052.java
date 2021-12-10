package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
/**
 * 3052. 나머지
 * 2021.12.10
 * @author user
 * 배열 / set 이용 풀이 2가지
 */
public class BOJ_3052 {

	// array
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int[] freq = new int[42];
//		
//		for (int i = 0; i < 10; i++) {
//			int num = Integer.parseInt(br.readLine());
//			freq[num%42]++;
//		}
//		
//		int cnt = 0;
//		for (int i = 0; i < freq.length; i++) {
//			if(freq[i] != 0) cnt++;
//		}
//		System.out.println(cnt);
//	}
	
	// set
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> freq = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			freq.add(num%42);
		}
		
		System.out.println(freq.size());
	}

}
