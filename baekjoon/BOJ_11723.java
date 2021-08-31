package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** Study week 1
 * 11723. 집합
 * @author ChaerinYu
 * 시간초과
 */
public class BOJ_11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] S = new int[21]; // 1~20
		
		int N = Integer.parseInt(br.readLine()); // 연산의 수
		StringTokenizer st = null;
		// 연산 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken(); // 연산
			int x = 0; // 숫자
			if(!command.equals("all") && !command.equals("empty")) {
				x = Integer.parseInt(st.nextToken());
			}
			
			switch(command) {
				// S에 x추가. 이미 있으면 무시
				case "add": 
					S[x] = 1;
					break;
				// S에서 x를 제거한다.
				case "remove": 
					S[x] = 0;
					break;
				// S에 x가 있으면 1을, 없으면 0을 출력한다. 
				case "check":
					System.out.println(S[x]);
					break;
				// S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다.
				case "toggle":
					S[x] = S[x]==0?1:0;
					break;
				case "all":
					Arrays.fill(S, 1);
					break;
				case "empty":
					Arrays.fill(S, 0);
					break;
			}
		}
	}
}
