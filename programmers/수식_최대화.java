package programmers;

import java.util.ArrayList;

/**
 * 21.10.26
 * 2020 카카오 인턴십 수식 최대화
 * @author ChaerinYu
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */
public class 수식_최대화 {

	private static final String[] oper = new String[]{"*", "+", "-"};
	private static int[] order; // 연산자 우선순위
	private static boolean[] visited; // 연산자 우선순위 배열만들 때 사용되는 boolean 배열
	
	private static long answer;
	
	// 연산자/피연산자 list
	private static ArrayList<Long> expNumbersList;
	private static ArrayList<String> expOpersList;
	
	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
	}
	
	// 연산자 우선순위
	/**
	 * 순열 가능한 연산자 우선순위 만들기
	 * @param index
	 */
	public static void perm(int index) {
		if(index==3) {
//			System.out.println(Arrays.toString(order));
			// 계산하기
			calc(order);
			
			return;
		}
		
		for (int i = 0; i < oper.length; i++) {
			if(visited[i]) continue;
			order[index] = i;
			visited[i] = true;
			perm(index+1);
			visited[i] = false;
		}
	}
	
	// operator에 맞게 계산하기
	private static long calculate(long n1, long n2, String operator) {
		if("*".equals(operator)) return n1*n2;
		else if("+".equals(operator)) return n1+n2;
		else return n1-n2;
	}
	
	/**
	 * 연산자 우선순위에 따른 계산식 계산하기
	 * @param orderList 연산자 우선순위
	 */
	public static void calc(int[] orderList) {
		
		// 숫자(피연산자) list 복사해오기
		ArrayList<Long> nList = new ArrayList<Long>();
		for (Long ll : expNumbersList) {
			nList.add(ll);
		}
		// 연산자 list 복사해오기
		ArrayList<String> oList = new ArrayList<String>();
		for (String string : expOpersList) {
			oList.add(string);
		}
		
		for (int i = 0; i < orderList.length; i++) {
			// 연산자
			String operator = oper[orderList[i]];
			for (int j = 0; j < oList.size(); j++) {
				
				// 우선순위 연산자와 동일한 경우
				if(operator.equals(oList.get(j))) {
					long result = calculate(nList.get(j), nList.get(j+1), operator);
					nList.set(j, result);
					nList.remove(j+1);
					oList.remove(j);
					j--;
				}
				
			}
		}
		
		long temp = nList.get(0);
		// 음수일 경우 절대값
		if(temp < 0) temp = -temp;
		if(temp > answer) answer = temp;
	}
	
    public static long solution(String expression) {
        answer = 0;

//		expNumbers = expression.split("[^0-9]");
//		expOpers = expression.replaceAll("[0-9]", "").split("");
        // 연산자(숫자) list 만들기
		String[] expNumbers = expression.split("[^0-9]");
		expNumbersList = new ArrayList<Long>();
		for (String ll : expNumbers) {
			expNumbersList.add(Long.valueOf(ll));
		}
		// 피연산자 list 만들기
		String[] expOpers = expression.replaceAll("[0-9]", "").split("");
		expOpersList = new ArrayList<String>();
		for (String str : expOpers) {
			expOpersList.add(str);
		}
		
		// 순열만들기
		order = new int[3];
		visited = new boolean[3];
		perm(0);
        
		
//        System.out.println(Arrays.toString(expression.split("[^0-9]")));
//        System.out.println(Arrays.toString(expression.replaceAll("[0-9]", "").split("")));
        
        return answer;
    }
}
