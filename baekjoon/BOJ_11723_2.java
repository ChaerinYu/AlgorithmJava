package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Study week 1
 * 11723. 집합
 * @author ChaerinYu
 * ^: xor 
 * &: and 
 * |: or 
 * ~: not
 */
public class BOJ_11723_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 연산의 수
		StringTokenizer st = null;
		int flag = 0;
		
		StringBuilder sb = new StringBuilder();
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
					flag = flag | 1<<x;
					break;
				// S에서 x를 제거한다.
				case "remove": 
					if((flag & 1<<x) != 0)
						flag = flag ^ 1<<x;
					break;
				// S에 x가 있으면 1을, 없으면 0을 출력한다. 
				case "check":
					if((flag & 1<<x) != 0) sb.append(1).append("\n"); //System.out.println(1);
					else sb.append(0).append("\n"); //System.out.println(0);
					break;
				// S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다.
				case "toggle":
					flag = flag ^ 1<<x;
					break;
				case "all":
					flag = ~flag;
					break;
				case "empty":
					flag = 0;
					break;
			}
		}
		System.out.println(sb);
	}
}
