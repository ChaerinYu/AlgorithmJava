package etc;

public class SinglyLinkedList {
	
	private Node head; // 첫 번째 노드를 저장 (헤드=첫 번째 노드)
	
	// 첫 번째 노드로 삽입하기
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	// 마지막 노드 찾기
	public Node getLastNode() {
		// 첫 노드부터 마지막 노드까지
		for(Node currNode=head; currNode != null; currNode = currNode.link) {
			if(currNode.link == null) { // 뒤에 아무도 없으면 자신이 막내
				return currNode;
			}
		}
		return null;
	}
	
	// 마지막 노드로 삽입하기
	public void addLastNode(String data) {
		
		if(head == null) {
			// 공백리스트
			addFirstNode(data);
			return;
		} else {
			// link null을 찾아서 
			Node lastNode = getLastNode();
			Node newNode = new Node(data);
			lastNode.link = newNode;
		}
	}
	
	public void insertAfterNode(Node preNode, String data) {
		if(preNode == null) {
			System.out.println("선행노드가 없어 삽입이 불가능합니다.");
			return;
		}
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
	}
	
	// data를 데이터로 갖고 있는 처음 만나는 노드 리턴
	public Node getNode(String data) {
		for(Node currNode=head; currNode != null; currNode = currNode.link) {
			if(currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}
	
	// target의 이전노드 찾기
	public Node getPreviousNode(Node target) {
		for(Node currNode=head; currNode != null; currNode = currNode.link) {
			if(currNode.link == target) {
				return currNode;
			}
		}
		return null;
	}
	
	// data를 갖고 있는 첫 번째 노드 찾아 삭제
	public void deleteNode(String data) {
		Node targetNode = getNode(data);
		if(targetNode == null) {
			System.out.println("삭제할 노드가 없어서 삭제가 불가능합니다.");
			return;
		}
		
		Node preNode = getPreviousNode(targetNode);
		
		if(preNode == null) {
			// target이 head인 상황
			head = targetNode.link;
		} else {
			preNode.link = targetNode.link;
		}
		targetNode.link = null;
	}
	
	public void printList() {
		System.out.print("L = ( ");
		for(Node currNode=head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data+" ");
		}
		System.out.println(" ) ");
	}
	
	// empty는 head가 null인지만 체크만해도 된다.
}
