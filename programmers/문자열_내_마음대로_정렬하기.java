package programmers;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 21.10.26
 * 문자열 내 마음대로 정렬하기
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class 문자열_내_마음대로_정렬하기 {

	public static void main(String[] args) {
		String[] strings = new String[] {"abce", "abcd", "cdx"};
		System.out.println(Arrays.toString(solution(strings, 2)));
	}
	
    public static String[] solution(String[] strings, int n) {
    	Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// n index 문자 동일한 경우
				if(o1.charAt(n)==o2.charAt(n)) {
					// n index 이전 문자열 비교
					for (int i = 0; i < n; i++) {
						if(o1.charAt(i)!=o2.charAt(i)) {
							return Integer.compare(o1.charAt(i), o2.charAt(i));
						}
					}
					// n index 이후 문자열 비교
					int temp = n;
					while(o1.charAt(temp)==o2.charAt(temp)) {
						temp = temp+1;
					}
					return Integer.compare(o1.charAt(temp), o2.charAt(temp));
				}
				
				return Integer.compare(o1.charAt(n), o2.charAt(n));
			}
		});
        return strings;
    }
}

/**


	// n index를 문자열 앞으로 이동하여 sort한다음 1번째 문자열부터 재입력하는 방법
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }


**/
/**


  public String[] solution(String[] strings, int n) {
      Arrays.sort(strings, new Comparator<String>(){
          @Override
          public int compare(String s1, String s2){
              if(s1.charAt(n) > s2.charAt(n)) return 1;
              else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
              else if(s1.charAt(n) < s2.charAt(n)) return -1;
              else return 0;
          }
      });
      return strings;
  }

**/