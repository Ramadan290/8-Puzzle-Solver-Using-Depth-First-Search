package Puzzle;

import java.util.List;

/**This Class performs the Algorithm Using the Stack Method**/
public class DFS implements Search {
	private BoardNode initialNode;
	
	//DFS constructor that creates the DFS object
	
	public DFS(BoardNode node) {
		this.initialNode = node;
	}


	public void search() {
		Info info = new Info();
		
		BoardNode node = initialNode;
		info.stack.push(node);  // a stack is used to ensure LIFO

		//popping from stack
		while(!(info.stack.isEmpty())) {
			
			 node = info.stack.pop();
			 info.incTime();
			 info.visited.put(node.hashCode(), node);


			 //printing in case we reach goal
			if (node.isGoal()) {
				Paths_Taken p = new Paths_Taken(initialNode, node,info);
				p.printPath();
				return;
			}


			/*Pushing into stack if there is no duplicate children (I asked about this during the section and you said you don't need to write the duplicates and you can neglect them)
			 , I asked about this issue during the example of getting to Bucharest from a MAP*/
			States_Controller s = new States_Controller();
			List<BoardNode> list = s.state_controller(node);
			for(BoardNode temp: list) {
				boolean ans = info.visited.containsKey(temp.hashCode());
				if(ans==false ){
					if(!(info.stack.contains(temp))) { //checking the stack for duplicate children
						info.stack.push(temp);
						info.stackSize();
					}
					
				}
			}
			
		}

	}
}
