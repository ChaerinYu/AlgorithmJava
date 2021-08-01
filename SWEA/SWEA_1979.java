package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D2] 1979. 어디에 단어가 들어갈 수 있을까
 */
public class SWEA_1979 {
	
	private static int answer = 0;
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("src/SWEA/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			
//			int num = Integer.parseInt(reader.readLine());
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			int map_size = Integer.parseInt(st.nextToken());
			int word_size = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[map_size][map_size];
			
			for(int r=0; r<map_size; r++) {
				st = new StringTokenizer(reader.readLine());
				for(int c=0; c<map_size; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			

			// 아래, 오른쪽 
			int[][] deltas = {{1, 0}, {0, 1}};
			answer = 0;
			
			for(int r=0; r<map_size; r++) {
				for(int c=0; c<map_size; c++) {
					
					// 흰 바탕일 경우, 아래와 오른쪽 확인한다. 
					if(map[r][c] == 1) {

						for(int l=0; l<2; l++) {
							int cnt = 0; //, nextNr = 0, nextNc = 0;
							for(int k=0; k<word_size; k++) {
							
								int nr = r+deltas[l][0]*k;
								int nc = c+deltas[l][1]*k;

								if(nr>=0 && nr<map_size && nc>=0 && nc<map_size && map[nr][nc] == 1) {
									cnt++;
								} else {
									continue;
								}
							}
							if(cnt == word_size) {
								// 이전 배열 값 확인 (1이라면 answer취소)
								int nr1 = r+deltas[l][0]*(-1);
								int nc1 = c+deltas[l][1]*(-1);
								
								if((nr1>=0 && nr1<map_size && nc1>=0 && nc1<map_size && map[nr1][nc1] == 1)) {
//									System.out.println("nr1, nc1: "+nr1+", "+nc1);
									continue;
								}

								// 다음 배열 값 확인 (1이라면 answer 취소)
								int nr2 = r+deltas[l][0]*word_size;
								int nc2 = c+deltas[l][1]*word_size;
								
								if((nr2>=0 && nr2<map_size && nc2>=0 && nc2<map_size && map[nr2][nc2] == 1)) {
//									System.out.println("nr2, nc2: "+nr2+", "+nc2);
									continue;
								}
//								System.out.println("r, c: "+r+", "+c);
								answer++;
								
							}
						}
						
					}
					
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
		
	}
}
