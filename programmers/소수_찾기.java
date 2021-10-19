package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021.10.19
 * @author Chaerin Yu
 * 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class 소수_찾기 {

	public static void main(String[] args) {
		System.out.println(solution("011"));
	}
	
	static Set<Integer> set = new HashSet<Integer>();
	
	public static int solution(String numbers) {
        perm("", numbers.toCharArray(), 0, numbers.length(), new boolean[numbers.length()]);
        
        return set.size();
    }

	private static boolean isPrime(int temp) {
		if(temp<2) return false;
		int sqrt = (int) Math.sqrt(temp);
//		System.out.println(temp);
		// 소수 거르기
		for (int i = 2; i <= sqrt; i++) {
			if(temp % i == 0) return false;
		}
		return true;
	}
	
	private static void perm(String num, char[] arr, int cnt, int n, boolean[] visited) {
		if(cnt == n) {
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			if(isPrime(Integer.parseInt(num+arr[i]))) {
				set.add(Integer.parseInt(num+arr[i]));
			}
			perm(num+arr[i], arr, cnt+1, n, visited);
			visited[i] = false;
		}
	}
}
