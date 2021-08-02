package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���� 1244. ����ġ �Ѱ� ����
 * 
 * ù° �ٿ��� ����ġ ������ �־�����. ����ġ ������ 100 ������ ���� �����̴�. 
 * ��° �ٿ��� �� ����ġ�� ���°� �־�����. ���� ������ 1, ���������� 0�̶�� ǥ���ϰ� ���̿� ��ĭ�� �ϳ��� �ִ�. 
 * ��° �ٿ��� �л����� �־�����. �л����� 100 ������ ���� �����̴�. 
 * ��° �ٺ��� ������ �ٱ��� �� �ٿ� �� �л��� ����, �л��� ���� ���� �־�����. 
 * ���л��� 1��, ���л��� 2�� ǥ���ϰ�, �л��� ���� ���� ����ġ ���� ������ ���� �����̴�. 
 * �л��� ������ ���� �� ���̿� ��ĭ�� �ϳ��� �ִ�.
 */
public class BOJ_1244 {

	private static int SIZE; // ����ġ ũ��
	private static int[] switchArr; // ����ġ
	private static int studentNum; // �л� �� 
	private static int gender; // �л� ���� 
	private static int switchN; // ����ġ ��ȣ
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(br.readLine()); // ����ġ ũ��
		
		switchArr = new int[SIZE]; // ����ġ
		String[] tempStr = br.readLine().split(" ");
		for(int i=0; i<SIZE; i++) {
			switchArr[i] = Integer.parseInt(tempStr[i]);
		}
		
		studentNum = Integer.parseInt(br.readLine()); // �л� �� 
		for(int i=0; i<studentNum; i++) {
			String[] tempS = br.readLine().split(" ");
			gender = Integer.parseInt(tempS[0]); // �л� ���� 
			switchN = Integer.parseInt(tempS[1]); // ����ġ ��ȣ
			
			// ���л��� ��� 
			if(gender == 1) {
				// ����ġ��ȣ ��� ����ġ �ٲٱ� 
				for(int j=switchN; j<=SIZE; j+=switchN) {
					if(switchArr[j-1] == 1) switchArr[j-1] = 0;
					else switchArr[j-1] = 1;
				}
			}
			// ���л��� ��� 
			else {

				int tempN = switchN-1;
				
				// ����ġ ��ȣ ���� �¿��Ī Ȯ��
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
