/*  Name: <Ali Rashidinejad>
 *  COSC 311  FA19
 *  hw0912
 *  URL:  https://github.com/arashidi21/COSC311
 */

public class SinglyLinkedList {
	private class Node{
		private int data;
		private Node next;
		
		public Node() {
			this(0, null);
		}
		
		public Node(int data) {
			this(data, null);
		}
		
		public Node (int data, Node next) {
			this.data=data;
			this.next=next;
		}
	}
	
	Node head, tail=null;
	
	public void insert(int i) {
		if(isEmpty()) {
			head=new Node(i);
			tail=head;
		}
		else {
			if(head.data<i && tail==head
			|| tail.data<i) {
				tail.next=new Node(i);
				tail=tail.next;
			}
			else if(head.data>=i) {
				head=new Node(i, head);
			}
			else {
				Node p, q;
				for(p=head, q=head.next; 
					q.data<i && q.next!=null; 
					p=p.next, q=q.next);
				Node insertion=new Node (i, q);
				p.next=insertion;
			}
		}
	}
	
	public void delete(int i) {
		if(!isEmpty()) {
			if(head==tail && head.data==i) {
				head=tail=null;
			}
			else if(head.data==i) {
				head=head.next;
			}
			else {
				Node p, q;
	            for (p=head, q=head.next; 
	                 q!=null && !(q.data==i); 
	                 p=p.next, q=q.next) ;
	            if (q!=null) {
	               p.next=q.next;
	               if (q==tail )
	                  tail=p;
	            }
			}
		}
	}
	
	public String toString() {
		String s="";
		if(head==null) {
			return "Empty String";
		}
		for(Node p=head; p!=null; p=p.next) {
			s+= p.data +" ";
		}
		return s;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		System.out.println("Execution begun");
		System.out.println("initial list: " + list);

		list.insert(3);
		list.insert(5);
		System.out.println(list);

		list.insert(2);
		list.insert(2);
		list.insert(2);
		list.insert(7);
		list.insert(6);
		System.out.println("list after inserts: " + list);

		list.delete(2);
		list.delete(5);
		list.delete(7);
		System.out.println("list after deletes: " + list);

		System.out.println("Execution terminated");
	}
}

