package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1244. 스위치 켜고 끄기
 * 
 * 첫째 줄에는 스위치 개수가 주어진다. 스위치 개수는 100 이하인 양의 정수이다. 
 * 둘째 줄에는 각 스위치의 상태가 주어진다. 켜져 있으면 1, 꺼져있으면 0이라고 표시하고 사이에 빈칸이 하나씩 있다. 
 * 셋째 줄에는 학생수가 주어진다. 학생수는 100 이하인 양의 정수이다. 
 * 넷째 줄부터 마지막 줄까지 한 줄에 한 학생의 성별, 학생이 받은 수가 주어진다. 
 * 남학생은 1로, 여학생은 2로 표시하고, 학생이 받은 수는 스위치 개수 이하인 양의 정수이다. 
 * 학생의 성별과 받은 수 사이에 빈칸이 하나씩 있다.
 */
public class BOJ_1244 {

	private static int SIZE; // 스위치 크기
	private static int[] switchArr; // 스위치
	private static int studentNum; // 학생 수 
	private static int gender; // 학생 성별 
	private static int switchN; // 스위치 번호
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(br.readLine()); // 스위치 크기
		
		switchArr = new int[SIZE]; // 스위치
		String[] tempStr = br.readLine().split(" ");
		for(int i=0; i<SIZE; i++) {
			switchArr[i] = Integer.parseInt(tempStr[i]);
		}
		
		studentNum = Integer.parseInt(br.readLine()); // 학생 수 
		for(int i=0; i<studentNum; i++) {
			String[] tempS = br.readLine().split(" ");
			gender = Integer.parseInt(tempS[0]); // 학생 성별 
			switchN = Integer.parseInt(tempS[1]); // 스위치 번호
			
			// 남학생일 경우 
			if(gender == 1) {
				// 스위치번호 배수 스위치 바꾸기 
				for(int j=switchN; j<=SIZE; j+=switchN) {
					if(switchArr[j-1] == 1) switchArr[j-1] = 0;
					else switchArr[j-1] = 1;
				}
			}
			// 여학생일 경우 
			else {

				int tempN = switchN-1;
				
				// 스위치 번호 기준 좌우대칭 확인
				int left = tempN-1, right = tempN+1;
				while(true) {
					if(left < 0 || right > SIZE-1 || switchArr[left] != switchArr[right]) {
						left++; right--;
						break;
					}

					left--;
					right++;
				}
				
				
				for(int k=left; k<=right; k++) {
					if(switchArr[k] == 1) switchArr[k] = 0;
					else switchArr[k] = 1;
				}
				
			}
		}
        for(int i = 0 ; i < SIZE-1 ; i++) {
			System.out.print(switchArr[i]+ " ");
			if(i%20==19) System.out.println();
		}
        System.out.print(switchArr[SIZE-1]);
		br.close();
	}

}
