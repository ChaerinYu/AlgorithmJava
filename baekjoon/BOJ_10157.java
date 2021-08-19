package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10157. 자리배정
 * @author user
 * 문제 이미지가 훼이크임 ㅡㅡㅠㅠ
 */
public class BOJ_10157 {

	static int R;
	static int C;
	static int waitNum; // 대기번호
	
	static int[][] seats; // 좌석
	static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 반시계방향
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		C = Integer.parseInt(input[0]);
		R = Integer.parseInt(input[1]);
		waitNum = Integer.parseInt(br.readLine());
		
		// 좌석을 배정할 수 없는 경우
		if(R*C < waitNum) {
			System.out.println(0);
			return;
		}

		seats = new int[R+1][C+1]; // 0열 0행 안 씀
		int cnt=1;
		    
	    int x = 1;
		int y = 1;
		int dir= 0;
		while(cnt != waitNum) {
			
			seats[x][y]=cnt;
			int nx = x+d[dir][0];
			int ny = y+d[dir][1];
			
			if(nx<1 || ny<1 || nx>R || ny>C || seats[nx][ny] !=0) {
				dir = (dir+1)%4;	
				nx = x+d[dir][0];
				ny = y+d[dir][1];
			}
			
			x=nx;
			y=ny;
			
			cnt++;
	    }
		System.out.println(y+" "+x);
		
	}

}
