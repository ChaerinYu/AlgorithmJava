package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [D3] 1873. 상호의 배틀필드
 * 
	문자	의미
	.	평지(전차가 들어갈 수 있다.)
	*	벽돌로 만들어진 벽
	#	강철로 만들어진 벽
	-	물(전차는 들어갈 수 없다.)
	^	위쪽을 바라보는 전차(아래는 평지이다.)
	v	아래쪽을 바라보는 전차(아래는 평지이다.)
	<	왼쪽을 바라보는 전차(아래는 평지이다.)
	>	오른쪽을 바라보는 전차(아래는 평지이다.)
	다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.
	 
	문자	동작
	U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
	D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
	L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
	R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
	S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

 */
public class SWEA_1873 {

	private static char[][] map; // game map
	private static int H; // height
	private static int W; // width
	private static int N; // input num
	private static char[] attack;
	
	private static int startR=0, startC=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine()); // test case
		
		for(int tc=1; tc<=test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			// map 크기 입력
			H = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken());
			
			// map 초기화
			map = new char[H][W];
			
			// map 입력
			for(int row=0; row<H; row++) {
				String rowMap = br.readLine();
				
				for(int col=0; col<W; col++) {
					map[row][col] = rowMap.charAt(col);
					// 시작위치 저장
					if(map[row][col] != '.' && map[row][col] != '*' && map[row][col] != '#' && map[row][col] != '-') {
						startR = row;
						startC = col;
					}
				}
			}
			
			// 공격 횟수 입력
			N = Integer.parseInt(br.readLine());
			attack = new char[N];
			
			// 공격 입력
			String attackStr = br.readLine();
			
			for(int a=0; a<N; a++) {
				attack[a] = attackStr.charAt(a);
			}
			
			int nr = startR, nc = startC;
			// 배틀 시작 
			outer: for(int a=0; a<N; a++) {
				// U
				if(attack[a] == 'U') {
					map[nr][nc] = '^';
					if(nr-1>=0 && map[nr-1][nc] == '.') {
						map[nr][nc] = '.';
						nr-=1;
						map[nr][nc] = '^';
					}
				}
				// D
				else if(attack[a] == 'D') {
					map[nr][nc] = 'v';
					if(nr+1<H && map[nr+1][nc] == '.') {
						map[nr][nc] = '.';
						nr+=1;
						map[nr][nc] = 'v';
					}
				}
				// L
				else if(attack[a] == 'L') {
					map[nr][nc] = '<';
					if(nc-1>=0 && map[nr][nc-1] == '.') {
						map[nr][nc] = '.';
						nc-=1;
						map[nr][nc] = '<';
					}
				}
				// R
				else if(attack[a] == 'R') {
					map[nr][nc] = '>';
					if(nc+1<W && map[nr][nc+1] == '.') {
						map[nr][nc] = '.';
						nc+=1;
						map[nr][nc] = '>';
					}
				}
				// S
				else {
					// U
					if(map[nr][nc] == '^') {
						for(int i=nr; i>=0; i--) {
							// 강철 만난 경우 break
							if(map[i][nc] == '#') continue outer;
							// 물 아닌 경우 (평지, 벽돌) 평지(.)로 바꾼다.
							if(map[i][nc] != '-') {
								if(map[i][nc] == '*') {
									map[i][nc] = '.';
									continue outer;
								}
							}
						}
					}
					// D
					else if(map[nr][nc] == 'v') {
						for(int i=nr; i<H; i++) {
							// 강철 만난 경우 break
							if(map[i][nc] == '#') continue outer;
							// 물 아닌 경우 (평지, 벽돌) 평지(.)로 바꾼다.
							if(map[i][nc] != '-') {
								if(map[i][nc] == '*') {
									map[i][nc] = '.';
									continue outer;
								}
							}
						}
					}
					// L
					else if(map[nr][nc] == '<') {
						for(int i=nc; i>=0; i--) {
							// 강철 만난 경우 break
							if(map[nr][i] == '#') continue outer;
							// 물 아닌 경우 (평지, 벽돌) 평지(.)로 바꾼다.
							if(map[nr][i] != '-') {
								if(map[nr][i] == '*') {
									map[nr][i] = '.';
									continue outer;
								}
							}
						}
					}
					// R
					else if(map[nr][nc] == '>') {
						for(int i=nc; i<W; i++) {
							// 강철 만난 경우 break
							if(map[nr][i] == '#') continue outer;
							// 물 아닌 경우 (평지, 벽돌) 평지(.)로 바꾼다.
							if(map[nr][i] != '-') {
								if(map[nr][i] == '*') {
									map[nr][i] = '.';
									continue outer;
								}
							}
						}
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int row=0; row<H; row++) {
				for(int col=0; col<W; col++) {
					System.out.print(map[row][col]);
				}
				System.out.println();
			}
			
		}
	}

}
