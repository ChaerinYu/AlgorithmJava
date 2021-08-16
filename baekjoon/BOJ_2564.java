package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2564. 경비원
 * 첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다. 둘째 줄에 상점의 개수가 주어진다. 
 * 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다. 이어 한 줄에 하나씩 상점의 위치가 주어진다. 
 * 첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다. 
 */
public class BOJ_2564 {

	private static int width;
	private static int height;
	private static int storeNum;
	private static int[][] store;
	private static int myDirection;
	private static int myDistance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		// 입력
		width = Integer.parseInt(input[0]); // 가로
		height = Integer.parseInt(input[1]); // 세로
		
		storeNum = Integer.parseInt(br.readLine()); // 상점 수
		store = new int[storeNum][2];
		
		for (int i = 0; i < storeNum; i++) {
			input = br.readLine().split(" ");
			store[i][0] = Integer.parseInt(input[0]); // 상점 위치한 방향
//			store[i][1] = Integer.parseInt(input[1]); // 거리
			int dist = Integer.parseInt(input[1]); // 거리
			if(store[i][0] == 1) {
				store[i][1] = dist;
			} else if(store[i][0] == 2) {
				store[i][1] = width+height+(width-dist);
			} else if(store[i][0] == 3) {
				store[i][1] = width+height+width+(height-dist);
			} else if(store[i][0] == 4) {
				store[i][1] = width+dist;
			}
		}
		
		input = br.readLine().split(" ");
		myDirection = Integer.parseInt(input[0]); // 동근이 위치한 방향
		myDistance = Integer.parseInt(input[1]); // 동근이 거리
		
		int length = 0, sum = 0;
		// 1 북 2 남 3 서 4 동
		if(myDirection == 1) {
			length = myDistance;
		} else if(myDirection == 2) {
			length = width+height+(width-myDistance);
		} else if(myDirection == 3) {
			length = width+height+width+(height-myDistance);
		} else if(myDirection == 4) {
			length = width+myDistance;
		}
		
		for (int i = 0; i < storeNum; i++) {
			int max=length>store[i][1]?length:store[i][1];
			int min=length<store[i][1]?length:store[i][1];
			
			sum += Math.min(max-min, 2*(width+height)-max+min);
		}
		
		System.out.println(sum);
	}

}
//int answer = 0;
//for (int i = 0; i < storeNum; i++) {
//	// 동근이가 1일 때, 
//	// 상점 1: 동근이와 거리 구하기 (절대값)
//	// 상점 2: 동근이 거리+상점 거리 < (가로-동근 거리)+(가로-상점거리) 구하기
//	// 맞으면 반시계 틀리면 시계
//	// 상점 3: 반시계 방향
//	// 상점 4: 시계 방향
//	if(myDirection == 1) {
//		if(store[i][0] == 1) {
//			answer += Math.abs(myDistance-store[i][1]);
//		}
//		else if(store[i][0] == 2) {
//			answer += Math.min(myDistance+height+store[i][1], (width-myDistance)+height+(width-store[i][1]));
//		}
//		else if(store[i][0] == 3) {
//			answer += myDistance+store[i][1];
//		}
//		else if(store[i][0] == 4) {
//			answer += (width-myDistance)+store[i][1];
//		}
//	}
//	
//	// 동근이가 2일 때,
//	// 상점 1: 동근이 거리+상점 거리 < (가로-동근 거리)+(가로-상점거리) 구하기
//	// 맞으면 시계 틀리면 반시계
//	// 상점 2: 동근이와의 거리 (절대값)
//	// 상점 3: 시계
//	// 상점 4: 반시계
//	else if(myDirection == 2) {
//		if(store[i][0] == 1) {
//			answer += Math.min(myDistance+height+store[i][1], (width-myDistance)+height+(width-store[i][1]));
//		}
//		else if(store[i][0] == 2) {
//			answer += Math.abs(myDistance-store[i][1]);
//		}
//		else if(store[i][0] == 3) {
//			answer += myDistance+(height-store[i][1]);
//		}
//		else if(store[i][0] == 4) {
//			answer += (width-myDistance)+(height-store[i][1]);
//		}
//	}
//
//	// 동근이가 3일 때,
//	// 상점 1: 시계 
//	// 상점 2: 반시계
//	// 상점 3: 동근이와의 거리 (절대값)
//	// 상점 4: 동근이 거리+상점 거리 < (세로-동근 거리)+(세로-상점거리) 구하기
//	// 맞으면 시계 틀리면 반시계
//	else if(myDirection == 3) {
//		if(store[i][0] == 1) {
//			answer += myDistance+store[i][1];
//		}
//		else if(store[i][0] == 2) {
//			answer += (height-myDistance)+store[i][1];
//		}
//		else if(store[i][0] == 3) {
//			answer += Math.abs(myDistance-store[i][1]);
//		}
//		else if(store[i][0] == 4) {
//			answer += Math.min(myDistance+width+store[i][1], (height-myDistance)+width+(height-store[i][1]));
//		}
//	}
//	
//	// 동근이가 4일 때,
//	// 상점 1: 반시계
//	// 상점 2: 시계
//	// 상점 3: 동근이 거리+상점 거리 < (세로-동근 거리)+(세로-상점거리) 구하기
//	// 맞으면 반시계 틀리면 시계
//	// 상점 4: 동근이와의 거리 (절대값)
//	else if(myDirection == 4) {
//		if(store[i][0] == 1) {
//			answer += (width-myDistance)+store[i][1];
//		}
//		else if(store[i][0] == 2) {
//			answer += (height-myDistance)+(width-store[i][1]);
//		}
//		else if(store[i][0] == 3) {
//			answer += Math.min(myDistance+width+store[i][1], (height-myDistance)+width+(height-store[i][1]));
//		}
//		else if(store[i][0] == 4) {
//			answer += Math.abs(myDistance-store[i][1]);
//		}
//	}
//	
//}
//
//System.out.println(answer);