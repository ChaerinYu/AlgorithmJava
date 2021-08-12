package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 2991. 사나운 개
 * 매일 아침, 개 한마리는 A분동안 공격적이고, B분동안 조용히 쉬고 있다. 
 * 또다른 개는 C분동안 공격적이고, D분동안 조용히 쉰다. 두 개는 이 행동을 계속해서 연속적으로 반복한다.
 * 우체부, 신문배달원, 우유배달원의 도착 시간이 주어졌을 때, 개 몇 마리에게 공격을 받는지 알아내는 프로그램을 작성하시오.
 */
public class BOJ_2991 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		int A = Integer.parseInt(st.nextToken()); // dog1 - attack
		int B = Integer.parseInt(st.nextToken()); // dog1 - rest
		int C = Integer.parseInt(st.nextToken()); // dog2 - attack
		int D = Integer.parseInt(st.nextToken()); // dog2 - rest
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int P = Integer.parseInt(st.nextToken()); // post man
		int M = Integer.parseInt(st.nextToken()); // milk man
		int N = Integer.parseInt(st.nextToken()); // paper man
		
		// 제일 늦게 오는 시간 찾기
		int LAST = Math.max(P, M);
		LAST = Math.max(LAST, N);
		
		dogs.add(0, new Dog(A, 1)); // 1번째 강아지 A시간동안 공격모드(1)로 세팅
		dogs.add(1, new Dog(C, 1)); // 2번째 강아지 C시간동안 공격모드(1)로 세팅
		
		Dog dog1 = dogs.get(0), dog2 = dogs.get(1);
		
		int PA = 0, MA = 0, NA = 0;
		
		for(int i=0; i<=LAST; i++) {
			// 각 배달원 도착할 시간에 강아지 모드는?
			if(i==P) PA = dog1.mode+dog2.mode;
			if(i==M) MA = dog1.mode+dog2.mode;
			if(i==N) NA = dog1.mode+dog2.mode;
			
			// 시간 다 됐을 때, dog mode 변경해준다.
			// 강아지1
			if(dog1.time == 0) {
				if(dog1.mode == 1) { 
					// 강아지가 공격모드였는데 시간이 끝난 경우 
					// 이제 쉴 타임
					dog1.time = B;
					dog1.mode = 0;
				} else {
					// 강아지가 휴식모드였는데 시간이 끝난 경우 
					// 이제 공격 타임
					dog1.time = A;
					dog1.mode = 1;
				}
			}
			// 강아지2
			if(dog2.time == 0) {
				if(dog2.mode == 1) {
					dog2.time = D;
					dog2.mode = 0;
				} else {
					dog2.time = C;
					dog2.mode = 1;
				}
			}

			// 시간 감소
			dog1.time--;
			dog2.time--;
			
		}
		
		System.out.println(PA+"\n"+MA+"\n"+NA);
	}

}
class Dog {
	int time;
	int mode; // 1: attack, -1: rest
	
	public Dog(int time, int mode) {
		this.time = time;
		this.mode = mode;
	}
}