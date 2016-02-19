//Simon Whitelaw
//Implementation of Queue ADT with LinkedList
public class QueueLi<E>{
	//constructor
	public QueueLi(){
		beginMarker = new Node<>(null, null);
		backOfQueue = new Node<>(null, beginMarker);
		theSize = 0;
	}
	//The run time of enqueue(x) is Theta(1) since it only requires a constant
	//number of actions to add an item to the queue regardless of the size
	public void enqueue(E x){
		Node<E> node = new Node<>(x, null);
		backOfQueue.next.next = node;
		backOfQueue.next = node;
		theSize++;
	}
	//The run time of dequeue is Theta(1) again since it only requires a 
	//constant number of actions to dequeue an item regardless of the size
	public E dequeue(){
		if(this.isEmpty())
			return null;
		E toReturn = beginMarker.next.element;
		if(theSize == 1)
			backOfQueue.next = beginMarker;
		beginMarker.next = beginMarker.next.next;
		theSize--;
		return toReturn;
	}
	//The run time of getFront is Theta(1) since the front is always at
	//index 0 and getting the 0th index takes constant time.
	public E getFront(){
		if(theSize == 0)
			return null;
		return beginMarker.next.element;
	}
	//The run time of isEmpty is Theta(1) since we are simply
	//checking if the current size of the queue is 0
	public Boolean isEmpty(){
		return (theSize == 0);
	}
	
	private static class Node<E>{
		//constructor
		public Node(E x, Node<E> node){
			element = x;
			next = node;
		}
		
		public E element;
		public Node<E> next;
	}
	
	private Node<E> beginMarker;
	private Node<E> backOfQueue;
	private int theSize;
	
	
	public static void main(String[] args) {
		QueueLi<Integer> myQueue = new QueueLi<>();
		System.out.println("Empty queue? "+myQueue.isEmpty());
		System.out.println("front of Empty Queue: "+myQueue.getFront());
		for(int i=0; i<5; i++)
			myQueue.enqueue(i);
		System.out.println("Front after 0-4 have been added: "+myQueue.getFront());
		System.out.println("Empty queue? "+myQueue.isEmpty());
		for(int i=0; i<5; i++)
			System.out.println("Item dequeued: "+myQueue.dequeue());
		System.out.println("Dequeue from Empty Queue: "+myQueue.dequeue());

	}

}
