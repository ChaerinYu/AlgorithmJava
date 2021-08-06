package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D4] 1861. 정사각형 방
 */
public class SWEA_1861 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case 수
		
		int N = 0; // 방의 크기
		int move = 0; // 이동 횟수
		int roomNo = 0; // 시작된 방 숫자
		int[][] rooms = null;
		
		StringTokenizer st = null;
		StringBuilder sb = null;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			move = 1;
			roomNo = Integer.MAX_VALUE;
			
			rooms = new int[N][N];
			
			// 방 숫자 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					rooms[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb = new StringBuilder();
			// 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 방 크기 - 최대 움직임 수가 방 번호보다 작다면 넘어간다.
					if(N*N-move < rooms[r][c]) continue;
					
					int nr = r, nc = c; // 현재 위치 저장
					int temp = 0; // 이동 횟수 임시 저장
					while(true) {
						temp++;
						int tempRoom = rooms[nr][nc];
						// 사방에 이동할 곳이 없거나 방 숫자가 N*N과 동일하다면 break
						// break하기 전, 기존 move보다 큰 경우, 변수를 갱신한다.
						if(nr-1>=0 && rooms[nr-1][nc]==tempRoom+1) {
							nr = nr-1;
							continue;
						} else if(nr+1<N && rooms[nr+1][nc]==tempRoom+1) {
							nr = nr+1;
							continue;
						} else if(nc-1>=0 && rooms[nr][nc-1]==tempRoom+1) {
							nc = nc-1;
							continue;
						} else if(nc+1<N && rooms[nr][nc+1]==tempRoom+1) {
							nc = nc+1;
							continue;
						} else {
							if(temp > move || (temp==move && roomNo > rooms[r][c])) {
								move = temp;
								roomNo = rooms[r][c];
							}
							break;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(roomNo).append(" ").append(move);
			System.out.println(sb);
		}
	}

}
