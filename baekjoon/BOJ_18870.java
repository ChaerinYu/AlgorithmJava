package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 2021.12.16
 * 18870. 좌표 압축
 * @author user
 * Arrays.sort도 되지만 merge sort도 가능
 */
public class BOJ_18870 {

//	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		int[] copy = arr.clone();
//		Arrays.sort(copy);
		split(copy, 0, N-1);
//		System.out.println(Arrays.toString(copy));
//		System.out.println(Arrays.toString(arr));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0;
		for (int i = 0; i < copy.length; i++) {
			if(!map.containsKey(copy[i]))
				map.put(copy[i], cnt++);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	// 쪼개기
	private static int[] split(int[] array, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			
			split(array, left, mid);
			split(array, mid+1, right);
			return merge(array, left, mid, right);
		}
		return null;
	}
	// 합치기
	private static int[] merge(int[] array, int left, int mid, int right) {
		// 쪼개진 값 기준으로 배열 생성
	    int[] L = Arrays.copyOfRange(array, left, mid + 1);
	    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
	 
	    int i = 0, j = 0, k = left;
	    int lLen = L.length, rLen = R.length;
	 
	    // L과 R 정렬하면서 합치기
	    while (i < lLen && j < rLen) {
	        if (L[i] <= R[j])
	            array[k] = L[i++];
	        else
	            array[k] = R[j++];
	        k++;
	    }
	 
	    // L에 남은 값들 array로 옮겨주기
	    while (i < lLen) 
	        array[k++] = L[i++];
	    
	    // R에 남은 값들 array로 옮겨주기
	    while (j < rLen) 
	        array[k++] = R[j++];
		return array;
	}
}
