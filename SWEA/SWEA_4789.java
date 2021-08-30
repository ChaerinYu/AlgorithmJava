package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [D3] 4789. 성공적인 공연 기획
 * @author ChaerinYu
 * @date   21/08/30
 * 
 *  몇 명의 사람들을 고용하여 공연이 끝난 후 기립 박수를 바로 하게 하여 실제로 표를 사서 공연을 관람한 사람들이 모두 기립 박수를 하도록 하게 하고 싶다.
 *  최소 몇 명의 사람들을 따로 고용해야 할까?
 *  
 *  이 문자열의 첫 번째 글자가 의미하는 바는 기립 박수를 하고 있는 사람이 아무도 없을 때(0 명일 때) 기립 박수를 하는 사람의 수를 의미한다.
 *  그리고 i번째 글자가 의미하는 바는 기립 박수를 하고 있는 사람이 i-1명 이상일 때 기립 박수를 하는 사람의 수를 의미한다.
 *  가장 마지막 문자는 ‘0’이 아니다. (적어도 한 명의 관객이 있음을 의미한다.)
 *  
 */
public class SWEA_4789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // test case 수
		
		for (int tc = 1; tc <= T; tc++) {
			char[] people = br.readLine().toCharArray();

			int clapPeople = 0; // 박수친 사람 수
			int res = 0; // 고용 알바생 수
			for (int i = 0; i < people.length; i++) {
				// 기립박수 하고 있는 사람보다 박수를 기다리는(?) 사람이 많은 경우
				if(people[i] == '0') continue;
				if(clapPeople < i) {
					res+= i-clapPeople;
					clapPeople += i-clapPeople;
				}
				clapPeople += people[i]-'0';
				
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
}
