package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
  [D3] 1234. [S/W 문제해결 기본] 10일차 - 비밀번호
 */
class SWEA_1234
{
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int tc = Integer.parseInt(reader.readLine());

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			String[] input = reader.readLine().split(" ");
            
			int size = Integer.parseInt(input[0]);
			
			String[] strMap = input[1].split("");;
			ArrayList<String> map = new ArrayList<>();
			for(int i=0; i<size; i++) {
				map.add(strMap[i]);
			}
			
			int i=1;
			while(true) {
				if(map.get(i).equals(map.get(i-1))) {
					map.remove(i);
					map.remove(i-1);
					i = 1;
				} else {
					i++;
				}
				
				if(i>=map.size()) break;
			}
            
            System.out.print("#"+test_case+ " ");
            for(int k=0; k<map.size(); k++) {
            	System.out.print(map.get(k));
            }
            System.out.println();
            
		}
	}
}

