package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 19635. 배열 돌리기 3
 * 크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.
 * 1번 연산은 배열을 상하 반전시키는 연산이다.
 * 2번 연산은 배열을 좌우 반전시키는 연산이다.
 * 3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
 * 4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
 * 5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 
 * 5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.
 * 6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.
 */
public class BOJ_16935 {

	private static int N, M; // map 배열 크기 가로 세로
	private static int R; // 연산 수
	
	private static int[][] map;
	
	private static int flag; // map -1: NxM? 1: MxN?
	
	private static int[] command; // 연산

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		map = new int[N+1][M+1];
		// map 값 입력
		StringTokenizer st = null; 
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		input = br.readLine().split(" ");
		command = new int[R];
		for (int i = 0; i < R; i++) {
			command[i] = Integer.parseInt(input[i]);
			
			switch(command[i]) {
				case 1:
					changeUpDown();
					break;
				case 2:
					changeLeftRight();
					break;
				case 3:
					change90Right();
					break;
				case 4:
					change90Left();
					break;
				case 5:
					rotateClock();
					break;
				case 6:
					rotateCounterClock();
					break;
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				System.out.print(map[r][c]+ " ");
			}
			System.out.println();
		}
	}

	// 1번 상하
	private static void changeUpDown() {
		int temp = 0; 
		
		for (int r = 1; r <= N/2; r++) {
			for (int c = 1; c <= M; c++) {
				temp = map[r][c];
				map[r][c] = map[N-(r-1)][c];
				map[N-(r-1)][c] = temp;
			}
		}
	}
	
	// 2번 좌우
	private static void changeLeftRight() {
		int temp = 0;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M/2; c++) {
				temp = map[r][c];
				map[r][c] = map[r][M-(c-1)];
				map[r][M-(c-1)] = temp;
			}
		}
	}
	
	// 3번 시계방향 90
	private static void change90Right() {
		int prevN = N;
		swap(); // N<->M

		int[][] newMap = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				newMap[r][c] = map[prevN-(c-1)][r];
			}
		}
		map = newMap;
	}
	
	// 4번 반시계방향 90
	private static void change90Left() {
		int prevM = M;
		swap(); // N<->M

		int[][] newMap = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				newMap[r][c] = map[c][prevM-(r-1)];
			}
		}
		map = newMap;
	}
	
	// 5번 4구역 나눠서 1->2->3->4->1
	private static void rotateClock() {
		int halfN = N/2;
		int halfM = M/2;
		
		int[][] newMap = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				
				// 1/2구역
				if(r<=halfN) {
					if(c<=halfM) { // 1구역: 4구역에서 갖고 온다.
						newMap[r][c] = map[r+halfN][c];
					} else { // 2구역: 1구역에서 갖고 온다.
						newMap[r][c] = map[r][c-halfM];
					}
				}
				// 3/4구역
				else {
					if(c<=halfM) { // 4구역: 3구역에서 갖고 온다.
						newMap[r][c] = map[r][c+halfM];
					} else { // 3구역: 2구역에서 갖고 온다.
						newMap[r][c] = map[r-halfN][c];
					}
				}
			}
		}
		map = newMap;
	}
	
	// 6번 4구역 나눠서 1->4->3->2->1
	private static void rotateCounterClock() {
		int halfN = N/2;
		int halfM = M/2;
		
		int[][] newMap = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				
				// 1/2구역
				if(r<=halfN) {
					if(c<=halfM) { // 1구역: 2구역에서 갖고 온다.
						newMap[r][c] = map[r][c+halfM];
					} else { // 2구역: 3구역에서 갖고 온다.
						newMap[r][c] = map[r+halfN][c];
					}
				}
				// 3/4구역
				else {
					if(c<=halfM) { // 4구역: 1구역에서 갖고 온다.
						newMap[r][c] = map[r-halfN][c];
					} else { // 3구역: 4구역에서 갖고 온다.
						newMap[r][c] = map[r][c-halfM];
					}
				}
			}
		}
		map = newMap;
	}
	
	// N <-> M
	private static void swap() {
		flag = -flag;
		int temp = N;
		N = M;
		M = temp;
	}
}
