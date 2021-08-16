package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2999. 비밀 이메일
 * 정인이가 보내는 메시지는 총 N글자
 * 정인이는 R<=C이고, R*C=N인 R과 C를 고른다. 만약, 그러한 경우가 여러 개일 경우, R이 큰 값을 선택한다.
 * 그 다음, 행이 R개고, 열이 C개인 행렬을 만든다.
 * 이제 메시지를 행렬에 옮긴다. 첫 번째 행의 첫 번째 열부터 C번째 열까지 메시지를 순서대로 옮긴 뒤, 
 * 남은 메시지는 두 번째 행, 세 번째 행,... R번째 행에 첫 번째 행을 채운 방법과 동일한 순서대로 옮긴다.
 * 행렬에 모두 메시지를 옮겼다면, 이 것을 첫 번째 열의 첫 번째 행부터 R번째 행까지 차례대로 읽으면서 다시 받아 적는다. 
 *  메시지는 알파벳 소문자로만 이루어져 있고, 최대 100글자이다.
 */
public class BOJ_2999 {

	private static String encryptMsg; // 상근이가 받은 메시지
	private static int len; // 메시지 길이
	
	private static int R; // 행
	private static int C; // 열
	
	private static char[][] matrix; // 행열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		encryptMsg = br.readLine();
		len = encryptMsg.length();
		
		R = 1; C = len;
		findMatrixSize();
		
		matrix = new char[R][C];
		
		char[] msgArr = encryptMsg.toCharArray();
		int arrIdx = len-1;
		for (int col = C-1; col >= 0; col--) {
			for (int row = R-1; row >= 0; row--) {
				matrix[row][col] = msgArr[arrIdx--];
			}
		}
		
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.print(matrix[row][col]);
			}
		}
		System.out.println();
	}

	private static void findMatrixSize() {
		int tempMaxR = Integer.MIN_VALUE;
		for (int i = 1; i <= len/2; i++) {
			// R<=C, R*C = N, R이 가장 큰 값
			if(len % i == 0 && len/i <= i && tempMaxR<len/i) {
				C = i;
				R = len/C;
				tempMaxR = R;
			}
		}
	}
}
