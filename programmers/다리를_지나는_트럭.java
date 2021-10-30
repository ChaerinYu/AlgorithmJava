package programmers;

import java.util.LinkedList;

/**
 * 2021.10.30
 * 다리를 지나는 트럭
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class 다리를_지나는_트럭 {

	public static void main(String[] args) {
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(2, 10, truck_weights));
	}

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        LinkedList<int[]> trucks = new LinkedList<int[]>(); // 트럭 리스트
        LinkedList<int[]> bridges = new LinkedList<int[]>(); // 다리
        
        for (int truck : truck_weights) {
			trucks.add(new int[] {truck, 0});
		}

        while(!trucks.isEmpty() || !bridges.isEmpty()) {
        	int size = bridges.size();
        	// 다리 위에 있던 트럭들 이동
        	for (int i = 0; i < size; i++) {
        		int[] now = bridges.get(i);
        		bridges.set(i, new int[] {now[0], now[1]+1});
			}
        	// 다리 지나간 경우 빼주기
        	if(!bridges.isEmpty()) {
        		int[] now = bridges.getFirst();
        		if(now[1] >= bridge_length) {
        			bridges.removeFirst();
        		}
        	}
        	
        	// 트럭을 다리 위로 올리기
        	if(!trucks.isEmpty()) {
        		int[] now = trucks.peek();

        		// 다리에 공간 있는지 체크
        		// 무게 가능한지 체크
        		if(bridges.size()+1 <= bridge_length && ableWeight(now, bridges, weight)) {
        			int[] temp = trucks.poll();
//        			bridges.offer(new int[] {temp[0], temp[1]+1});
        			bridges.offer(temp);
        		}
        	}
        	
        	answer++;
        }
		return answer;
        
        /*
        int tWeight = weight;
        for (int i = 0; i < truck_weights.length; ) {
        	
    		int size = bridges.size();
    		// 다리위에 있던 트럭들 한칸씩 이동
    		while(size-->0) {
        		int[] now = bridges.poll();
        		if(now[1]+1 > bridge_length) {
        			tWeight += now[0]; // 다리 탈출
        			continue;
        		}
    			// 아직 다리 못건넜으면 다시 queue에 넣는다.
    			bridges.offer(new int[] {now[0], now[1]+1});
    		}
        	
        	int w = truck_weights[i];
			
        	if(tWeight-w >= 0) {
        		tWeight -= w;
        		bridges.offer(new int[] {w, 0});
        		i++;
        	}

        	answer++;
			
		}
        
        return answer;
        */
    }

    /**
     * 무게 가능한지 계산
     * @param now 다리에 올리려고 하는 트럭
     * @param bridges 다리
     * @param weight 다리가 버틸 수 있는 무게
     * @return
     */
	private static boolean ableWeight(int[] now, LinkedList<int[]> bridges, int weight) {
		int totalWeight = 0;
		for (int i = 0; i < bridges.size(); i++) {
			totalWeight += bridges.get(i)[0];
		}
		if(totalWeight + now[0] > weight) {
			return false;
		}
		return true;
	}
}
