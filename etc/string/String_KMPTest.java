package etc.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm) 
// O(N+M)
/**
 * @author taeheekim
 */
public class String_KMPTest {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		// 실패함수 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		// 패턴포인터를 어디로 옮겨야 하는지 인덱스 저장
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 실패함수를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
	        while(j > 0 && pattern[i] != pattern[j]) {
	        	j = pi[j-1];  // j에서 틀렸으니까 그 전까지는 맞음
	        }
	        // 일치하는 게 있으면 j는 +1 증가 하지만, 그렇지 않으면 j는 그대로 (i는 상관없이 증가)
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	        else pi[i] = 0; // 일치하는 게 없음, j는 그대로 (굳이 안해도 됨)
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLength; ++i) { 
			
			// j위치에서 틀렸으므로 j-1까지는 일치하니까, 해당 위치부터 다시 i와 비교한다.
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) { //두 글자 일치
				if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면 (패턴글자 모두 일치)
					cnt++; // 카운트 증가
					list.add((i+1)-pLength); 
					j=pi[j]; // 패턴이 모두 일치했으므로 (j까지)
				}else { // 패턴 일치 중간 과정(패턴 앞쪽 일치하며 진행 중인 상황)
					j++;
				}
			} else {
				// 아무 거도 안함
			}
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(list);
		}
	}
}