public class Queue {
	int queue []=new int[10];
	int size;
	int head;
	int tail;
	
	public Queue() {
		head=tail=0;
	}
	
	public void enQueue(int data) {
		queue[tail] =data;
		tail=(tail+1)%10;
		size++;
	}
	
	public int deQueue() {
		int data=queue[head];
		head=(head+1)%10;
		size--;
		return data;
	}
	
	private boolean isEmpty() {
		return size==0;
	}
	
	
	public String toString() {
		String s="";
		for(int i=0; i<size; i++) {
			s+=queue[(head+i)%10]+" ";
		}
		return s;
	}
	public static Queue queueSorting1(Queue q) {
		Queue q1=new Queue();
		int min,next, count;
		next=q.deQueue();
		while(!q.isEmpty()) {
			q1.enQueue(next);
			next=q.deQueue();
		}
		q1.enQueue(next);
		while(!q1.isEmpty()) {
			min=q1.deQueue();
			count=q1.size;
			while(count!=0) {
				next=q1.deQueue();
				if(min>next) {
					q1.enQueue(min);
					min=next;
				}
				else {
					q1.enQueue(next);
					count=count-1;
				}
			}
			q.enQueue(min);
		}
		return q;
	}

	public static Queue queueSorting2(Queue q) {
		Queue q1=new Queue();
		Queue q2=new Queue();
		int temp=q.deQueue();
		int next=0;
		int min=0;
		while(!q.isEmpty()) {
			q1.enQueue(temp);
			temp=q.deQueue();
		}
		q1.enQueue(temp);
		while(!(q1.isEmpty() && q2.isEmpty())) {
			min=q1.deQueue();
			while(!q1.isEmpty()) {
				next=q1.deQueue();
				if(min>next) {
					q2.enQueue(min);
					min=next;
				}
				else {
					q2.enQueue(next);
					q.enQueue(min);
					min=q2.deQueue();
				}
			}
			while(!q2.isEmpty()) {
				next=q2.deQueue();
				if(min>next) {
					q2.enQueue(min);
					min=next;
				}
				else {
					q1.enQueue(next);
					q.enQueue(min);
				}
			}
		}
		q.enQueue(next);
		return q;
	}
	public static void main(String [] args) {
		Queue q=new Queue();
		q.enQueue(5);
		System.out.println(q);
		q.enQueue(4);
		q.enQueue(3);
		q.enQueue(7);
		q.enQueue(6);
		q.enQueue(2);
		System.out.println("Intialized: "+q);
		System.out.println(Queue.queueSorting1(q));
		System.out.println(Queue.queueSorting2(q));
		System.out.println("First: "+q);
	}
}
