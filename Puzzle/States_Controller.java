package Puzzle;

import java.util.ArrayList;
import java.util.List;

/**This Class contains and controls the states that could occur from each Node
 * using a recursive strategy in Movement**/
public class States_Controller {

	public States_Controller() {
		
	}

	//successor function that takes a state and returns a list of possible states that can be reached
	public List<BoardNode> state_controller(BoardNode node) {
		//successor function that takes a state and returns a list of possible states that can be reached
		
		List<BoardNode> list = new ArrayList<BoardNode>();
		
		int row = node.getRowBlank();
		int col = node.getColBlank();


		//The upcoming section is used to detect the 0 movement(4 out of 5 marks here important Part)

		//all 4 cases listed below

		//up
		if((col !=0 || col != 1 || col != 2) && (row !=0) ) {
			BoardNode upNode = node.createChild(row-1, col);
			upNode.setDir(Directions.UP);
			list.add(upNode);

		}
		
		//down
		if((col !=0 || col != 1 || col != 2) && (row !=2) ) {
			BoardNode downNode = node.createChild(row+1, col);
			downNode.setDir(Directions.DOWN);
			list.add(downNode);
		}
		
		//right
		if((row != 0 || row != 1 || row != 2) && (col !=2)) {
			BoardNode rightNode = node.createChild(row, col+1);
			rightNode.setDir(Directions.RIGHT);
			list.add(rightNode);
		}
		
		//left
		if((row != 0 || row != 1 || row != 2) && (col !=0)) {
			BoardNode leftNode = node.createChild(row, col-1); // a child is created if the zero tile can move left.
			leftNode.setDir(Directions.LEFT);
			list.add(leftNode);
		}
		
		return list;  // a list of children is returned. (Recursion) ///
		 
	}
}
