package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 2851. 슈퍼마리오
 * 2021.08.28
 * @author ChaerinYu
 * 슈퍼 마리오 앞에 10개의 버섯이 일렬로 놓여져 있다. 이 버섯을 먹으면 점수를 받는다.
 * 마리오는 받은 점수의 합을 최대한 100에 가깝게 만들려고 한다.
 * 첫 버섯을 먹지 않았다면, 그 이후 버섯도 모두 먹을 수 없다.
 * 버섯의 점수가 주어졌을 때, 마리오가 받는 점수를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 마리오가 받는 점수를 출력한다. 만약 100에 가까운 수가 2개라면 (예: 98, 102) 마리오는 큰 값을 선택한다
 */
public class BOJ_2851 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0; // 답
		int prev = 0; // 이전 값
		for (int i = 0; i < 10; i++) {
			int mushroom = Integer.parseInt(br.readLine()); // 버섯
			res += mushroom;
			if(res>100) break; // 100 넘으면 멈춘다.
			prev = res;
		}
		// 만약 100에 가까운 수가 2개라면 (예: 98, 102) 마리오는 큰 값을 선택한다
		// 100과의 거리가 res(for문 마지막 index까지의 합)가 작거나 같을 경우
		if(100-prev>=res-100) {
			System.out.println(res);
		} else {
			System.out.println(prev);
		}
	}
}
