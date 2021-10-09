package programmers;

public class 소수_만들기 {
	class Solution {
	    public int solution(int[] nums) {
	        int len = nums.length;
	        int answer = 0, sum;
	        boolean isPrime;
	        for(int k=0; k< len-2; k++) {
	            for(int i=k+1; i<len-1; i++) {
	                for(int j=i+1; j<len; j++) {
	                    sum = nums[k]+nums[i]+nums[j];
	                    isPrime = true;
//	                    for(int m=2; m<sum; m++) {
//	                        if(sum%m == 0) isPrime = false;
//	                    }
	                    for(int m=2; m<=Math.sqrt(sum); m++) {
	                    	if(sum%m == 0) isPrime = false;
	                    }
	                    if(isPrime) answer++;
	                }
	            }
	        }

	        return answer;
	    }
	    
	}
}
