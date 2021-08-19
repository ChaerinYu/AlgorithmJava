package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 2021.08.17
 * greedy algorithm
 * 활동 선택 activity selection problem
 * 가능한 많은 회의를 열기 위한 회의실 배정
 * @author user
 *
 */
public class MeetingRoomTest_Greedy {

	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			
			int value = this.end - o.end; // overflow 고려 필요
			// 여기서는 시간이 음수가 들어올 수 없어서 그냥 뺄셈 이용함
			
			if(value != 0) { // 종료 시간이 다른 경우
				return value;
			}
			
			// 종료 시간이 같다면 시작 시간이 빠른 순서로
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의 개수

		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		for (Meeting meeting : getSchedule(meetings)) {
			System.out.println(meeting);
		}
		
	}
	
	static ArrayList<Meeting> getSchedule(Meeting[] meetings) {
		
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		
		Arrays.sort(meetings); // 종료시간 기준 오름차순 정렬
		list.add(meetings[0]); // 첫 번째 회의 무조건 처음에 추가
		
		for (int i = 0, size=meetings.length; i < size; i++) {
			// 이전 회의 종료 시간 <= 시작 시간 -> 회의실 배정 가능
			if(list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}

}
