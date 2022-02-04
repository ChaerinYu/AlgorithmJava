package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 2022.02.05
 * 이중우선순위큐
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class 이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 4", "I -1", "I 6", "I 3"};
		System.out.println(Arrays.toString(solution(operations)));
	}

    public static int[] solution(String[] operations) {
    	PriorityQueue<Integer> desc = new PriorityQueue<Integer>();
    	// Collections.reverseOrder()
    	PriorityQueue<Integer> asc = new PriorityQueue<Integer>(new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return -Integer.compare(o1, o2);
    		}
		});
    	for (String operation : operations) {
    		// 명령어, 숫자
			String[] temp = operation.split(" ");
			if("I".equals(temp[0])) {
				// insert
				asc.offer(Integer.parseInt(temp[1]));
			} else if("D".equals(temp[0])) {
				// delete
				if(asc.size() != 0) {
					if("1".equals(temp[1])) {
						asc.poll();
					} else {
						desc.clear();
						desc.addAll(asc);
						System.out.println(desc.peek());
						desc.poll();
						asc.clear();
						asc.addAll(desc);
					}
				}
			}
		}
        int[] answer = new int[2];
        desc.clear();
        desc.addAll(asc);
        if(asc.size() > 0) answer[0] = asc.peek();
        if(desc.size() > 0) answer[1] = desc.peek();
        return answer;
    }
}
