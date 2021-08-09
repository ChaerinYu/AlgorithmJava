package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * [D2] 1228. [S/W 문제해결 기본] 8일차 - 암호문1
	첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
	두 번째 줄 : 원본 암호문
	세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
	네 번째 줄 : 명령어
	위와 같은 네 줄이 한 개의 테스트 케이스이며, 총 10개의 테스트 케이스가 주어진다.

 */
public class SWEA_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src/input_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0 ;  // 암호문 길이
		LinkedList<String> encStr = null; // 암호문
		int commandN = 0; // 명령어 개수
		ArrayList<Command> commList = null; // 명령어
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine()); // 암호문 길이
			encStr = new LinkedList<String>();
			commList = new ArrayList<Command>(); // 명령어
			
			st = new StringTokenizer(br.readLine(), " ");
			int ii = 0;
			while(st.hasMoreTokens()) {
				if(ii>=10) break; // 10개만 봐도 충분
				encStr.add(ii++, st.nextToken());
			}
			
			commandN = Integer.parseInt(br.readLine()); // 명령어 수
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<commandN; i++) {
				char I = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				String[] s = new String[y];
				for(int j=0; j<y; j++) {
					s[j] = st.nextToken();
				}
				commList.add(new Command(I, x, y, s));
			}
			
			for(int i=0; i<commList.size(); i++) {
				Command c = commList.get(i);
				for(int j=0; j<c.y && j+c.x<10; j++) {
					encStr.pollLast();
					encStr.add(j+c.x, c.s[j]);
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				System.out.print(encStr.get(i)+ " ");
			}
			System.out.println();
		}
	}

}

// 명령어 클래스
class Command {
	char I; // 삽입
	int x; // 위치
	int y; // 숫자 개수
	String[] s; // 덧붙일 숫자
	
	public Command() {
		super();
	}

	public Command(char i, int x, int y, String[] s) {
		I = i;
		this.x = x;
		this.y = y;
		this.s = s;
	}

	public char getI() {
		return I;
	}

	public void setI(char i) {
		I = i;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String[] getS() {
		return s;
	}

	public void setS(String[] s) {
		this.s = s;
	}
}
