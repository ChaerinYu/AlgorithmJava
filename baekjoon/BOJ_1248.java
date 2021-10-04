package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2021.10.4
 * study week 5
 * 1248 맞춰봐
 * @author ChaerinYu
 *
 */
public class BOJ_1248 {

	static int N; // 수열의 크기, N은 10보다 작거나 같은 자연수
	static char[][] sign; // 부호 배열, N(N+1)/2 길이의 문자열
	
	static boolean done = false; // 답 여러가지 인 경우 고려해서 출력한 경우 넘어가도록 한다.
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 수열의 크기
		sign = new char[N][N];
		char[] tempArr = br.readLine().toCharArray(); // 부호 배열 -> N, N-1, N-2, .. 하나씩 줄어듦
		
		// 부호 입력
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				sign[i][j] = tempArr[idx++];
			}
//			System.out.println(Arrays.toString(sign[i]));
		}
		
		int[] nums = new int[N];
		done = false;
		recursion(nums, 0);
		
		System.out.print(sb);
	}


	/**
	 * 
	 * @param nums 규현이가 뽑았다고 예상되는 숫자들 (index 위치까지 유효)
	 * @param index 몇 번째 배열까지 고려했는지
	 */
	private static void recursion(int[] nums, int index) {
		if(done) return; // 이미 답 출력한 경우 return
		if(index == N) {
			for (int i = 0; i < N; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			done = true;
			return;
		}
		
		int s = (sign[index][index]=='-') ? -1:1; // index번째에 올 숫자의 부호
		for (int i = 0; i <= 10; i++) {
			// nums[index]에 값 입력
			nums[index] = i*s;
			
			// nums[index]에 들어가는 값이 정당한지 체크
			if(!able(nums, index)) continue;
			
			recursion(nums, index+1);
		}
	}
	/**
	 * nums[index]에 들어가는 값이 정당한지 체크. 만족하는 경우 배열에 입력
	 * @param nums 배열
	 * @param index
	 * @return true: 정당
	 */
	static boolean able(int[] nums, int index) {
		int sum = 0;
		for (int i = index; i >= 0; i--) {
			sum += nums[i];
			char s = ((sum < 0) ? '-' : ((sum > 0) ? '+' : '0')); 
			if(s != sign[i][index]) return false;
		}
		return true;
	}
}
