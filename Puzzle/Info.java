package Puzzle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**This Class is used while Search is working to return info**/

public class Info {
	/**This Class has the structure for Queue & Stack (Built in jar) **/
	public Queue<BoardNode> queue;
	public Stack<BoardNode> stack;
	public PriorityQueue<BoardNode> pQueue;
	public int time;
	private int maxQueueSize;
	public HashMap<Integer, BoardNode> visited; // used to check if a Node is Already visited
	

	/*This Method just creates objects of Queue , Stack , LinkedList and Hashmap*/
	public Info() {
		queue = new LinkedList<BoardNode>();
		stack = new Stack<BoardNode>();
		pQueue = new PriorityQueue<BoardNode>();
		time = 0;
		maxQueueSize = 0;
		visited = new HashMap<Integer, BoardNode>();
	}


	/*timer method that begins timer*/
	public void incTime() {
		time += 1;// Increments time by 1
	} // There is a problem in time it is not working as it should be but this is an extra thing i added sooooooo....
	
	public void stackSize() {   //queueSize() but for stack
		if(stack.size()>maxQueueSize) {
			maxQueueSize = stack.size();
		}
	}
	
	public int getTime() { //time is returned
		return time;
	} // will be used later to determine time taken
	// There is a problem in time it is not working as it should be but this is an extra thing i added sooooooo....
	
}
