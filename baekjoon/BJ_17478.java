package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 17478. ����Լ��� ������?
 */
public class BJ_17478 {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static void answer(String underbar, int N) throws IOException {
		if(N < 0) return;
		
		bw.write(underbar+"\"����Լ��� ������?\"\n");
		if(N == 0) {
			bw.write(underbar+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
		} else {
			bw.write(underbar+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
			bw.write(underbar+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
			bw.write(underbar+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		}
		answer(underbar+"____", N-1);
		bw.write(underbar+"��� �亯�Ͽ���.\n");
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		
		answer("", N);
		
//		bw.write
		bw.close();
	}

}
