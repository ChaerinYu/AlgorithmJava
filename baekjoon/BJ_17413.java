package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 17413. 단어 뒤집기 2
 * 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
 * 태그는 ('<'로 시작해서 '>'로 끝남) 그대로 유지
 */
public class BJ_17413 {
	
	private static final String regExp = "\\W";
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/SWEA/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
//		String[] input = reader.readLine().split(regExp);
		String input = reader.readLine();

		boolean isTag = false;
		int tempIdx = 0;
		System.out.println(input.length());
		
		if(input.contains("<")) {
//			for(int i=0; i<input.length(); i++) {
			int i=0;
			while(i<input.length()) {
				System.out.println(1);
				if(input.charAt(i) == '<') {
					isTag = true;
					sb.append("<");
				}

				// tag 내부 text는 반전 안 되도록 한다. 
				if(isTag) {
					sb.append(input.charAt(i));
					if(input.charAt(i) == '>') {
						isTag = false;
						sb.append(">");
					}
					i++;
				}
				// tag 내부 아닐 때에는 띄어쓰기 단위로 단어를 잘라서 reverse해준다.
				else {
					
					// 단어별로 String 나눈다. 
					String[] notTagName = reader.readLine().split(" ");
					System.out.println("dd: "+notTagName.length);
					
					// 각 단어 별로 reverse해준다.
					for(int j=0; j<notTagName.length; j++) {
						String tempStr = notTagName[j];
						for(int k=0; k<tempStr.length(); k++) {
							sb.append(tempStr.charAt(tempStr.length()-1-k));
						}
					}
					
					i+= notTagName.length;
					
				}
				
			}
		} else {

			// 단어별로 String 나눈다. 
			String[] notTagName = reader.readLine().split(" ");
			
			// 각 단어 별로 reverse해준다.
			for(int j=0; j<notTagName.length; j++) {
				String tempStr = notTagName[j];
				for(int k=0; k<tempStr.length(); k++) {
					sb.append(tempStr.charAt(tempStr.length()-1-k));
				}
			}
			
		}
		
		System.out.println(sb);

		/*
		// 우선 <로 문자열을 나눈다.
		StringTokenizer stk = new StringTokenizer(reader.readLine(),"<");
//		System.out.println(stk.countTokens());
		
		while(stk.hasMoreTokens()) {
			String temp = stk.nextToken();
			boolean isTag = false;
			int tempIdx = 0;
			sb.append(temp);
			if(temp.contains("<")) {
				sb.append("<");
				isTag = true;
			}
			
			for(int i=0; i<temp.length(); i++) {
				// <의 짝인 >를 발견하면 print넘어가고 그 다음(뒷 string)은 반대로 출력해주도록 한다. 
				if(temp.charAt(i) == '>') {
					isTag = false;
					tempIdx = i;
					sb.append(">");
					continue;
				}
				
				if(isTag)
					System.out.print(temp.charAt(i));
				else {
					String[] subStr = temp.substring(tempIdx, temp.length()).split(" ");
					
					for(int s=0; s<subStr.length; s++) {
						for(int j=subStr[s].length()-1; j>=0; j--) {
							sb.append(subStr[s].charAt(j));
//							System.out.print(subStr[s].charAt(j));
						}
						if(s!=subStr.length-1)
							sb.append("\n");
//							System.out.print(" ");
					}
					isTag = false;
					break;
				}
			}
		}
		System.out.println(sb);
			*/
		
		/*
		String[] input = reader.readLine().split(regExp);
		for(int i=0 ; i<input.length; i++) {
			System.out.println(input[i]);
		}
		*/
		/*
		for(int i=0; i<input.length; i++) {
//			StringTokenizer stk = new StringTokenizer(input[i],"<>", true);
			
			if(input[i].startsWith("<")) {
				System.out.print(input[i].substring(0, input[i].indexOf(">")));
			}
			
			char firstLetter = input[i].charAt(0);
			
			if(firstLetter == '<') {
				// tag일 때 
				System.out.print(input[i]);
			} else {
				// tag 아닐 때 
				for(int j=input[i].length()-1; j>=0; j--) {
					System.out.print(input[i].charAt(j));
				}
			}
			System.out.print(" ");
		}
		*/
	}

}
