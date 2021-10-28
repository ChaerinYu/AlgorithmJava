package programmers;

import java.util.Arrays;

/**
 * 21.10.28
 * 2021 카카오 채용연계형 인턴십
 * 거리두기 확인하기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
public class 거리두기_확인하기2 {

	public static void main(String[] args) {
		String[][] places = new String[5][5];
		places[0] = new String[] {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"};
		places[1] = new String[] {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"};
		places[2] = new String[] {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"};
		places[3] = new String[] {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"};
		places[4] = new String[] {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"};
		
		System.out.println(Arrays.toString(solution(places)));
	}
	
	static int[] answer;
	static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	

    public static int[] solution(String[][] places) {
        answer = new int[5];
        
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
			
        	char[][] arr = new char[5][5];
        	for (int j = 0; j < places[i].length; j++) {
				arr[j] = places[i][j].toCharArray();
			}
			
        	
        	flag = false;
			int nr = 0, nc = 0;
	        outer: 
        	for (int m = 0; m < 5; m++) {
				for (int n = 0; n < 5; n++) {
					// 응시자 근처 탐색
					if(arr[m][n] == 'P') {
						
						// 상하 좌우
						for (int l = 0; l < delta.length; l++) {
							nr = m+delta[l][0];
							nc = n+delta[l][1];

							if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
							
							if(arr[nr][nc] == 'P') {
								flag = true;
								break outer;
							}
							
						}
						
					}
					// 빈 테이블 근처 탐색
					else if(arr[m][n] == 'O') {

						int cnt = 0;
						// 상하 좌우
						for (int l = 0; l < delta.length; l++) {
							nr = m+delta[l][0];
							nc = n+delta[l][1];

							if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
							
							if(arr[nr][nc] == 'P') {
								cnt++;
							}
						}
						if(cnt>1) {
							flag = true;
							break outer;
						}
					}
					
				} // n end
			} // m end
        	
        	if(flag) {
				answer[i] = 0;
        	} else {
        		answer[i] = 1;
        	}
		}
        
        return answer;
    }

}
